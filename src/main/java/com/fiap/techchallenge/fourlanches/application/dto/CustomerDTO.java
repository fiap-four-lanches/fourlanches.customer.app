package com.fiap.techchallenge.fourlanches.application.dto;

import com.fiap.techchallenge.fourlanches.adapter.driven.data.entities.CustomerJpaEntity;
import com.fiap.techchallenge.fourlanches.domain.entities.Customer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @Email
    private String email;

    @Size(min = 11, max = 11, message = "invalid document size, it should have 11 characters")
    private String document;

    @NotEmpty
    private String address;

    @NotEmpty
    private String phoneNumber;

    public CustomerJpaEntity toEntity() {
        return CustomerJpaEntity.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .document(document)
                .address(address)
                .phoneNumber(phoneNumber)
                .build();
    }
    public Customer toCustomer() {
        return Customer.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .document(document)
                .address(address)
                .phoneNumber(phoneNumber)
                .build();
    }
}


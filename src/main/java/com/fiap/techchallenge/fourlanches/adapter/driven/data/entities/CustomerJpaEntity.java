package com.fiap.techchallenge.fourlanches.adapter.driven.data.entities;

import com.fiap.techchallenge.fourlanches.domain.entities.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "customers")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String document;
    private String address;
    private String phoneNumber;

    public Customer getCustomerEntity() {
        return Customer.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .document(document)
                .address(address)
                .phoneNumber(phoneNumber)
                .build();
    }

    public static CustomerJpaEntity toEntity(Customer customer) {
        return CustomerJpaEntity.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .document(customer.getDocument())
                .address(customer.getAddress())
                .phoneNumber(customer.getPhoneNumber())
                .build();
    }
}

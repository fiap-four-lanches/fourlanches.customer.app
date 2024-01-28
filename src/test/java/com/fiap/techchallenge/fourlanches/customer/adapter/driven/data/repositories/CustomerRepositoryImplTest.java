package com.fiap.techchallenge.fourlanches.customer.adapter.driven.data.repositories;

import com.fiap.techchallenge.fourlanches.adapter.driven.data.CustomerJpaRepository;
import com.fiap.techchallenge.fourlanches.adapter.driven.data.entities.CustomerJpaEntity;
import com.fiap.techchallenge.fourlanches.adapter.driven.data.repositories.CustomerRepositoryImpl;
import com.fiap.techchallenge.fourlanches.application.exception.CustomerNotFoundException;
import com.fiap.techchallenge.fourlanches.domain.entities.Customer;
import com.fiap.techchallenge.fourlanches.domain.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerRepositoryImplTest {

    public static final String CUSTOMER_DOC = "1234567890";
    @Mock
    private CustomerJpaRepository jpaRepository;

    private CustomerRepository customerRepository;

    @BeforeEach
    public void setup() {
        this.customerRepository = new CustomerRepositoryImpl(jpaRepository);
    }

    @Test
    public void shouldCreateCustomer() {
        when(jpaRepository.save(any(CustomerJpaEntity.class))).thenReturn(getDefaultCustomerEntity());

        Customer expectedCustomer = customerRepository.saveCustomer(getDefaultCustomerEntity());

        verify(jpaRepository).save(eq(getDefaultCustomerEntity()));
        assertThat(expectedCustomer).isNotNull();
    }
    @Test
    public void shouldGetCustomerByDocument() {
        when(jpaRepository.findByDocument(eq(CUSTOMER_DOC)))
                .thenReturn(Optional.of(getDefaultCustomerEntity()));

        Customer expectedCustomer = customerRepository.getCustomerByDocument(CUSTOMER_DOC);

        assertThat(expectedCustomer.getDocument()).isEqualTo(getDefaultCustomerEntity().getDocument());
    }
    @Test
    public void shouldThrowProductNotFoundWhenGetProductByIdDoesNotExist() {
        assertThrows(CustomerNotFoundException.class, () -> customerRepository.getCustomerByDocument(CUSTOMER_DOC));
    }

    private static CustomerJpaEntity getDefaultCustomerEntity() {
        return CustomerJpaEntity.builder()
                .firstName("Ada").lastName("Lovalace")
                .document("1234567890").email("adalovela@fourlanches.com")
                .build();
    }

}

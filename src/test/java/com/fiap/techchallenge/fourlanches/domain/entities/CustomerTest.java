package com.fiap.techchallenge.fourlanches.domain.entities;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CustomerTest {

    @Test
    public void shouldReturnCustomerWhenCustomerIsFilled() {
        Customer customer = Customer.builder()
                .firstName("Ada").lastName("Lovalace")
                .document("1234567890").email("adalovela@fourlanches.com")
                .build();

        assertThat(customer).isNotNull();

    }
}

package com.fiap.techchallenge.fourlanches.application.usecases;

import com.fiap.techchallenge.fourlanches.application.dto.CustomerDTO;
import com.fiap.techchallenge.fourlanches.application.exception.CustomerSaveException;
import com.fiap.techchallenge.fourlanches.domain.entities.Customer;
import com.fiap.techchallenge.fourlanches.domain.repositories.CustomerRepository;
import com.fiap.techchallenge.fourlanches.domain.usecases.CustomerUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerUseCaseImplTest {

    private static final String CUSTOMER_DOC = "1234567890";
    @Mock
    private CustomerRepository customerRepository;

    private CustomerUseCase customerUseCase;

    @BeforeEach
    void setUp() {
        customerUseCase = new CustomerUseCaseImpl(customerRepository);
    }

    @Test
    void givenDoc_whenGetCustomerByDoc_thenReturnProduct() {
        Customer customer = getCustomerDTO().toCustomer();
        when(customerRepository.getCustomerByDocument(CUSTOMER_DOC)).thenReturn(customer);

        Customer actualCustomer = customerUseCase.getCustomerByDocument(CUSTOMER_DOC);

        assertThat(actualCustomer).isEqualTo(customer);
    }
    @Test
    void givenProductToBeCreated_whenCreateIsSuccessful_ThenReturnId() {
        when(customerRepository.saveCustomer(getCustomerDTO().toEntity())).thenReturn(getCustomer());

        Customer expectedCustomer = customerUseCase.saveCustomer(getCustomerDTO());

        assertThat(expectedCustomer).isEqualTo(getCustomer());
    }
    @Test
    void givenCustomerToBeCreated_whenCreateFails_ThenError() {
        when(customerRepository.saveCustomer(any())).thenThrow(IllegalArgumentException.class);
        assertThrows(CustomerSaveException.class,
                () -> customerUseCase.saveCustomer(getInvalidCustomerDTO()));
    }
    private CustomerDTO getCustomerDTO() {
        return CustomerDTO.builder()
                .firstName("Ada")
                .lastName("Lovalace")
                .document("1234567890")
                .email("adalovela@fourlanches.com")
                .build();
    }

    private Customer getCustomer() {
        return Customer.builder()
                .firstName("Ada")
                .lastName("Lovalace")
                .document("1234567890")
                .email("adalovela@fourlanches.com")
                .build();
    }

    private CustomerDTO getInvalidCustomerDTO() {
        return CustomerDTO.builder()
                .firstName(null)
                .build();
    }

}

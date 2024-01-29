package com.fiap.techchallenge.fourlanches.adapter.driver.api.controllersAdvisor;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerControllerAdvisorTest {

  @Test
  void shouldHandleCustomerNotFoundException() {
    var expectedErrorMessage = new ApiErrorMessage(HttpStatus.NOT_FOUND, "customer not found");

    ResponseEntity<ApiErrorMessage> response = new CustomerControllerAdvisor().handleCustomerNotFoundException();

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    assertThat(response.getBody()).isEqualTo(expectedErrorMessage);
  }

  @Test
  void shouldHandleCustomerSaveException() {
    var expectedErrorMessage = new ApiErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, "could not save customer");

    ResponseEntity<ApiErrorMessage> response = new CustomerControllerAdvisor().handleCustomerSaveException();

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    assertThat(response.getBody()).isEqualTo(expectedErrorMessage);
  }
}
package com.fiap.techchallenge.fourlanches.customer.adapter.driver.api.controllersAdvisor;

import com.fiap.techchallenge.fourlanches.adapter.driver.api.controllersAdvisor.ApiErrorMessage;
import com.fiap.techchallenge.fourlanches.adapter.driver.api.controllersAdvisor.GeneralControllerAdvisor;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class GeneralControllerAdvisorTest {
    @Test
    public void shouldHandleInternalServerErrorException() {
        var expectedErrorMessage = new ApiErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, "an error happened");

        ResponseEntity<ApiErrorMessage> response = new GeneralControllerAdvisor().handleInternalServerErrorException(null);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        assertThat(response.getBody()).isEqualTo(expectedErrorMessage);
    }
}

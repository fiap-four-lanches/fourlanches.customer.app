package com.fiap.techchallenge.fourlanches.adapter.driver.api.controllersAdvisor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ApiErrorMessage {

    private HttpStatus status;
    private List<String> errors;

    public ApiErrorMessage(HttpStatus status, String error) {
        super();
        this.status = status;
        errors = Collections.singletonList(error);
    }

}

package com.fiap.techchallenge.fourlanches.application.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CustomerNotFoundException  extends RuntimeException {
    public CustomerNotFoundException() {
    }

}

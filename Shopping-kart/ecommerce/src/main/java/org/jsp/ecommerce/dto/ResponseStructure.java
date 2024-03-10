package org.jsp.ecommerce.dto;

import lombok.Data;

@Data
public class ResponseStructure<T> {
    private String message;
    private int statusCode;
    private T data;
}

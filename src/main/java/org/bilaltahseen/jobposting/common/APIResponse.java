package org.bilaltahseen.jobposting.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class APIResponse<T> {
    private String message;
    private HttpStatus status;
    private T data;

    public APIResponse(String message, HttpStatus status, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }


    public APIResponse(String message, HttpStatus status) {
        this.status = status;
        this.message = message;
    }
}

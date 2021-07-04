package com.deepak.common.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BasicRdo<T> {

    public boolean status;

    public String message;

    public T data;

    public BasicRdo() {

    }

    public ResponseEntity<BasicRdo> getResponse(String message, HttpStatus reponseStatus, T object) {

        BasicRdo<T> basicRdo = new BasicRdo();
        basicRdo.message = message;

        if (object == null) {
            basicRdo.status = false;
        } else {
            basicRdo.status = true;
            basicRdo.data = object;
        }

        return new ResponseEntity<BasicRdo>(basicRdo, reponseStatus);

    }
}

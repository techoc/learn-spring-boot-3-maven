package cn.techoc.learnvalidationdemo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponseEntity {
    private int code;
    private String message;
}

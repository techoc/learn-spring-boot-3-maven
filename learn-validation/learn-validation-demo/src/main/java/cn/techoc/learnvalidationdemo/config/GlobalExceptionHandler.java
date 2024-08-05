package cn.techoc.learnvalidationdemo.config;

import cn.techoc.learnvalidationdemo.exception.ErrorResponseEntity;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ErrorResponseEntity runtimeExceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response) {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return new ErrorResponseEntity(400, StringUtils.hasLength(e.getMessage()) ? e.getMessage() : "操作失败");
    }
}

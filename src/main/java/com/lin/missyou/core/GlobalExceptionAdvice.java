package com.lin.missyou.core;

import com.lin.missyou.core.configuration.ExceptionCodeConfiguration;
import com.lin.missyou.exception.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionAdvice {
    @Autowired
    private ExceptionCodeConfiguration codeConfiguration;
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public UnifyResponse handleException(HttpServletRequest req,Exception e){
        UnifyResponse message = new UnifyResponse(9999, "服务器异常", req.getMethod()+" "+req.getRequestURI());
        return message;
    }

    @ExceptionHandler(value = HttpException.class)
    public ResponseEntity<UnifyResponse> handleHttpException(HttpServletRequest req, HttpException e){
        System.out.println("httpExevption");
        UnifyResponse message = new UnifyResponse(e.getCode(), codeConfiguration.getMessage(e.getCode()), req.getMethod()+" "+req.getRequestURI());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpStatus status = HttpStatus.resolve(e.getHttpStatusCode());
        ResponseEntity<UnifyResponse> r = new ResponseEntity<UnifyResponse>(message,httpHeaders,status);
        return r;
        
    }
}

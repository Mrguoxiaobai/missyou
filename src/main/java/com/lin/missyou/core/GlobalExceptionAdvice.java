package com.lin.missyou.core;

import com.lin.missyou.core.configuration.ExceptionCodeConfiguration;
import com.lin.missyou.exception.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionAdvice {
    @Autowired
    private ExceptionCodeConfiguration codeConfiguration;

    /**
     * 处理服务器异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public UnifyResponse handleException(HttpServletRequest req,Exception e){
        UnifyResponse message = new UnifyResponse(9999, "服务器异常", req.getMethod()+" "+req.getRequestURI());
        return message;
    }

    /**
     * 处理http请求异常
     *@param req
     * @param e
     * @return
     */
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

    /**
     * 处理参数异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public UnifyResponse handleBeanValidation(HttpServletRequest req,MethodArgumentNotValidException e){
        List<ObjectError> Errors = e.getBindingResult().getAllErrors();
        String message = this.formatAllErrors(Errors);
        return new UnifyResponse(10001,message,req.getMethod()+" "+req.getRequestURI());
    }

    /**
     * 处理url参数异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public UnifyResponse handleConstraintViolationException(HttpServletRequest req,ConstraintViolationException e){
        String message = e.getMessage();
        return new UnifyResponse(10001,message, req.getMethod()+" "+req.getRequestURI());
    }

    /*
        格式化 异常信息
    */
    private String formatAllErrors(List<ObjectError> errors){
        StringBuffer errormsg = new StringBuffer();
        errors.forEach(error->errormsg.append("["+error.getDefaultMessage()+"]"));
        return errormsg.toString();
    }
}

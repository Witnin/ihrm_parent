package com.wsy.common.handler;

import com.sun.deploy.net.HttpResponse;
import com.wsy.common.entity.Result;
import com.wsy.common.entity.ResultCode;
import com.wsy.common.exception.CommonException;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 1、自定义的公共异常处理器
 * 2、声明异常处理器
 * 3、对异常统一处理
 */
@ControllerAdvice
public class BaseExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(HttpServletRequest httpRequest, HttpServletResponse httpResponse, Exception exception){
        if(exception.getClass() == CommonException.class){
            CommonException commonException  = (CommonException) exception;
            Result result = new Result(commonException.getResultCode());
            return result;

        }
        else{

            Result result = new Result(ResultCode.SERVER_ERROR);
            return result;
        }

    }
}

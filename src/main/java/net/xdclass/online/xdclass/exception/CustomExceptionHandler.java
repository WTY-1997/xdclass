package net.xdclass.online.xdclass.exception;

import net.xdclass.online.xdclass.utils.JsonData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理类
 */
@ControllerAdvice //通过该注解实现全局异常处理
public class CustomExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody //返回json字符串
    public JsonData handler(Exception e) {
        if (e instanceof XDException) {
            XDException xdException = (XDException) e;
            return JsonData.bulidError(xdException.getCode(), xdException.getMsg());
        } else {
            return JsonData.bulidError("未知异常");
        }
    }
}

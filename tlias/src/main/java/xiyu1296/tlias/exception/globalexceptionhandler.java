package xiyu1296.tlias.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xiyu1296.tlias.pojo.Result;

@RestControllerAdvice
public class globalexceptionhandler {

    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception e)
    {
        e.printStackTrace();
        return Result.error("服务器异常");
    }
}

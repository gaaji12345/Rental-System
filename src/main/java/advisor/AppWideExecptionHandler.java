package advisor;/*  gaajiCode
    99
    07/09/2024
    */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import util.ResPonceUTIL;

@RestControllerAdvice//instaruction ekak hambenkn inwa run wenkn balagena ina
@CrossOrigin
public class AppWideExecptionHandler {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//set status to 500
    @ExceptionHandler({RuntimeException.class})
    public ResPonceUTIL handleAllRuntimeExceptions(RuntimeException e){
        return new ResPonceUTIL(400,e.getMessage(),null);
    }
}

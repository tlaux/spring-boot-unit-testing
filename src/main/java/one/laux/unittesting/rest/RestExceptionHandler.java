package one.laux.unittesting.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class RestExceptionHandler {

  @ExceptionHandler(ArticleNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public RestErrorResponse handleException(ArticleNotFoundException exception) {
    return new RestErrorResponse(exception.getMessage());
  }


  /**
   * Default handling for exceptions.
   */
  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public RestErrorResponse handleException(Exception exception) {
    return new RestErrorResponse("Unknown error");
  }

}

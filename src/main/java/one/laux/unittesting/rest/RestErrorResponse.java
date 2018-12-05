package one.laux.unittesting.rest;

import lombok.Data;

@Data
public class RestErrorResponse {

  public RestErrorResponse(String message) {
    this.message = message;
  }

  private String message;

}

package one.laux.unittesting.rest;

public class ArticleNotFoundException extends Exception {

  private static final long serialVersionUID = -8344805817026409785L;

  public ArticleNotFoundException(String message) {
    super(message);
  }

}

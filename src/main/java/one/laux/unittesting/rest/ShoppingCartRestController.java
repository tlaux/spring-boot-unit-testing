package one.laux.unittesting.rest;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import one.laux.unittesting.entity.Article;
import one.laux.unittesting.entity.ShoppingCartItem;
import one.laux.unittesting.repository.ArticleRepository;
import one.laux.unittesting.service.CurrencyService;
import one.laux.unittesting.service.ShoppingCartServiceNoDB;

@RestController
public class ShoppingCartRestController {

  @Autowired
  private ArticleRepository articleRepository;

  @Autowired
  private ShoppingCartServiceNoDB shoppingCart;

  @GetMapping(path = "/articles")
  public HttpEntity<List<Article>> getAllArticles() {
    return new ResponseEntity<>(articleRepository.findAll(), HttpStatus.OK);
  }

  @GetMapping(path = "/shoppingcart")
  public HttpEntity<List<ShoppingCartItem>> getShoppingCart() {
    return new ResponseEntity<>(shoppingCart.getContents(), HttpStatus.OK);
  }

  @PostMapping(path = "/shoppingcart/article/{articleid}/amount/{amount}")
  public HttpEntity<ShoppingCartItem> addArticleToShoppingCart(@PathVariable(name = "articleid", required = true) Long articleId,
      @PathVariable(name = "amount", required = false) Integer amount) throws ArticleNotFoundException {
    return new ResponseEntity<>(shoppingCart.add(articleId, amount), HttpStatus.CREATED);
  }

  @DeleteMapping(path = "/shoppingcart/article/{articleid}")
  public HttpEntity<ShoppingCartItem> removeArticleFromShoppingCart(@PathVariable(name = "articleid", required = true) Long articleId) {
    return new ResponseEntity<>(shoppingCart.remove(articleId), HttpStatus.OK);
  }

  @GetMapping(path = "/shoppingcart/value")
  public HttpEntity<Double> getShoppingCartValue(Optional<String> currency) {
    if (currency.isPresent()) {
      return new ResponseEntity<>(shoppingCart.getValue(currency.get()), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(shoppingCart.getValue(CurrencyService.DEFAULT_CURRENCY), HttpStatus.OK);
    }
  }

}

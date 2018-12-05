package one.laux.unittesting.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import one.laux.unittesting.entity.Article;
import one.laux.unittesting.entity.ShoppingCartItem;
import one.laux.unittesting.repository.ArticleRepository;
import one.laux.unittesting.rest.ArticleNotFoundException;

@Service
public class ShoppingCartServiceNoDB {

  private List<ShoppingCartItem> content = new ArrayList<>();

  /*
   * Demonstration of a test with a Spy and a Mock.
   */

  @Autowired
  private CurrencyService currencyService;

  @Autowired
  private ArticleRepository articleRepository;

  public List<ShoppingCartItem> getContents() {
    return content;
  }

  public ShoppingCartItem add(@NotNull Long articleId, Integer amount) throws ArticleNotFoundException {
    Optional<Article> found = articleRepository.findById(articleId);
    if (found.isPresent()) {
      ShoppingCartItem s = new ShoppingCartItem(articleId, amount, found.get().getPrice());
      content.add(s);
      return s;
    } else {
      throw new ArticleNotFoundException("Article with id: " + articleId + " was not found. Not added to cart.");
    }
  }

  public ShoppingCartItem remove(@NotNull Long articleId) {
    return null;
  }

  public Double getValue(String currency) {
    Double value = 0.0;
    for (ShoppingCartItem item : content) {
      value += (item.getSinglePrice() * item.getAmount());
    }
    // TODO currency from CurrencyService
    return value;
  }

}

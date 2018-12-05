package one.laux.unittesting.service;

import java.util.List;
import java.util.Optional;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import one.laux.unittesting.entity.Article;
import one.laux.unittesting.entity.ShoppingCartItem;
import one.laux.unittesting.repository.ArticleRepository;
import one.laux.unittesting.repository.ShoppingCartRepository;
import one.laux.unittesting.rest.ArticleNotFoundException;

@Service
public class ShoppingCartServiceWithDB {

  private ArticleRepository articleRepository;
  private ShoppingCartRepository shoppingCartRepository;

  @Autowired
  public ShoppingCartServiceWithDB(ArticleRepository articleRepository, ShoppingCartRepository shoppingCartRepository) {
    this.articleRepository = articleRepository;
    this.shoppingCartRepository = shoppingCartRepository;
  }

  public List<ShoppingCartItem> getContents() {
    return shoppingCartRepository.findAll();
  }

  public ShoppingCartItem add(@NotNull Long articleId, Integer amount) throws ArticleNotFoundException {
    Optional<Article> found = articleRepository.findById(articleId);
    if (found.isPresent()) {
      ShoppingCartItem s = new ShoppingCartItem(articleId, amount, found.get().getPrice());
      shoppingCartRepository.save(s);
      return s;
    } else {
      throw new ArticleNotFoundException("Article with id: " + articleId + " was not found. Not added to cart.");
    }
  }

  public ShoppingCartItem remove(@NotNull Long articleId) {
    return null;
  }

  public Double getValue(String currency) {
    return null;
  }

}

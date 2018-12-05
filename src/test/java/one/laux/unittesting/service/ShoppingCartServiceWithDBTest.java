package one.laux.unittesting.service;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import one.laux.unittesting.entity.ShoppingCartItem;
import one.laux.unittesting.repository.ArticleRepository;
import one.laux.unittesting.repository.ShoppingCartRepository;
import one.laux.unittesting.service.ShoppingCartServiceWithDB;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import({ShoppingCartServiceWithDB.class})
public class ShoppingCartServiceWithDBTest {

  // This can be used in every DataJpaTest to access (and prepare) the database directly.
  @Autowired
  private TestEntityManager entityManager;

  // Even though these two are not used within this class, the autowiring is required her
  // to make the repos available within the unit-tests application context.
  @Autowired
  private ShoppingCartRepository scr;
  @Autowired
  private ArticleRepository ar;

  // CLASS UNDER TEST
  @Autowired
  private ShoppingCartServiceWithDB shoppingCartService;

  private ShoppingCartItem s1;
  private ShoppingCartItem s2;

  @Before
  public void setup() {
    s1 = new ShoppingCartItem();
    s1.setArticleId(4711L);
    s1.setAmount(2);
    s1.setSinglePrice(10.0);

    s2 = new ShoppingCartItem();
    s2.setArticleId(4712L);
    s2.setAmount(1234);
    s2.setSinglePrice(2.5);
  }

  @Test
  public void getFilledShoppingCartSuccess() {
    // Only put s1 into database
    entityManager.persist(s1);

    List<ShoppingCartItem> resultList = shoppingCartService.getContents();

    assertEquals(1, resultList.size());
    ShoppingCartItem result = resultList.get(0);
    assertEquals(Long.valueOf(4711L), result.getArticleId());
  }

}

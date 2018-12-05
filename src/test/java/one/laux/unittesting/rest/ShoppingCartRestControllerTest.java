package one.laux.unittesting.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import lombok.extern.slf4j.Slf4j;
import one.laux.unittesting.entity.Article;
import one.laux.unittesting.repository.ArticleRepository;
import one.laux.unittesting.service.ShoppingCartServiceWithDB;

@RunWith(MockitoJUnitRunner.class)
@Slf4j
public class ShoppingCartRestControllerTest {

  private MockMvc mockMvc;

  @Mock
  private ArticleRepository articleRepository;

  @Mock
  private ShoppingCartServiceWithDB shoppingCartService;

  @InjectMocks
  private ShoppingCartRestController shoppingCartRestController;

  private Article a1;
  private Article a2;

  @Before
  public void setup() {
    mockMvc =
        MockMvcBuilders.standaloneSetup(shoppingCartRestController).setMessageConverters(new MappingJackson2HttpMessageConverter()).build();

    // Setup some articles
    a1 = new Article();
    a1.setArticleId(4711L);
    a1.setDescription("Seepferdchen");
    a1.setLongDescription("Ein Seepferdchen im Kopfstand");

    a2 = new Article();
    a2.setArticleId(4712L);
    a2.setDescription("Gartenzwerg");
    a2.setLongDescription("Grim Reaper mit Sonnenbrille");
  }

  @Test
  public void testGetAllArticlesWithoutMockMvcSuccess() {

    // List<Article> articleList = Arrays.asList(a1, a2);
    // when(articleRepository.findAll()).thenReturn(articleList);
    //
    // HttpEntity<List<Article>> httpEntity = shoppingCartRestController.getAllArticles();
    //
    // assertNotNull(httpEntity);
    // assertEquals(2, httpEntity.getBody().size());
  }

  @Test
  public void testGetAllArticlesWithMockMvcSuccess() throws Exception {

    // RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/articles");
    //
    // List<Article> articleList = Arrays.asList(a1, a2);
    // when(articleRepository.findAll()).thenReturn(articleList);
    //
    // MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    // log.debug("Result: {}", result.getResponse().getContentAsString());
    //
    // assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    // assertTrue(result.getResponse().getContentType().contains("json"));
    //
    // ObjectMapper objectMapper = new ObjectMapper();
    // List<Article> resultList = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<Article>>() {});
    //
    // assertEquals(2, resultList.size());
  }

}

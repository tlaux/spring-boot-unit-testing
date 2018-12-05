package one.laux.unittesting.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Article {

  @Id
  private Long articleId;

  private String description;
  private String longDescription;
  private double price;

}

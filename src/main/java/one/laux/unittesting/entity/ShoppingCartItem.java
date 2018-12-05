package one.laux.unittesting.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartItem {

  @Id
  private Long articleId;

  private int amount;
  private double singlePrice;

}

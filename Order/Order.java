package Order;

import java.util.Map;

import Produto.Produto;

public class Order {
  public final OrderStrategy orderStrategy;

  public static Map<OrderOptions, OrderStrategy> orderOptions = Map.of(
    OrderOptions.PRECO, new OrderByPrice(),
    OrderOptions.DESCRICAO, new OrderByDescription(),
    OrderOptions.ESTOQUE, new OrderByStock()
  );

  public Order(OrderStrategy orderStrategy, OrderTypes type) {
    orderStrategy.setType(type);
    this.orderStrategy = orderStrategy;
  }

  public boolean compare(Produto o1, Produto o2) {
    return this.orderStrategy.compare(o1, o2);
  }
}

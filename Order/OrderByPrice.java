package Order;

import Produto.Produto;

public class OrderByPrice implements OrderStrategy {
  OrderTypes type;

  public void setType(OrderTypes type) {
    this.type = type;
  }

  public OrderTypes getOrderType() {
    return type;
  }

  public boolean compare(Produto o1, Produto o2) {
    return this.type == OrderTypes.ASC ? o1.getPreco() < o2.getPreco() : o1.getPreco() > o2.getPreco();
  }
}

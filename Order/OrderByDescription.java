package Order;

import Produto.Produto;

public class OrderByDescription implements OrderStrategy {
  OrderTypes type;

  public void setType(OrderTypes type) {
    this.type = type;
  }

  public OrderTypes getOrderType() {
    return type;
  }

  public boolean compare(Produto o1, Produto o2) {
    return this.type == OrderTypes.ASC ? 
      o1.getDescricao().compareToIgnoreCase(o2.getDescricao()) < 0 :
      o1.getDescricao().compareToIgnoreCase(o2.getDescricao()) > 0;
  }
}

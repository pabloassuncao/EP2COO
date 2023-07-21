package Order;

import Produto.Produto;

public interface OrderStrategy {
  public OrderTypes getOrderType();
  public void setType(OrderTypes type);
  public boolean compare(Produto o1, Produto o2);
}

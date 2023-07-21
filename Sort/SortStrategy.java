package Sort;

import java.util.List;

import Order.Order;
import Produto.Produto;

public interface SortStrategy {
  /**
   * Retorna o critério de ordenação
   * @return Critério de ordenação que será utilizado para ordenar a lista de produtos
   */
  public Order getOrder();

  /**
   * Define o critério de ordenação
   * @param order Critério de ordenação que será utilizado para ordenar a lista de produtos
   */
  public void setOrder(Order order);

  /**
   * Ordena uma lista de produtos de acordo com o critério de ordenação
   * @param produtos Lista de produtos a ser ordenada
   * @return
   */
  public List<Produto> ordena(List<Produto> produtos);
}

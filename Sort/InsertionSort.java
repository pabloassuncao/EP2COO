package Sort;

import java.util.List;

import Order.Order;
import Produto.Produto;

public class InsertionSort implements SortStrategy {
  private Order criterio;

  public Order getOrder() {
    return this.criterio;
  }

  public void setOrder(Order order) {
    this.criterio = order;
  }

  public List<Produto> ordena(List<Produto> produtos) {
    List<Produto> produtosOrdenados = produtos;

    for(int i = 0; i < produtosOrdenados.size(); i++){

      Produto x = produtosOrdenados.get(i);
      int j = (i - 1);

      while(j >= 0){
        if( criterio.compare(x, produtosOrdenados.get(j)) ){

          produtosOrdenados.set(j + 1, produtosOrdenados.get(j));
          j--;
        } else break;
      }

      produtosOrdenados.set(j + 1, x);
    }

    return produtosOrdenados;
  }
}

package Sort;

import java.util.List;
import java.util.Map;

import Order.Order;
import Produto.Produto;

public class Sort {
  SortStrategy sortStrategy;

  public static Map<SortTypes, SortStrategy> sortOptions = Map.of(
    SortTypes.INSERTION, new InsertionSort(),
    SortTypes.QUICK, new QuickSort()
  );

  public Sort(SortStrategy sortStrategy, Order criterio) {
    sortStrategy.setOrder(criterio);
    this.sortStrategy = sortStrategy;
  }

  public List<Produto> ordena(List<Produto> produtos) {
    return sortStrategy.ordena(produtos);
  }
}

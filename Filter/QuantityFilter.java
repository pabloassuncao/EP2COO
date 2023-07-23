package Filter;

import java.util.Arrays;
import java.util.List;

import Filter.Compare.Compare;
import Produto.Produto;

public class QuantityFilter implements FilterStrategy {
  public List<Produto> filter(List<Produto> produtos, String value1, String value2, Compare compare) {
    return Arrays.asList(produtos.stream()
      .filter(produto -> compare.compare(String.valueOf(produto.getQtdEstoque()), value1, value2, true))
      .toArray(Produto[]::new));
  }
}

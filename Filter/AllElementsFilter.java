package Filter;

import java.util.List;

import Filter.Compare.Compare;
import Produto.Produto;

public class AllElementsFilter implements FilterStrategy {
  public List<Produto> filter(List<Produto> produtos, String value1, String value2, Compare compare) {
    return produtos;
  }
}

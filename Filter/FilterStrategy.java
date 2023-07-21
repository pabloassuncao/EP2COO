package Filter;

import java.util.List;

import Filter.Compare.Compare;
import Produto.Produto;

public interface FilterStrategy {
  public List<Produto> filter(List<Produto> produtos, String value1, String value2, Compare compare);
}

package Filter;

import java.util.Arrays;
import java.util.List;

import Filter.Compare.Compare;
import Produto.Produto;

public class DescriptionFilter implements FilterStrategy{
  public List<Produto> filter(List<Produto> produtos, String value1, String value2, Compare compare) {
    return Arrays.asList(produtos.stream()
      .filter(produto -> compare.compare(produto.getDescricao(), value1, value2, false))
      .toArray(Produto[]::new));
  }
}

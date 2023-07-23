package Filter;

import java.util.Arrays;
import java.util.List;

import Filter.Compare.Compare;
import Produto.Produto;

public class CategoryFilter implements FilterStrategy{
  public List<Produto> filter(List<Produto> produtos, String value1, String value2, Compare compare) {
    // filter using the compare strategy compare.compare(produto.getCategoria(), value1, value2, false)
    return Arrays.asList(produtos.stream()
      .filter(produto -> compare.compare(produto.getCategoria(), value1, value2, false))
      .toArray(Produto[]::new));
  }
}

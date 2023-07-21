package Filter;

import java.util.ArrayList;
import java.util.List;

import Filter.Compare.Compare;
import Produto.Produto;

public class DescriptionFilter implements FilterStrategy{
  public List<Produto> filter(List<Produto> produtos, String value1, String value2, Compare compare) {
    List<Produto> filtered = new ArrayList<Produto>();
    for (Produto produto : produtos) {
      if (compare.compare(produto.getDescricao(), value1, value2, false)) {
        filtered.add(produto);
      }
    }
    return filtered;
  }
}

package Filter;

import java.util.List;
import java.util.Map;

import Filter.Compare.Compare;
import Produto.Produto;

public class Filter {
  FilterStrategy strategy;
  Compare compare;

  public static Map<FilterOptions, FilterStrategy> filterOptions = Map.of(
    FilterOptions.CATEGORIA, new CategoryFilter(),
    FilterOptions.ESTOQUE, new QuantityFilter(),
    FilterOptions.PRECO, new PriceFilter(),
    FilterOptions.DESCRICAO, new DescriptionFilter()
  );

  public Filter(FilterStrategy strategy, Compare compare) {
    this.strategy = strategy;
    this.compare = compare;
  }

  public List<Produto> filter(List<Produto> produtos, String value1, String value2) {
    return this.strategy.filter(produtos, value1, value2, compare);
  }
}

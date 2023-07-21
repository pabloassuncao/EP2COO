package Filter.Compare;

import java.util.Map;

public class Compare {
  private CompareStrategy compareStrategy;

  public static Map<CompareOptions, CompareStrategy> compareOptions = Map.of(
    CompareOptions.MENOR_IGUAL, new LessThanOrEqualCompare(),
    CompareOptions.MAIOR_IGUAL, new GreaterThanOrEqualCompare(),
    CompareOptions.IGUAL, new EqualCompare(),
    CompareOptions.DIFERENTE, new DifferentCompare(),
    CompareOptions.MENOR, new LessThanCompare(),
    CompareOptions.MAIOR, new GreaterThanCompare(),
    CompareOptions.TODOS, new AllCompare(),
    CompareOptions.ENTRE, new BetweenCompare(),
    CompareOptions.CONTEM, new ContainsCompare()
  );

  public Compare(CompareOptions compareOption, CompareStrategy compareStrategy) {
    this.compareStrategy = compareStrategy;
  }

  public boolean compare(String toCompare, String value1, String value2, boolean inNumeric) {
    return compareStrategy.compare(toCompare, value1, value2, inNumeric);
  }
}

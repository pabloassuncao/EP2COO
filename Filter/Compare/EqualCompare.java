package Filter.Compare;

public class EqualCompare implements CompareStrategy {
  public boolean compare(String toCompare, String value1, String value2, boolean inNumeric) {
    if (inNumeric) {
      return Double.parseDouble(toCompare) == Double.parseDouble(value1);
    } else {
      return toCompare.compareTo(value1) == 0;
    }
  }
}

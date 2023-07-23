package Filter.Compare;

public class ContainsCompare implements CompareStrategy {
  public boolean compare(String toCompare, String value1, String value2, boolean isNumeric) {
    if (isNumeric) {
      return toCompare.toLowerCase().indexOf(value1.toLowerCase()) != -1;
    } else {
      return toCompare.toLowerCase().indexOf(value1.toLowerCase()) != -1;
    }
  }
}

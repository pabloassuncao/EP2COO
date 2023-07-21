package Filter.Compare;

public class ContainsCompare implements CompareStrategy {
  public boolean compare(String toCompare, String value1, String value2, boolean inNumeric) {
    if (inNumeric) {
      return toCompare.indexOf(value1) != -1;
    } else {
      return toCompare.indexOf(value1) != -1;
    }
  }
}

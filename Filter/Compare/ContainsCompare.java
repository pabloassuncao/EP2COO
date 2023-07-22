package Filter.Compare;

public class ContainsCompare implements CompareStrategy {
  public boolean compare(String toCompare, String value1, String value2, boolean inNumeric) {
    if (inNumeric) {
      return toCompare.toLowerCase().indexOf(value1.toLowerCase()) != -1;
    } else {
      return toCompare.toLowerCase().indexOf(value1.toLowerCase()) != -1;
    }
  }
}

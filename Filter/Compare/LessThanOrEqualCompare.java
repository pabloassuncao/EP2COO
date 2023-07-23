package Filter.Compare;

public class LessThanOrEqualCompare implements CompareStrategy{
  public boolean compare(String toCompare, String value1, String value2, boolean isNumeric) {
    if (isNumeric) {
      return Double.parseDouble(toCompare) <= Double.parseDouble(value1);
    } else {
      return toCompare.compareTo(value1) <= 0;
    }
  }
}

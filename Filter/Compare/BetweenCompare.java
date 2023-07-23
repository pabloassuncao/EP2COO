package Filter.Compare;

public class BetweenCompare implements CompareStrategy{
  public boolean compare(String toCompare, String value1, String value2, boolean isNumeric) {
    if (isNumeric) {
      return Double.parseDouble(toCompare) >= Double.parseDouble(value1) && Double.parseDouble(toCompare) <= Double.parseDouble(value2);
    } else {
      return toCompare.compareTo(value1) >= 0 && toCompare.compareTo(value2) <= 0;
    }
  }
}

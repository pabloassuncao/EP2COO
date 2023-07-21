package Filter.Compare;

/**
 * Interface for the compare strategy
 */
public interface CompareStrategy {
  /**
   * Compare the values
   * @param toCompare Value to compare
   * @param value1 Value 1, this value always will be used
   * @param value2 Value 2, this value will be used only in the BetweenCompare
   * @param inNumeric If the value is numeric
   * @return
   */
  boolean compare(String toCompare, String value1, String value2, boolean inNumeric);
}

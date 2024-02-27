package at.ac.fhvie.s24.swpj4bb.touristoffice.demo.business.validation;

/**
 * Parent for all validators. There are all possible kinds of checks implemented
 * All generic validation methods should be implemented here
 */
public abstract class ValidationSupport {

  public static boolean  isNullOrEmptyString(final String value) {
    return value == null || value.isEmpty();
  }

  public static boolean isNullValue(final Object value) {
    return value == null;
  }

  public static boolean isValueGreaterThanZero(final long value) {
    return value > 0;
  }

  public static boolean isValueGreaterThanZerofinal(final double value) {
    return value > 0;
  }

  public static boolean isLessEqualZero(final double value) {
    return (value <= 0);
  }

  public static boolean isLessEqualZero(final int value) {
    return (value <= 0);
  }

  public static boolean isLessOrEqualZero(final int value) {
    return (value <= 0);
  }

  public static boolean isLessOrEqualZero(final double value) {
    return (value <= 0);
  }

  public static boolean isLessZero(final int value) {
    return (value < 0);
  }

  public static boolean isLessZero(final double value) {
    return (value < 0);
  }

  public static boolean isGreaterOrEqualZero(final int value) {
    return (value >= 0);
  }

  public static boolean isGreaterOrEqualZero(final double value) {
    return (value >= 0);
  }

  public static boolean isGreaterZero(final int value) {
    return (value > 0);
  }

  public static boolean isGreaterZero(final double value) {
    return (value > 0);
  }

  public static boolean isInRange(final int value, final int minimum, final int maximum) {
    return value >= minimum && value <= maximum;
  }

  public static boolean isInRange(final double value, final double minimum, final double maximum) {
    return value >= minimum && value <= maximum;
  }

}

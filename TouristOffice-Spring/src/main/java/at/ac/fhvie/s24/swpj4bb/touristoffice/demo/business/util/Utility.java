package at.ac.fhvie.s24.swpj4bb.touristoffice.demo.business.util;

import java.net.URL;

public final class Utility {

  private Utility() {
  }

  /**
   * Retrieve the root directory of the application
   * @return Path where the application resides
   */
  public static String getProjectDir() {
    try {
      Class<?> callingClass = Class
          .forName(Thread.currentThread().getStackTrace()[2].getClassName());
      URL url = callingClass.getProtectionDomain().getCodeSource().getLocation();
      return url.getPath();
    } catch (ClassNotFoundException exc) {
      exc.printStackTrace();
    }
    return "";
  }

  /**
   * Remove quotes from the beginning and the ed of a string
   * @param text String to remove quotes
   * @return String with removed quotes
   */
  public static String stripQuotes(final String text) {
    String value = text;
    if (isEmptyString(value) || value.length() < 2) {
      return value;
    }

    if (value.endsWith("\"")) {
      value = value.substring(0, value.length() - 1);
    }

    if (value.startsWith("\"")) {
      value = value.substring(1);
    }

    return value;

  }


  public static boolean isEmptyString(final String value) {
    return (value == null || "".equals(value.trim()));
  }

  public static boolean isNumeric(final String text) {
    try {
      // try to parse the text.
      // if no error occurs the content of text is a number
      Integer.parseInt(text);
      return true;
    } catch (NumberFormatException exc) {
      // When an exception occurs the content of text is no number. It seems
      // that a null or empty string is latily tested.
      return false;
    }
  }


}

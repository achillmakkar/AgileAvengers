package at.ac.fhvie.s24.swpj4bb.touristoffice.demo.business.converter;

import at.ac.fhvie.s24.swpj4bb.touristoffice.demo.business.constants.Category;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.logging.Logger;


/**
 * Converts between the textual representation of a hotel category for the application
 * into an integer needed by the database and vice versa.
 * Also see <a href="https://thoughts-on-java.org/jpa-21-how-to-implement-type-converter/">...</a>
 */
@Converter(autoApply = true)
public class CategoryConverter implements AttributeConverter<Category, Integer> {

  private static final int ONESTAR = 0;
  private static final int TWOSTAR = 1;
  private static final int THREESTAR = 2;
  private static final int FOURSTAR = 3;
  private static final int FIVESTAR = 4;


  private final Logger log = Logger.getLogger(CategoryConverter.class.getSimpleName());

  @Override
  public Integer convertToDatabaseColumn(final Category category) {

    switch (category) {
      case ONE:
        return ONESTAR;
      case TWO:
        return TWOSTAR;
      case THREE:
        return THREESTAR;
      case FOUR:
        return FOURSTAR;
      case FIVE:
        return FIVESTAR;
      default:
        throw new IllegalArgumentException("Conversion " + category.toString() + " not "
            + "implemented");
    }
  }

  @Override
  public Category convertToEntityAttribute(final Integer dbData) {
    switch (dbData) {
      case ONESTAR:
        return Category.ONE;
      case TWOSTAR:
        return Category.TWO;
      case THREESTAR:
        return Category.THREE;
      case FOURSTAR:
        return Category.FOUR;
      case FIVESTAR:
        return Category.FIVE;
      default:
        throw new IllegalArgumentException("Category ID " + dbData + " not supported");
    }
  }
}

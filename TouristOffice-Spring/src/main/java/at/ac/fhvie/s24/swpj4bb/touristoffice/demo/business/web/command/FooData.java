package at.ac.fhvie.s24.swpj4bb.touristoffice.demo.business.web.command;


import lombok.Data;

/*
 * @Data is a convenient shortcut annotation that bundles the features of @ToString,
 * @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together: In other words,
 * @Data generates all the boilerplate that is normally associated with simple POJOs
 * (Plain Old Java Objects) and beans: getters for all fields, setters for all non-final fields,
 * and appropriate toString, equals and hashCode implementations that involve the fields of the
 * class, and a constructor that initializes all final fields, as well as all non-final fields
 * with no initializer that have been marked with @NonNull, in order to ensure the field is
 * never null.
 */
@Data
public class FooData {

  // CHECKSTYLE.OFF: VisibilityModifier

  String textField;

  String textareaField;

  String datetimeField;

  String colorField;

  boolean singleCheckboxField;

  String[] multiCheckboxSelectedValues;

  String radioButtonSelectedValue;

  String dropdownSelectedValue;

  // CHECKSTYLE.ON: VisibilityModifier

}

package at.ac.fhvie.s24.swpj4bb.touristoffice.demo.business.validation;

import at.ac.fhvie.s24.swpj4bb.touristoffice.demo.business.entity.Hotel;
import org.springframework.stereotype.Component;

/**
 * Validation class for the Hotel class
 */
@Component
public class HotelValidator extends ValidationSupport implements Validator<Hotel> {

  /**
   * Validate the entity Hotel
   * @param hotel entity to validate
   * @return String with the error message. Empty when no error occured
   */
  @Override
  public String validate(final Hotel hotel) {
    String error = "";

    if (isNullOrEmptyString(hotel.getName())) {
      error += nameExceptionMessage();
    }

    if (isNullOrEmptyString(hotel.getOwner())) {
      error += ownerExceptionMessage();
    }

    if (isNullOrEmptyString(hotel.getContact())) {
      error += contactExceptionMessage();
    }
    if (isNullOrEmptyString(hotel.getAddress())) {
      error += addressExceptionMessage();
    }
    if (isNullOrEmptyString(hotel.getCity())) {
      error += cityExceptionMessage();
    }
    if (isNullOrEmptyString(hotel.getCityCode())) {
      error += cityCodeExceptionMessage();
    }
    if (isNullOrEmptyString(hotel.getPhone())) {
      error += phoneExceptionMessage();
    }
    if (isLessEqualZero(hotel.getNoBeds())) {
      error += bedExceptionMessage(hotel.getNoBeds());
    }

    if (isLessEqualZero(hotel.getNoRooms())) {
      error += bedExceptionMessage(hotel.getNoRooms());
    }

    // Maybe it is not so optimal that a String with all the error messages in one single String
    // is returned.
    // Maybe an ArrayList with the entries separated is the better solution. In one single string
    // it is good for swing
    // but separates Strings are better in HTML
    return error;
  }

  private String nameExceptionMessage() {
    return "Name darf nicht leer sein.\n";
  }

  private String ownerExceptionMessage() {
    return "Owner darf nicht leer sein";
  }

  private String contactExceptionMessage() {
    return "Kontakt darf nicht leer sein.\n";
  }

  private String addressExceptionMessage() {
    return "Adresse darf nicht leer sein.\n";
  }

  private String cityExceptionMessage() {
    return "Stadt darf nicht leer sein.\n";
  }

  private String cityCodeExceptionMessage() {
    return "Postleitzahl darf nicht leer sein.\n";
  }

  private String phoneExceptionMessage() {
    return "Telefon darf nicht leer sein.\n";
  }

  private String bedExceptionMessage(final int errorValue) {
    return "Bettenzahl muss größer als 0 sein (Ist:" + errorValue + ").\n";
  }

  private String roomExceptionMessage(final int errorValue, final int limit) {
    return "Raumzahl muss größer als 0 sein (Ist:" + errorValue + ").\n";
  }

}

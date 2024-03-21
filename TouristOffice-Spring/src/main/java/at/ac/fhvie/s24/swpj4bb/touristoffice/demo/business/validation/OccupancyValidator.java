package at.ac.fhvie.s24.swpj4bb.touristoffice.demo.business.validation;

import at.ac.fhvie.s24.swpj4bb.touristoffice.demo.business.entity.Occupancy;
import org.springframework.stereotype.Component;

/**
 * Validation class for the Occupancy class
 */
@Component
public class OccupancyValidator extends ValidationSupport implements Validator<Occupancy> {

    /**
     * Validate the entity Occupancy
     * @param occupancy entity to validate
     * @return String with the error message. Empty when no error occured
     */
    @Override
    public String validate(final Occupancy occupancy) {
        String error = "";

        if (isLessEqualZero(occupancy.getRooms())) {
            error += roomsExceptionMessage(occupancy.getRooms());
        }
        if (isLessEqualZero(occupancy.getUsedrooms())) {
            error += usedroomsExceptionMessage(occupancy.getUsedrooms());
        }

        if (isLessEqualZero(occupancy.getBeds())) {
            error += bedsExceptionMessage(occupancy.getBeds());
        }

        if (isLessEqualZero(occupancy.getUsedbeds())) {
            error += usedbedsExceptionMessage(occupancy.getUsedbeds());
        }
        if (isLessEqualZero(occupancy.getBeds())) {
            error += bedsExceptionMessage(occupancy.getBeds());
        }

        if (isLessEqualZero(occupancy.getYear())) {
            error += yearExceptionMessage(occupancy.getYear());
        }

        if (isLessEqualZero(occupancy.getMonth())) {
            error += monthExceptionMessage(occupancy.getMonth());
        }

        return error;
    }


    private String bedsExceptionMessage(final int errorValue) {
        return "Bettenzahl muss größer als 0 sein (Ist:" + errorValue + ").\n";
    }

    private String usedroomsExceptionMessage(final int errorValue) {
        return "Benutzte Raumzahl muss größer als 0 sein (Ist:" + errorValue + ").\n";
    }

    private String usedbedsExceptionMessage(final int errorValue) {
        return "Benutzte Raumzahl muss größer als 0 sein (Ist:" + errorValue + ").\n";
    }
    private String roomsExceptionMessage(final int errorValue) {
        return "Raumzahl muss größer als 0 sein (Ist:" + errorValue + ").\n";
    }
    private String yearExceptionMessage(final int errorValue) {
        return "Jahr muss größer als 0 sein (Ist:" + errorValue + ").\n";
    }
    private String monthExceptionMessage(final int errorValue) {
        return "Monat muss größer als 0 sein (Ist:" + errorValue + ").\n";
    }


}

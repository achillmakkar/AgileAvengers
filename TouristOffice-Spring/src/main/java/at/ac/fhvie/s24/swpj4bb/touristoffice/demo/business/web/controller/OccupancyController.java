package at.ac.fhvie.s24.swpj4bb.touristoffice.demo.business.web.controller;

import at.ac.fhvie.s24.swpj4bb.touristoffice.demo.business.service.HotelService;
import at.ac.fhvie.s24.swpj4bb.touristoffice.demo.business.service.OccupancyService;
import at.ac.fhvie.s24.swpj4bb.touristoffice.demo.business.validation.HotelValidator;
import at.ac.fhvie.s24.swpj4bb.touristoffice.demo.business.validation.OccupancyValidator;
import org.springframework.stereotype.Controller;

@Controller
public class OccupancyController
{
    private final OccupancyValidator occupancyValidator;
    private final OccupancyService occupancyService;

    public OccupancyController(final OccupancyValidator occupancyValidator, final OccupancyService occupancyService)
    {
        this.occupancyValidator = occupancyValidator;
        this.occupancyService = occupancyService;
    }

    // GET UND POST AUFRUFE FEHLEN!!!! ERST MÖGLICH WENN OCCUPANCY FORM FERTIG IST
}

package at.ac.fhvie.s24.swpj4bb.touristoffice.demo.business.web.controller;

import at.ac.fhvie.s24.swpj4bb.touristoffice.demo.business.entity.Hotel;
import at.ac.fhvie.s24.swpj4bb.touristoffice.demo.business.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class MainController {

  @Value("${welcome.message}")
  private String message;

  private HotelService hotelService;

  @Autowired
  public MainController(final HotelService hotelService) {
    this.hotelService = hotelService;
  }

  @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
  public String index(final Model model,
                      final @RequestParam("page") Optional<Integer> page,
                      final @RequestParam("size") Optional<Integer> size) {
    int currentPage = page.orElse(1);
    // Yes, i know. A hardcoded default page size of two items. Just for demonstration
    // purposes
    int pageSize = size.orElse(2);

    // Retrieve all Hotels from database. Just mentioned here how to do it.
    // Not of relevance here but I thougt it would be nice to show how to retrieve all
    // records
    // List<Hotel> hotels = hotelService.findAllOrderedById();


    // Here the page size is hardcoded. Ugly, but only for demonstration purposes
    Pageable pageRequest = PageRequest.of(currentPage - 1, pageSize);
    Page<Hotel> hotelsPage = hotelService.findAllOrderedById(pageRequest);

    model.addAttribute("hotelPage", hotelsPage);
    int totalPages = hotelsPage.getTotalPages();
    if (totalPages > 0) {
      List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
          .boxed()
          .collect(Collectors.toList());
      model.addAttribute("pageNumbers", pageNumbers);
    }
    return "index";
  }

}

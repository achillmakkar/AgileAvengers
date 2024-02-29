package at.ac.fhvie.s24.swpj4bb.touristoffice.demo.business.web.controller;

import at.ac.fhvie.s24.swpj4bb.touristoffice.demo.business.constants.Category;
import at.ac.fhvie.s24.swpj4bb.touristoffice.demo.business.entity.Hotel;
import at.ac.fhvie.s24.swpj4bb.touristoffice.demo.business.service.HotelService;
import at.ac.fhvie.s24.swpj4bb.touristoffice.demo.business.validation.HotelValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HotelController {

  private final HotelValidator hotelValidator;
  private final HotelService hotelService;

  public HotelController(final HotelValidator hotelvalidator, final HotelService hotelService) {
    this.hotelValidator = hotelvalidator;
    this.hotelService = hotelService;
  }

  // Here the form is called and the template is provided with an empty Hotel Instance
  @GetMapping("/hotelform")
  public String fooForm(final Model model) {
    model.addAttribute("command", new Hotel());

    return "hotelform";
  }


  // After submitting the Hotel form here is the entry point for the form POST where the form is
  // validated.
  // If there is an error the hotel entry form is presented once again with additional
  // error infomation If there is no error the page is redirected to an output page
  @PostMapping("/hotelform")
  public String hotelPost(
      @ModelAttribute("command") final Hotel command,
      // WARN: BindingResult *must* immediately follow the Command.
      // https://stackoverflow.com/a/29883178/1626026
      final BindingResult bindingResult,
      final Model model,
      final RedirectAttributes ra) {

    // bindingResult is for a certain kind of data validation and not used in this example.
    // The RedirectAttributes are similar to Attributes but witht he difference that the values are
    // maintained in the *Session* and are removed after the redirect.
    // With using Attribute the request parameters are created out of the attributes and are
    // serialized
    // RedriectAttributes are not serialized and can therefore store any object

    String error = hotelValidator.validate(command);
    // You have to format the error string for displaying it in HTML.
    // On a web page the \n is not valid and so no line feed is made.
    if (!error.isEmpty()) {
      // If there is an error the hotelform template gets the current values and the error string
      // Alternatively the error could be transmitted as a formatted HTML string or an ArrayList
      // with all the errors and then put together in the template
      // The ArrayList has the advantage that the creation of the error string is independent of
      // the frontend
      // (Swing/Web/App) but it has to be formatted later. A possibility could be in a Factory
      // Pattern where you provide the data and request a certain format and receive a
      // formatted String. So the Factory is responsible for the correct formatting. And further
      // formats are only implemented in that Factory.
      model.addAttribute("error", error);
      return "hotelform";
    }


    ra.addFlashAttribute("command", command);

    // Redirect to the output page. The hotel data is stored in an FlashAttribute which is
    // maintained in the session
    return "redirect:/hotelresult";

  }


  // Output of the hotel data entered by the user
  @GetMapping("/hotelresult")
  public String hotelOutput(
      @ModelAttribute("command") final Hotel hotel,
      final Model model) {

    System.out.println(hotel);

    // Category is not set in the form
    hotel.setCategory(Category.FOUR);

    hotelService.save(hotel);

    return "hotelresult";
  }

}
package cz.czechitas.java2webapps.ukol6.controller;

import cz.czechitas.java2webapps.ukol6.service.CitatyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CitatyController {

private final CitatyService citatyService;

//  konstruktor
@Autowired
  public CitatyController(CitatyService citatyService) {
    this.citatyService = citatyService;

  }

//  zobrazení stránky s náhodným citátem
  @GetMapping("/")
  public ModelAndView nahodnyCitat() {
    ModelAndView modelAndView = new ModelAndView("citat");
    modelAndView.addObject("citat", citatyService.nahodnyCitat());
    return modelAndView;
  }

//  zobrazení stránky s konkrétním citátem
  @GetMapping("/{cislo}")
  public ModelAndView konkretniCitat(@PathVariable int cislo) {
    ModelAndView modelAndView = new ModelAndView("citat");
    modelAndView.addObject("citat", citatyService.konkretniCitat(cislo));
    return modelAndView;
  }
}

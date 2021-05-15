package cz.czechitas.java2webapps.ukol6.controller;

import cz.czechitas.java2webapps.ukol6.service.CitatyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Random;

/**
 *
 */
@Controller
public class CitatyController {

//  private final List<String> seznamCitatu;
//  private final Random random;

private final CitatyService citatyService;

//  konstruktor
@Autowired
  public CitatyController(CitatyService citatyService) {
/*    this.seznamCitatu = List.of(
            "Debugging /de·bugh·ing/ (verb): The Classic Mystery Game where you are the detective, the victim, and the murderer.",
            "A user interface is like a joke. If you have to explain it, it's not that good.",
            "To replace programmers with robots, clients will have to accurately describe what they want. We're safe.",
            "I have a joke on programming but it only works on my computer.",
            "99 little bugs in the code, 99 bugs in the code. Take one down, patch it around. 127 little bugs in the code…",
            "When I wrote this code, only God & I understood what it did. Now… Only God knows.",
            "Programmer (noun.): A machine that turns coffee into code.",
            "Real programmers count from 0."
    );
    this.random = new Random();
    */

    this.citatyService = citatyService;

  }

//  zobrazení stránky s náhodným citátem
  @GetMapping("/")
  public ModelAndView nahodnyCitat() {
//    int index = random.nextInt(seznamCitatu.size());
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

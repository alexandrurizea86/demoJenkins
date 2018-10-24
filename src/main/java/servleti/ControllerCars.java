package servleti;


import date.DateMasinaSQL;
import model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/web/cars")
public class ControllerCars {

    private DateMasinaSQL datele = new DateMasinaSQL();




    @RequestMapping(value = "/toate", method = RequestMethod.GET)
    public ModelAndView metodaCarePrezintaMasinile () {

        ModelAndView mav = new ModelAndView("/masini/toate_masinile");

        List <Car> preluate = datele.toate();

        mav.addObject("DIN_DB", preluate);

        return mav;

    }



    @RequestMapping(value = "/modifica/{id}")
    public ModelAndView metodaCareModificaMasina1 (@PathVariable("id") int id) {

            Car masinaEditata = datele.omasina(id);

            ModelAndView mav = new ModelAndView("/modifica/editare");

            mav.addObject("MASINA_EDITATA", masinaEditata);

            return mav;



    }


    @RequestMapping(value = "/modifica", method = RequestMethod.POST)
    public String metodaCareModificaMasina2 (HttpServletRequest request) {

        Integer id = Integer.valueOf(request.getParameter("id"));
        String make = request.getParameter("make");
        String model = request.getParameter("model");

        Car masina = new Car(id, make, model, null, null);

        datele.update(masina);

        return "redirect:/web/cars/toate";


    }



    @RequestMapping(value = "/adauga")
    public String metodaCuFormularAdaugare () {

        return "/masini/adaugare";

    }


    @RequestMapping(value = "/adauga", method = RequestMethod.POST)
    public String metodaCareAdaugaMasina (HttpServletRequest request) {


            Car masina = new Car();

            masina.setMake(request.getParameter("in_make"));
            masina.setModel(request.getParameter("in_model"));

            datele.salveaza(masina);

            return "redirect:web/cars/toate";


    }


    @RequestMapping("/sterge/{id}")
    public String metodaCareStergeMasina (@PathVariable("id") int id) {

        datele.sterge(id);

        return "redirect:web/cars/toate";

    }


}

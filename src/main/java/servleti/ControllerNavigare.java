package servleti;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/navigare")
public class ControllerNavigare {

    @RequestMapping("/contact")
    public String contact() {
        System.out.println("*** SE EXECUTA CONTACT ***");
        return "contact";
    }



}

package cartera;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by campitos on 4/23/15.
 */

@Controller
public class ControladorInicio {

    @RequestMapping("/")
    public String inicio(){

        return "inicio";
    }
}

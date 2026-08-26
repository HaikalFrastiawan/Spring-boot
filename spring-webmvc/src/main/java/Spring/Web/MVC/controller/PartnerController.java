package Spring.Web.MVC.controller;

import Spring.Web.MVC.model.Patner;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class PartnerController {

    @GetMapping("/partner/current")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String getPatner(Patner partner){
        return partner.getId() + " : " + partner.getName();
    }
}

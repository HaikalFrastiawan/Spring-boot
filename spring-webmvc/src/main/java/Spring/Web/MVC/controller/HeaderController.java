package Spring.Web.MVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HeaderController {

    @GetMapping("/header/token")
    @ResponseBody
    public String Header(@RequestHeader(name = "X-TOKEN") String token){
        if("Haikal".equals(token)){
            return "ok";
        }else {
            return "ko";
        }

    }
}

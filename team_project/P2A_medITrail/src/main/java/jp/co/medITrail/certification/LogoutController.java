package jp.co.medITrail.certification;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {

    @RequestMapping(path="/logout", method=RequestMethod.POST)
    public String logout() {

        return "login";
    }

}
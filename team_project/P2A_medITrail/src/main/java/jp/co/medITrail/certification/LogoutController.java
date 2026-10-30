package jp.co.medITrail.certification;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @RequestMapping(path="/logout", method=RequestMethod.POST)
    public String logout(HttpSession session) {
    	session.invalidate();

        return "login";
    }

}
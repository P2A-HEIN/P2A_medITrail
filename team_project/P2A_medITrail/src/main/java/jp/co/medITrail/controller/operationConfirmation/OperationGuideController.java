package jp.co.medITrail.controller.operationConfirmation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OperationGuideController {

    @RequestMapping(path = "/employee/operationGuide", method = RequestMethod.GET)
    public String operationGuide() {
        return "employee/operationGuide";
    }

}
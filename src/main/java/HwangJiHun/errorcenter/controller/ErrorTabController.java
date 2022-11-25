package HwangJiHun.errorcenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/errortab")
public class ErrorTabController {

    @GetMapping("/ErrorDashboard")
    public String errorDashboard() {
        return "/errortab/ErrorDashboard";
    }

    @GetMapping("/CoronaMonitor")
    public String coronaMonitor() {
        return "/errortab/CoronaMonitor";
    }

    @GetMapping("/PoeItemValues")
    public String poeItemValues() {
        return "/errortab/PoeItemValues";
    }
}

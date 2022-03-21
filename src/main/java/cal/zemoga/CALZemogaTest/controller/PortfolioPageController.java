package cal.zemoga.CALZemogaTest.controller;

import cal.zemoga.CALZemogaTest.services.ServicePortfolio;
import cal.zemoga.CALZemogaTest.services.ServiceTwitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/gui")
@SessionAttributes("name")
public class PortfolioPageController {

    @Autowired
    private ServiceTwitter serviceTwitter;

    @GetMapping(value = "/PortfolioPage")
    public String showPortfolioPage(Model model){
        model.addAttribute("tweets", serviceTwitter.getTextTimeLines());
        return "PortfolioPage";
    }
}

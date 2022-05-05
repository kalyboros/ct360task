package ct.ct360task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddPairController {

    @RequestMapping("/addPair")
    public String addPairWebPage(Model model) {
        return "addPair";
    }
}

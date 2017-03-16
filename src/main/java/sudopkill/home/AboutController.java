package sudopkill.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import sudopkill.account.Account;
import sudopkill.account.AccountRepository;

import java.security.Principal;

/**
 * Created by tanzeelrana on 17/02/17.
 */
@Controller
class AboutController {

    @ModelAttribute("module")
    String module() {
        return "about";
    }

    @GetMapping("/about")
    String about() {
        System.out.println("views/home/about");
        return "home/about";
    }
}

package sudopkill.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Created by tanzeelrana on 3/10/2017.
 */

@Controller
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountService accountService;

    @ModelAttribute("module")
    String module() {
        return "account";
    }

    @RequestMapping(value = "/account/{userId}", method = RequestMethod.GET)
    String user(Principal principal, @PathVariable String userId, Model model) {
        Account user = accountRepository.findOneById(userId);
        model.addAttribute("id", userId);
        model.addAttribute("user", user);
        model.addAttribute("tab","all");
        return "/account/account";
    }

    @RequestMapping(value = "/account/{userId}/followers")
    String followers(Principal principal, @PathVariable String userId, Model model){
        Account user = accountRepository.findOneById(userId);
        model.addAttribute("id", userId);
        model.addAttribute("user", user);
        model.addAttribute("tab","followers");
        System.out.println("need to show all the followers for the user id : " + userId);
        return "/account/account";
    }

    @RequestMapping(value = "/account/{userId}/following")
    String following(Principal principal, @PathVariable String userId, Model model){
        Account user = accountRepository.findOneById(userId);
        model.addAttribute("id", userId);
        model.addAttribute("user", user);
        model.addAttribute("tab","following");
        System.out.println("need to show all the following for the user id : " + userId);
        return "/account/account";
    }

    @RequestMapping(value = "/account/{userId}/pages")
    String pages(Principal principal, @PathVariable String userId, Model model){
        Account user = accountRepository.findOneById(userId);
        model.addAttribute("id", userId);
        model.addAttribute("user", user);
        model.addAttribute("tab","pages");
        System.out.println("need to show all the pages for the user id : " + userId);
        return "/account/account";
    }

    @RequestMapping(value = "/account/{userId}/likes")
    String likes(Principal principal, @PathVariable String userId, Model model){
        Account user = accountRepository.findOneById(userId);
        model.addAttribute("id", userId);
        model.addAttribute("user", user);
        model.addAttribute("tab","likes");
        System.out.println("need to show all the likes for the user id : " + userId);
        return "/account/account";
    }

    @RequestMapping(value = "/account/{userId}/follow")
    String follow(Principal principal, @PathVariable String userId, Model model){
        Account user = accountRepository.findOneById(userId);
        model.addAttribute("id", userId);
        model.addAttribute("user", user);

        user.addMyFollower(accountService.getCurrentUser());
        accountService.update(user);

        return "/account/account";
    }
}

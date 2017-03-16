package sudopkill.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import sudopkill.account.Account;
import sudopkill.account.AccountRepository;
import sudopkill.config.ClientResources;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tanzeelrana on 3/4/2017.
 */

@Controller
public class HomeController {

    @ModelAttribute("module")
    String module() {
        return "home";
    }

    @RequestMapping({"/","/home", "/user", "/me"})
    String index(Principal principal) {
        if(principal != null){
            Map<String, String> map = new LinkedHashMap<>();
            map.put("name", principal.getName());
            return "home/homeSignedIn";
        }else{
            return "home/homeNotSignedIn";
        }
    }
}

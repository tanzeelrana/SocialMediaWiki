package sudopkill.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import sudopkill.account.Account;
import sudopkill.account.AccountRepository;

import java.security.Principal;

/**
 * Created by tanzeelrana on 3/11/2017.
 */

@ControllerAdvice
public class GlobalBindingInitializer {

    @Autowired
    AccountRepository accountRepository;

    @ModelAttribute("currentUser")
    Account module(Principal principal) {
        if(principal != null) {
            Account currentUser = accountRepository.findOneById( principal.getName() );
            return  currentUser;
        }else{
            return null;
        }
    }

    @InitBinder
    public void registerCustomEditors(WebDataBinder binder, WebRequest request) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

}

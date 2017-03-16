package sudopkill.AuthProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.stereotype.Component;
import sudopkill.account.Account;
import sudopkill.account.AccountService;
import sudopkill.config.ClientResources;
import sudopkill.config.SecurityConfig;
import sudopkill.facebook.FacebookAccountService;
import sudopkill.github.GithubAccountService;

import javax.transaction.Transactional;

/**
 * Created by haris on 3/6/17.
 */

@Component
public class AuthenticationListener implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SecurityConfig securityConfig;

    @Autowired
    private FacebookAccountService facebookAccountService;

    @Autowired
    private GithubAccountService githubAccountService;

    @Autowired
    private AccountService accountService;

    @Override
    public void onApplicationEvent(final InteractiveAuthenticationSuccessEvent event) {
        logger.info("$$$$$$$$$ InteractiveAuthenticationSuccessEvent $$$$$$$$$");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Account currentUser;

        if(!auth.getClass().equals(UsernamePasswordAuthenticationToken.class)){
            OAuth2Request oAuth2Request = ((OAuth2Authentication) auth).getOAuth2Request();
            currentUser = getOAuthUserAccount(oAuth2Request, (OAuth2Authentication) auth);
        }
        System.out.println(auth.getName());
        currentUser = accountService.getUser(auth.getName());
        accountService.setCurrentUser(currentUser);

        System.out.println("user name : "+accountService.getCurrentUser().getName());
    }

    // return null if no id matched !!
    @Transactional
    public Account getOAuthUserAccount(OAuth2Request oAuth2Request, OAuth2Authentication auth){

        String clientId = oAuth2Request.getClientId();
        ClientResources facebook = securityConfig.facebook();
        ClientResources github = securityConfig.github();

        if(clientId == facebook.getClient().getClientId()){
            return facebookAccountService.getFacebookAccountService(auth);
        }else if(clientId == github.getClient().getClientId()){
            return githubAccountService.getGithubAccountController(auth);
        }else{
            return null;
        }
    }

}

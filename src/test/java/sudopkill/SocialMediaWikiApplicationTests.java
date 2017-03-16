package sudopkill;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sudopkill.AuthProvider.AuthProvider;
import sudopkill.account.AccountService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SocialMediaWikiApplicationTests {

	String email = "harisghauri@gmail.com";
	String pass = "pass";
	String role = "USER_ROLE";
	String localRole = AuthProvider.LOCAL.toString();

	@Autowired
	AccountService accountService;

	@Test
	public void contextLoads() {
	}

//	@Test
//	public void addAccountPassingParams() throws Exception {
//
//		Account account = new Account(email, pass, localRole, localRole);
//		account = accountService.save(account);
//
//		assertEquals(account.getEmail(),email);
////		assertEquals(account.getPassword(),pass);
////		assertEquals(account.getRole(),role);
//		assertEquals(account.getAuthProvider(),localRole);
//
//	}

//	@Test
//	public void addAccountUsingSetters() throws Exception {
//		Account account = new Account();
//		account.setEmail(email+"2");
//		account.setAuthProvider(localRole);
//		account.setPassword(pass);
//		account.setRole(role);
//
//		assertEquals(account.getEmail(),email);
////		assertEquals(account.getPassword(),pass);
////		assertEquals(account.getRole(),role);
//		assertEquals(account.getAuthProvider(),localRole);
//	}
}

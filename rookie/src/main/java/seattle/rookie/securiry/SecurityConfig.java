package seattle.rookie.securiry;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
/**
 * Spring Security設定クラス.
 */
@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvcSecurity   
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private UserDetailsService userDetailsService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
//        新規作成、cssファイルへのアクセスを許可
        .antMatchers("/create","/createform", "/css/**", "/webjars/**").permitAll()

         .anyRequest().authenticated() 
         .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
         .and()
         .rememberMe();

        http.formLogin()

            .loginPage("/login")           

            .defaultSuccessUrl("/page?size=20&page=0&userName=&projectName=&departmentName=&gender=")     
            .usernameParameter("email").passwordParameter("password").permitAll(); 
                                      

    }

    
    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder)
            throws Exception
    {
        authenticationManagerBuilder.userDetailsService(this.userDetailsService);

    }
    

        
        @Autowired
        public void setUserDetailsService(UserDetailsService userDetailsService)
        {
            this.userDetailsService = userDetailsService;
        }
        
}
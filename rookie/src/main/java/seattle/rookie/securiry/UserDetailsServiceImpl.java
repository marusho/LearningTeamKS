package seattle.rookie.securiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import seattle.rookie.model.MyData;
import seattle.rookie.repositories.MyDataRepository;


@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	private MyDataRepository myrepo;
  
    @Override
//    Emailを用いてデータを取得
    public UserDetails loadUserByUsername(String email)throws UsernameNotFoundException {

        MyData user = null;
        try {

        	user = myrepo.findByEmail(email);

        } catch (Exception e) {
          
            throw new UsernameNotFoundException("It can not be acquired User");
        }

      
        if(user == null){
            throw new UsernameNotFoundException("User not found for login id: " + email);
        }

      
        return user;
    }
    
    @Autowired
    public void setUserRepository(MyDataRepository myrepo)
    {
        this.myrepo = myrepo;
    }


	
    

    

}
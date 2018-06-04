package mihajlo.exampleantony.it.service;

import mihajlo.exampleantony.it.entity.CustomUserDetail;
import mihajlo.exampleantony.it.entity.Role;
import mihajlo.exampleantony.it.entity.User;
import mihajlo.exampleantony.it.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public void save(User user){
        user.setPassword(getPasswordEncoder().encode(user.getPassword()));
        user.setRoles(Arrays.asList(new Role("USER")));
        repo.save(user);
    }

    public void addRoleAdmin(User user, Role role){
        user.getRoles().add(role);
        repo.save(user);
    }
    public User getUser(CustomUserDetail userDetail) {
        return repo.findByUsername(userDetail.getUsername());
    }

    public void hasRole(User user, String role) throws Exception {
        for(Role r : user.getRoles()){
            if(r.getName().equals(role)){
                return;
            }
        }
        throw new Exception("Unauthorize, no rolle");
    }
    public List<User> getUsers(){
        return repo.findAll();
    }

}

package mihajlo.exampleantony.it.controller;

import mihajlo.exampleantony.it.entity.CustomUserDetail;
import mihajlo.exampleantony.it.entity.Role;
import mihajlo.exampleantony.it.entity.User;
import mihajlo.exampleantony.it.entity.dto.UserDTO;
import mihajlo.exampleantony.it.repository.UserRepository;
import mihajlo.exampleantony.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/user/register")
    public void register(@RequestBody UserDTO user){
        userService.save(user.getUser());
    }

    @PostMapping(value = "/user/add_super_admin")
    public User registerSuperAdmin(@RequestBody User userToSave) throws Exception {
        User user = userService.getUser((CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        userService.hasRole(user,"SUPER_ADMIN");
        userToSave.setRoles(Arrays.asList(new Role("USER"), new Role("ADMIN"),new Role("SUPER_ADMIN")));
        return userRepository.save(userToSave);
    }

    @PostMapping(value = "/user/add_admin")
    public User registerAdmin(@RequestBody User userToSave) throws Exception {
        User user = userService.getUser((CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        userService.hasRole(user,"SUPER_ADMIN");
        userToSave.setRoles(Arrays.asList(new Role("USER"), new Role("ADMIN")));
        return userRepository.save(userToSave);
    }

    @GetMapping(value = "/user/get")
    public User getLoggedInUser(){
        CustomUserDetail userDetail = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.getUser(userDetail);
        return user;
    }
    @GetMapping(value = "/user/roles")
    public List<Role> getMyRoles(){
        CustomUserDetail userDetail = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.getUser(userDetail);
        return user.getRoles();
    }

    @GetMapping(value = "/user")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping(value = "/user/byId")
    public User getUserById(@RequestParam Long id){
        return userRepository.findOne(id);
    }
}

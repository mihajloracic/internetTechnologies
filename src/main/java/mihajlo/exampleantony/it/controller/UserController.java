package mihajlo.exampleantony.it.controller;

import mihajlo.exampleantony.it.entity.CustomUserDetail;
import mihajlo.exampleantony.it.entity.Role;
import mihajlo.exampleantony.it.entity.User;
import mihajlo.exampleantony.it.entity.dto.UserDTO;
import mihajlo.exampleantony.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/user/register")
    public void register(@RequestBody UserDTO user){
        userService.save(user.getUser());
    }
    @PostMapping(value = "/user/add_super_admin")
    public void registerSuperAdmin(@RequestBody User user) throws Exception {
        user = userService.getUser((CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        userService.hasRole(user,"SUPER_ADMIN");
        userService.addRoleAdmin(user,new Role("SUPER_ADMIN"));
    }

    @PostMapping(value = "/user/add_admin")
    public void registerAdmin(User user) throws Exception {
        user = userService.getUser((CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        userService.hasRole(user,"SUPER_ADMIN");
        userService.addRoleAdmin(user,new Role("ADMIN"));
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
}

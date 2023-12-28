package com.example.projectup;


import com.example.projectup.models.RoleEnum;
import com.example.projectup.models.UserModel;
import com.example.projectup.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;

@Controller
@RequestMapping("")
public class AuthController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    public AuthController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String createNewUser(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") UserModel user){

            user.setRoles(Collections.singleton(RoleEnum.USER)  );
            userService.createUser(user);
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getLogin(),user.getPassword()));
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(authentication);
            HttpSession session = request.getSession(true);
            session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,securityContext);
            return "redirect:/login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login() {
        return "login";
    }
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest response) {
        HttpSession session =  response.getSession();
        session.invalidate();
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(null);
        return "redirect:/login";
    }
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(HttpServletRequest request, HttpServletResponse response, Model model) {
       UserModel user = new UserModel();
       model.addAttribute("user", user);

       return "register";
    }
}

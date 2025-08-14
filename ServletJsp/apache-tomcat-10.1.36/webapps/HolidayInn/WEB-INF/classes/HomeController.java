package com.mikadosolutions.training.springmvc.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//import com.mikadosolutions.training.springmvc.bean.User;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.validation.ObjectError;
import org.springframework.validation.FieldError;

@Controller
@RequestMapping("/")
public class HomeController {
    
    @RequestMapping("/")
    public String welcome()
    {
        System.out.println("AC --");
        return "welcome";
    }
}

package ru.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.Dto.UserConfirmDto;
import ru.itis.model.State;
import ru.itis.service.SignInService;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

@Controller
public class SignInController {

    @Autowired
    private SignInService service;

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public ModelAndView getSignIn() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signIn");
        return modelAndView;
    }

//    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
//    protected String signIn(HttpServletRequest req) {
//        HttpSession session = req.getSession();
//        UserConfirmDto user = service.signIn(req);
//
//        if (user == null) {
//            return "redirect:" + req.getScheme() + "://localhost:8088/signIn";
//        } else if (user.getState().equals(State.NOT_CONFIRMED)){
//            session.setAttribute("current_user", user);
//            return "redirect:" + req.getScheme() + "://localhost:8088/confirm";
//        }
//        else {
//            session.setAttribute("current_user", user);
//            return "redirect:" + req.getScheme() + "://localhost:8088/profile";
//        }
//    }
}

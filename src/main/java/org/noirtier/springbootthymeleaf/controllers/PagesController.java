package org.noirtier.springbootthymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// This Controller setups mapping for pages and
@Controller
public class PagesController {
    @GetMapping("/spring")
    public String showSpring(Model model){
        model.addAttribute("msg", "Hello world");
        return "spring"; // returns html page name

        /*
        Here we put data in model
        and then View gets this data from Model
        Controller -> Model - View

        How Spring understands that return "spring" its a html page?
        If controller class marked with @Controller annotation, Spring thinks:
        its a View name, not a body response.
        Spring sends "spring" into ViewResolver
        ViewResolver applies prefix and suffix and makes spring /template/spring.html
        then rendering happens via: servlet engine(jsp) or template engine(thymeleaf)
        data from Model injects into template

        But if we mark method as @ResponseBody or class as @RestController,
        then Spring doesnt run ViewResolver and think that return spring its a body
        of HTTP answer.
        Spring checks if we have @ResponseBody, type of controller(Rest or Controller)
        if ViewResolver is turned on, if name of view matches with a template

        @RestController is used for REST API, for returning HTTP responses for example
        JSON.
        @Controller used to return html pages

         */
    }

    @GetMapping("/greet")
    public String showGreeting(Model model){
        model.addAttribute("msg", "(this is msg from GET)");
        return "greet";
    }

    @PostMapping("/greet")
    public String submitGreet(@RequestParam String name, Model model){
        model.addAttribute("name", name + " (this is msg from POST)");
        return "greet";
        // todo: after this page updating msg from GET request is disappear
    }
}

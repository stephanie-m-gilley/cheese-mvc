package org.launchcode.cheesemvc.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("cheese")
public class CheeseController {

    static HashMap<String, String> cheeses = new HashMap<>();
    static ArrayList<String> cheese = new ArrayList<>();

    // request path : /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");

        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");

        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, String cheeseDescription) {


        cheeses.put(cheeseName, cheeseDescription);


        //redirect to /cheese
        return "redirect:";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String deleteCheeseForm(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "Remove Cheeses");

        return "cheese/delete";

        //TODO make a post request handler, mimic add request handler. compare arraylist to hashmap by looping through and comparing. Will need an if statement
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String processDeleteCheeseForm(@RequestParam String remove) {

        cheese.add(remove);

        for (String i : cheese) {
            if (cheeses.containsKey(i)) {
                cheeses.remove(remove);
            }
        }

        return "redirect:";

    }


}





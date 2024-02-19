package com.sd.springdemo.mvc;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @InitBinder
     public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);

    }

@GetMapping("/InitialProcess")
    public String InitialProcess(Model myModel){
    myModel.addAttribute("customer",new Customer());
    return "initial-process";
}
@PostMapping("/PassingProcess")
    public String PassingProcess(@Valid @ModelAttribute("customer")
                                 Customer theCustomer, BindingResult bindingResult){
     if(bindingResult.hasErrors()){
         return "initial-process";
     }
     return "confirmationPage";

}
}

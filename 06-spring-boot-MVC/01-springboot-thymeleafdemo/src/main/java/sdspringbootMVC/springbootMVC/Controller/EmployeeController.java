package sdspringbootMVC.springbootMVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sdspringbootMVC.springbootMVC.models.Employee;

@Controller
public class EmployeeController {
 @GetMapping("/processing")
public String processing(Model myModel){
     Employee employee=new Employee();
 myModel.addAttribute("myEmployee",employee);
 return "processFunction";
 }

    @PostMapping("/prepareResult")
    public String prepareResult(@ModelAttribute("myEmployee") Employee employee){
     System.out.println("The data are "+ employee.getFirstName() +" and "+ employee.getLastName());
      return "showResult";
    }
}

package Employee.Management.System.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import Employee.Management.System.Entity.Employee;
import Employee.Management.System.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service ;
	

	
	@GetMapping("/listEmployees")
	public String getAllListEmployees(Model model) {
		List<Employee> list = service.getAllEmployees() ;
		model.addAttribute("employees" ,list);
		return "list-employees";
		
	}
	@GetMapping("/home")
	public String homePage() {
		return "home";
		
	}
	
	@GetMapping("/employeeForm")
	public String showEmployeeForm(Model model) {
		
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		
		return "Employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		service.save(employee);
		
		return "redirect:/listEmployees";
	}
	
	@GetMapping("/updateEmployee")
	public String updateEmployeeDetails(@RequestParam("employeeId") int id ,Model model)
	{
		Optional<Employee> emp = service.findEmployeeById(id);
		model.addAttribute("employee", emp);
		return "Employee-form";
		
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("employeeId") int id , Model model)
	{
		service.deleteEmployee(id);
		return "redirect:/listEmployees" ;
	}
}

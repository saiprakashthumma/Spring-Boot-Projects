package Employee.Management.System.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Employee.Management.System.Entity.Employee;
import Employee.Management.System.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository ;

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public void save(Employee employee) {
		if(employee.getFirstName().isEmpty() || 
			employee.getLastName().isBlank() || 
			employee.getEmail().isBlank()) 
		{
			System.out.println("please enter all fileds");
		}
		else {
		employeeRepository.save(employee);
		}
	}

	@Override
	public Optional<Employee> findEmployeeById(int id) {
		
		return employeeRepository.findById(id);
	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
		
	}
	
	
}

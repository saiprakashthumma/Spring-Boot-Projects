package Employee.Management.System.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Employee.Management.System.Entity.Employee;

@Service
public interface EmployeeService {

	List<Employee> getAllEmployees();

	 void save(Employee employee);

	 Optional<Employee> findEmployeeById(int id);

	void deleteEmployee(int id);
	
}

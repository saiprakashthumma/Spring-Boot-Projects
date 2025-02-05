package Employee.Management.System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Employee.Management.System.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}

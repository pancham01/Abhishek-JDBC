package learning.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import learning.jdbc.entity.Employee;

public interface EmployeeDao {


	public void saveEmployee(Employee e);

	public void updateEmpRecord(Employee e)throws SQLException;

	public void deleteAnEmployee(int id);

	public Employee getEmployeeById(int id);

	public Employee getEmployeeByName(String name);

	public void printAllEmployees();

	public List<Employee> getAllEmployees();

}

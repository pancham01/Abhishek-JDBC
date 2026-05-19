package learning.jdbc;

import java.sql.SQLException;

import learning.jdbc.dao.EmployeeDao;
import learning.jdbc.dao.EmployeeDaoImpl;
import learning.jdbc.entity.Employee;

public class Main {

	public static void main(String[] args) throws SQLException  {


		Employee e1 = new Employee(14, "Arya", "female", 989898);
		
		
		EmployeeDao edao = new EmployeeDaoImpl();
		
//		edao.saveEmployee(e1);
		
		edao.printAllEmployees();
	}

}

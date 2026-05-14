package learning.jdbc;

import java.sql.SQLException;

import learning.jdbc.dao.EmployeeDao;
import learning.jdbc.dao.EmployeeDaoImpl;
import learning.jdbc.entity.Employee;

public class Main {

	public static void main(String[] args) throws SQLException  {


		Employee e1 = new Employee(15, "Arya", "female", 989898);
		Employee e2 = new Employee(12, "Nikita Kumari", "female", 449898);
		
		Employee e3 = new Employee(13, "Yati Singh", "female", 100098);
		
		
		EmployeeDao edao = new EmployeeDaoImpl();
		
		
		
		
	}

}

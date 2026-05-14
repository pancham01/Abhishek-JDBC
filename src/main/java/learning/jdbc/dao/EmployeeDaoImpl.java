package learning.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import learning.jdbc.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private static final String INSERT_QUERY = "INSERT INTO EMPLOYEE(ID,NAME,GENDER,SALARY) VALUES(%d,%s,%s,%d)";
	private static final String UPDATE_QUERY = "UPDATE EMPLOYEE SET NAME = '%s',GENDER = '%s',SALARY = %d WHERE ID = %d";
	private static final String DELETE_QUERY = "DELETE FROM EMPLOYEE WHERE ID = %d";

	static Connection connection = null;
	static {
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");

		try {
			
//			connection = new Driver().connect("jdbc:mysql://localhost:3306/mydb", prop);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", prop);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void saveEmployee(Employee e) {

		try (Statement statement = connection.createStatement()) {

			statement.executeUpdate("insert into employee(id,name,gender,salary) values(" + e.getId() + ",'"
					+ e.getName() + "','" + e.getGender() + "'," + e.getSalary() + ")");

			System.out.println("insert into employee(id,name,gender,salary) values(" + e.getId() + ",'" + e.getName()
					+ "','" + e.getGender() + "'," + e.getSalary() + ")");

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public void updateEmpRecord(Employee e) throws SQLException {

		Statement statement = connection.createStatement();

		statement.executeUpdate(String.format(UPDATE_QUERY, e.getName(), e.getGender(), e.getSalary(), e.getId()));

		System.out.println(String.format(UPDATE_QUERY, e.getName(), e.getGender(), e.getSalary(), e.getId()));
		System.out.println("EmployeeDaoImpl.updateEmpRecord()");
	}

	@Override
	public void deleteAnEmployee(int id) {
		
		try (Statement statement = connection.createStatement()) {

			statement.executeUpdate(String.format(DELETE_QUERY, id));

			System.out.println(String.format(DELETE_QUERY, id));

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		
	}

	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printAllEmployees() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createTable(String tableName) {
		try (Statement statement = connection.createStatement()) {

			statement.executeUpdate("create table " + tableName
					+ "(id int not null, name varchar(100),gender varchar(10),salary int, primary key(id))");

			System.out.println("create table " + tableName
					+ "(id int not null, name varchar(100),gender varchar(10),salary int, primary key(id))");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

}

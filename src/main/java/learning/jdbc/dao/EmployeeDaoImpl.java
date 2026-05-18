package learning.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import learning.jdbc.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private static final String INSERT_QUERY = "INSERT INTO EMPLOYEE(ID,NAME,GENDER,SALARY) VALUES(%d,%s,%s,%d)";
	private static final String UPDATE_QUERY = "UPDATE EMPLOYEE SET NAME = '%s',GENDER = '%s',SALARY = %d WHERE ID = %d";
	private static final String DELETE_QUERY = "DELETE FROM EMPLOYEE WHERE ID = %d";
	private static final String SELECT_QUERY = "SELECT * FROM EMPLOYEE";
	private static final String GET_EMP_BY_ID = "SELECT * FROM EMPLOYEE WHERE ID = %d";

	static Connection connection = null;
	static {

		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");

		try {

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
	public Employee getEmployeeById(int id) {

		Employee e = new Employee();
		try (Statement statement = connection.createStatement()) {

			ResultSet resultSet = statement.executeQuery(String.format(GET_EMP_BY_ID, id));

			resultSet.next();

			e.setId(resultSet.getInt(1));
			e.setName(resultSet.getString(2));
			e.setGender(resultSet.getString(3));
			e.setSalary(resultSet.getInt(4));

			System.out.println(String.format(GET_EMP_BY_ID, id));

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return e;
	}

	@Override
	public Employee getEmployeeByName(String name) {

		return null;
	}

	@Override
	public void printAllEmployees() {

		try (Statement statement = connection.createStatement()) {

			ResultSet resultSet = statement.executeQuery(SELECT_QUERY);

			while (resultSet.next()) {

				System.out.println("Id = " + resultSet.getInt(1) + "    Name = " + resultSet.getString(2)
						+ "\t Gender = " + resultSet.getString(3) + "\t Salary = " + resultSet.getInt(4));

				
				
//				System.out.println("Id = " + resultSet.getInt(1) );
//				System.out.println("Name = " + resultSet.getString(2) );
//				System.out.println("Gender = " + resultSet.getString(3) );
//				System.out.println("Salary = " + resultSet.getInt(4));
				System.out.println("----------------------------");
			}

			System.out.println(SELECT_QUERY);

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}

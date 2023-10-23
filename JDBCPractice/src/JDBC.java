import java.sql.*;

public class JDBC {
    public static final String DB_URL = "jdbc:mysql://localhost/factory";
    public static final String DB_U_NAME = "root";
    public static final String DB_U_PASS = "mysql";

    public static void main(String[] args) {
        Connection connect = null;
        try {
            //connect database
            connect = DriverManager.getConnection(DB_URL, DB_U_NAME, DB_U_PASS);


            String sqlAll = "SELECT * FROM employee"; //query to list all employees
            Statement stateAll = connect.createStatement();
            ResultSet dbaseAll = stateAll.executeQuery(sqlAll);

            System.out.println("List of all employees:");
            while (dbaseAll.next()) {
                System.out.println("ID: " + dbaseAll.getInt("employee_id") +
                        "\tName: " + dbaseAll.getString("employee_name") +
                        "\tPosition: " + dbaseAll.getString("employee_position") +
                        "\tSalary: " + dbaseAll.getInt("employee_salary"));
            }


            String sqlS = "SELECT * FROM employee WHERE employee_name LIKE 'S%'"; //A query that lists names starting with 'S'.
            Statement stateS = connect.createStatement();
            ResultSet dbaseS = stateS.executeQuery(sqlS);

            System.out.println("\nList of employees whose names begin with 'S':");
            while (dbaseS.next()) {
                System.out.println("ID: " + dbaseS.getInt("employee_id") +
                        "\tName: " + dbaseS.getString("employee_name") +
                        "\tPosition: " + dbaseS.getString("employee_position") +
                        "\tSalary: " + dbaseS.getInt("employee_salary"));
            }

        } catch (SQLException e) { //
            System.out.println(e.getMessage());
        }
    }
}

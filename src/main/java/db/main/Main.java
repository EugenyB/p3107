package db.main;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/demo3107", "student", "123")) {
            String sql = "select * from student";
            try (PreparedStatement ps = connection.prepareStatement(sql);
                 ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    System.out.println("id: " + id + ", name: " + name + ", age: " + age);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

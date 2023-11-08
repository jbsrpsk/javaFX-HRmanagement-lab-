package com.example.hrmanagement.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class EmployeeDAO {

        ObservableList<Employee> list = FXCollections.observableArrayList();
        public ObservableList<Employee> populateTable() {
            String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/humanresource";
            String dbUser = "root";
            String dbPassword = "mintleaf88";

            try {
                Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

                try {
                    String query = "SELECT * FROM employee";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);

                    while(resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String position = resultSet.getString("position");
                        int salary = resultSet.getInt("salary");
                        list.add(new Employee(id,name,position,salary));
                        System.out.println("loaded");
                        System.out.println(id);
                        System.out.println(position);


                    }
                    return list;
                } catch (Throwable var13) {
                    if (connection != null) {
                        try {
                            connection.close();
                        } catch (Throwable var12) {
                            var13.addSuppressed(var12);
                        }
                    }

                    throw var13;
                }

            } catch (SQLException var14) {
                var14.printStackTrace();
            }

            return null;
        }

        public void InsertData(String name,String position,int salary) {
            String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/humanresource";
            String dbUser = "root";
            String dbPassword = "mintleaf88";
            try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                    dbPassword)) {

                String query = "INSERT INTO `employee`( `name`, `position`, `salary`) VALUES ('"+name+"','"+position+"','"+salary +"')";
                Statement statement = connection.createStatement();
                statement.execute(query);


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public void UpdateData(String name,String position,int salary,int id) {

            String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/humanresource";
            String dbUser = "root";
            String dbPassword = "mintleaf88";
            try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                    dbPassword)) {

                String query = "UPDATE `employee` SET`name`='"+name+"',`position`='"+position+"',`salary`='"+salary+"' WHERE id ='"+id+"'";
                Statement statement = connection.createStatement();
                statement.execute(query);


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public void DeleteData(int id) {

            String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/humanresource";
            String dbUser = "root";
            String dbPassword = "mintleaf88";
            try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                    dbPassword)) {

                String query = "DELETE FROM `employee` WHERE id ='"+id+"'";
                Statement statement = connection.createStatement();
                statement.execute(query);


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    public int getSalaryById(int id) {
        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/humanresource";
        String dbUser = "root";
        String dbPassword = "mintleaf88";
        int salary = 0;

        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "SELECT salary FROM employee WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                salary = resultSet.getInt("salary");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salary;
    }


}


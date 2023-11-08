package com.example.hrmanagement;

import com.example.hrmanagement.Model.EmployeeDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AdminController {
    public Button calculateButton;
    public Label salaryLabel;
    @FXML
    public TextField iid2;
    int sum = 0;

    public void onCalculateClick() {
        int userId = Integer.parseInt(iid2.getText());

        EmployeeDAO employeeDAO = new EmployeeDAO();
        int salary = employeeDAO.getSalaryById(userId);
        sum = salary * 12;
        System.out.println("Salary of the employee with ID 1 is: " + salary);
        salaryLabel.setText(String.valueOf(sum));
    }

    public void initializeJavaFXComponents() {
        salaryLabel.setText("0");
    }
}

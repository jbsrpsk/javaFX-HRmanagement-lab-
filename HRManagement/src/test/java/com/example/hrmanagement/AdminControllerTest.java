package com.example.hrmanagement;

import com.example.hrmanagement.Model.EmployeeDAO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

public class AdminControllerTest {
    @BeforeAll
    public static void initToolkit() {
        javafx.application.Platform.startup(() -> {});
    }

    @Test
    public void testCalculateYearlySalary() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin.fxml"));
        try {
            Parent root = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        AdminController adminController = fxmlLoader.getController();

        adminController.initializeJavaFXComponents();

        int userId = 1;

        adminController.iid2.setText(String.valueOf(userId));
        adminController.onCalculateClick();

        int yearlySalary = Integer.parseInt(adminController.salaryLabel.getText());
        EmployeeDAO employeeDAO = new EmployeeDAO();
        int monthlySalary = employeeDAO.getSalaryById(userId);
        int expectedYearlySalary = monthlySalary * 12;
        assertEquals(expectedYearlySalary, yearlySalary);
    }
}

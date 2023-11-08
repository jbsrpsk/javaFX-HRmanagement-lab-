package com.example.hrmanagement;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {
    public void handleEmployeeButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Employee.fxml"));
            Parent login = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(login));
            stage.setTitle("Employee");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void handleAdminButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin.fxml")); // Assuming "Login.fxml" exists
            Parent login = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(login));
            stage.setTitle("Admin");

        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as required
        }
    }
    public void handleLogOutButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Parent login = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(login));
            stage.setTitle("Employee");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void handleExitButton(ActionEvent event) {
     Platform.exit();
    }
}

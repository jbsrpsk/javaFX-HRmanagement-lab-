package com.example.hrmanagement;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
public Label email;
    @FXML
    public void loginClick(ActionEvent ActionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
            Parent dashboard = loader.load();
            Stage secondStage = new Stage();
            secondStage.setTitle("Dashboard");
            secondStage.setScene(new Scene(dashboard));
            Stage firstSceneStage = (Stage)
                    email.getScene().getWindow();
            firstSceneStage.close();

            secondStage.show();

        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as required
        }

    }


}
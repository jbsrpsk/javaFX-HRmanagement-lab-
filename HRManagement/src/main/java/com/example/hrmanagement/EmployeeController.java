package com.example.hrmanagement;

import com.example.hrmanagement.Model.Employee;
import com.example.hrmanagement.Model.EmployeeDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeController implements Initializable {
    @FXML
    public TextField iid;
    @FXML
    public TextField iname;
    public TextField iposition;
    public TextField isalary;
    public TableView<Employee> table;
    @FXML
    public TableColumn<Employee, Integer> Id;
    @FXML
    public TableColumn<Employee, String> Name;
    @FXML
    public TableColumn<Employee, String> Position;
    @FXML
    public TableColumn<Employee, Integer> Salary;
    ObservableList<Employee> list = FXCollections.observableArrayList();
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    public void handleLogOutButton(ActionEvent event) {
        DashboardController dashboardController = new DashboardController();
        dashboardController.handleLogOutButton(event);
    }
    public void handleDashboardButton(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
            Parent login = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(login));
            stage.setTitle("Dashboard");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onLoadClick() {
        table.getItems().clear();
        EmployeeDAO a = new EmployeeDAO();
        ObservableList<Employee> list = employeeDAO.populateTable();
        if (list != null && !list.isEmpty()) {
            table.setItems(list);
            System.out.println("data found");
            System.out.println("Items count in the TableView: " + table.getItems().size());
            table.refresh();
        } else {
            System.out.println("No data fetched or the list is empty.");
        }

    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Position.setCellValueFactory(new PropertyValueFactory<>("Position"));
        Salary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
    }

    public void onInsertClick(ActionEvent actionEvent) {
        String name= iname.getText();
        String position= iposition.getText();
        int salary= Integer.parseInt(isalary.getText());


        EmployeeDAO a = new EmployeeDAO();

        a.InsertData(name,position,salary);
    }

    public void onUpdateClick(ActionEvent actionEvent) {
        String name= iname.getText();
        String position= iposition.getText();
        int salary= Integer.parseInt(isalary.getText());
        int id= Integer.parseInt(iid.getText());



        EmployeeDAO a = new EmployeeDAO(); // creating object

        a.UpdateData(name,position,salary,id); // calling method using object of that class and passing data

    }

    public void onDeleteClick(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(iid.getText());
            EmployeeDAO a = new EmployeeDAO();
            a.DeleteData(id);
        } catch (NumberFormatException e) {

            System.out.println("Please enter a valid integer for ID.");

        }
    }


}

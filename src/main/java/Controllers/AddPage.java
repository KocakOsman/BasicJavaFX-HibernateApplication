package Controllers;

import Repositories.UserDao;
import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddPage {

    @FXML
    private TextField emailField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private Button addButton;

    @FXML
    private Button closeButton;

    @FXML
    void addButtonPressed(ActionEvent event) {
        if (firstNameField != null && lastNameField != null && emailField != null){
            if (!firstNameField.getText().equals("") && !lastNameField.getText().equals("") && !emailField.getText().equals("")){
                UserDao userDao = new UserDao();
                User user = new User(firstNameField.getText(),lastNameField.getText(),emailField.getText());
                userDao.addUser(user);
                Controller.users.add(user);
                Stage stage = (Stage) closeButton.getScene().getWindow();
                stage.close();
            }
        }
    }

    @FXML
    void cancelButtonPressed(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

}

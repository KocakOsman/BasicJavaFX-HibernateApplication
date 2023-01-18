package Controllers;

import Model.User;
import Repositories.UserDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditPage {

    public static User user;

    @FXML
    private Button addButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField mailField;

    public void initialize(){
        firstNameField.setText(user.getFirstName());
        lastNameField.setText(user.getLastName());
        mailField.setText(user.getEmail());
    }


    @FXML
    void addButtonPressed(ActionEvent event) {
        if (firstNameField != null && lastNameField != null && mailField != null){
            if (!firstNameField.getText().equals("") && !lastNameField.getText().equals("") && !mailField.getText().equals("")){
                user.setFirstName(firstNameField.getText());
                user.setLastName(lastNameField.getText());
                user.setEmail(mailField.getText());
                UserDao userDao = new UserDao();
                userDao.editUser(user);
                for (int i = 0; i < Controller.users.size(); i++){
                    if (Controller.users.get(i).getId() == user.getId()){
                        Controller.users.set(i,user);
                    }
                }
            }
        }
        Stage stage = (Stage) addButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void cancelButtonPressed(ActionEvent event) {
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.close();
    }


}

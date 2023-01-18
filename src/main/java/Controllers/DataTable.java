package Controllers;

import Repositories.UserDao;
import Model.User;
import com.example.View.JavaFXMain;
import javafx.application.Platform;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class DataTable {
    ObservableList<User> list = Controller.users;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button editButton;

    @FXML
    private Button exitButton;

    @FXML
    private TableView<User> userTable;

    @FXML
    private TableColumn<User,String> firstNameColumn;

    @FXML
    private TableColumn<User, String> lastNameColumn;

    @FXML
    private TableColumn<User,String> emailColumn;


    @FXML
    public void initialize(){
        Property<ObservableList<User>> prop = new SimpleObjectProperty<>(list);
        userTable.itemsProperty().bind(prop);
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<User,String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<User,String>("lastName"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
    }
    @FXML
    void addPressed(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(JavaFXMain.class.getResource("add_page.fxml"));
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void deletePressed(ActionEvent event) {
        User selected = userTable.getSelectionModel().getSelectedItem();
        UserDao userDao = new UserDao();
        userDao.deleteUser(selected);
        list.remove(selected);
    }

    @FXML
    void editPressed(ActionEvent event) throws IOException {
        if (userTable.getSelectionModel().getSelectedItem() != null){
            Stage stage = new Stage();
            EditPage.user = userTable.getSelectionModel().getSelectedItem();
            FXMLLoader loader = new FXMLLoader(JavaFXMain.class.getResource("edit_page.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }

    @FXML
    void exitPressed(ActionEvent event) {
        Platform.exit();
    }

}

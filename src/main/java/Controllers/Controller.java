package Controllers;

import Repositories.UserDao;
import Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller {

    static ObservableList<User> users = FXCollections.observableList(new UserDao().getAllUsers());


}

package com.example.View;

import Repositories.UserDao;
import Model.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFXMain extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(JavaFXMain.class.getResource("welcome_page.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Basic JavaFX-Hibernate Application");
        stage.setScene(scene);
        stage.show();
    }
}

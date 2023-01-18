module com.example.javafxhiber2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.commons.annotations;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.naming;
    requires java.sql;

    opens com.example.View to javafx.fxml;
    opens Model;
    opens HibernateCfg;
    exports com.example.View;
    exports HibernateCfg;
    exports Model;
    exports Controllers;
    opens Controllers to javafx.fxml;
    exports Repositories;
    opens Repositories;
}
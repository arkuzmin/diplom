package ru.arkuzmin.diplom.optimization.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import org.apache.log4j.Logger;

public class App extends Application {

	private static final Logger logger = Logger.getLogger(App.class);
	
    public static void main(String[] args) {
        Application.launch(App.class, (java.lang.String[])null);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
        	primaryStage.initStyle(StageStyle.DECORATED);
            AnchorPane page = (AnchorPane) FXMLLoader.load(App.class.getResource("/ru/arkuzmin/diplom/optimization/ui/fxml/MainView.fxml"));
            Scene scene = new Scene(page, 1000, 700);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
           // primaryStage.getIcons().add(new Image("icons/opt2.png"));
            primaryStage.setTitle("Многокритериальная оптимизация режимов работы котельного отделения электростанции");
        } catch (Exception e) {
            logger.error("Невозможно запустить приложение", e);
        }
    }
}


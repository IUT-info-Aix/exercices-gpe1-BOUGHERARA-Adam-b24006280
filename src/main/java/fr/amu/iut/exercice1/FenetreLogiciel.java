package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {
        // code de l'exercice 1
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 500, 500);

        //Menu bar
        Menu menu1 = new Menu("File");
        MenuItem _new = new MenuItem("New");
        MenuItem open = new MenuItem("Open");
        MenuItem save = new MenuItem("Save");
        MenuItem close = new MenuItem("Close");

        menu1.getItems().addAll(_new, open, save, close);
        Menu menu2 = new Menu("Edit");
        MenuItem cut = new MenuItem("Cut");
        MenuItem Copy = new MenuItem("Copy");
        MenuItem paste = new MenuItem("Paste");
        menu2.getItems().addAll(cut, Copy, paste);


        Menu menu3 = new Menu("Help");

        MenuBar menuBar = new MenuBar(menu1, menu2, menu3);
        root.setTop(menuBar);
        primaryStage.setTitle("Premier exemple manipulant les conteneurs");
        primaryStage.setScene(scene );
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}


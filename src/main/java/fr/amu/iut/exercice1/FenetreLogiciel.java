package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.swing.*;

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

        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");

        VBox buttons = new VBox(new Label("Boutons : "),button1,button2,button3);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(10);
        root.setLeft(buttons);

        VBox formBox = new VBox();

        GridPane grid = new GridPane();
        formBox.getChildren().add(grid);

        grid.add(new Label("Name:"),0,0); grid.add(new TextField(),1,0);
        grid.add(new Label("Email:"),0,1); grid.add(new TextField(),1,1);
        grid.add(new Label("Password:"),0,2); grid.add(new PasswordField(),1,2);

        HBox formButtons = new HBox(new Button("Submit"),new Button("Cancel"));
        formButtons.setAlignment(Pos.CENTER);
        formButtons.setSpacing(10);

        formBox.setSpacing(10);
        formBox.getChildren().add(formButtons);
        grid.setHgap(5);
        grid.setVgap(10);

        grid.setAlignment(Pos.CENTER);
        formBox.setAlignment(Pos.CENTER);

        HBox basDePage = new HBox(new Label("Ceci est un label de bas de page"));
        basDePage.setAlignment(Pos.CENTER);
        root.setBottom(basDePage);
        root.setCenter(formBox);
        primaryStage.setTitle("Premier exemple manipulant les conteneurs");
        primaryStage.setScene(scene );
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}


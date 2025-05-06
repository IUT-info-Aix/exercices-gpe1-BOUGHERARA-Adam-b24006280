package fr.amu.iut.exercice8;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;



public class LoginControl extends GridPane {

    @FXML
    TextField txtField;
    @FXML
    PasswordField pwd;
    @FXML
    private void okClicked() {
        System.out.println("Nom d'utilisateur : " + txtField.getText());
        System.out.println("Mot de passe : " + "*".repeat(pwd.getText().length()));
    }

    @FXML
    private void cancelClicked() {
        txtField.clear();
        pwd.clear();
    }
}
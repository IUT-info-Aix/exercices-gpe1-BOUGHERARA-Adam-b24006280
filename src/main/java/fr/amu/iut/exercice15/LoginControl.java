package fr.amu.iut.exercice15;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class LoginControl extends GridPane implements Initializable {
    @FXML
    private TextField userId;

    @FXML
    private PasswordField pwd;

    @FXML
    private Button okBtn;

    @FXML
    private Button cancelBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createBindings();
    }

    private void createBindings() {
        // 1. Le champ mot de passe n'est pas éditable si userId < 6 caractères
        pwd.disableProperty().bind(
                Bindings.createBooleanBinding(
                        () -> userId.getText().length() < 6,
                        userId.textProperty()
                )
        );

        // 2. Le bouton cancel n'est pas cliquable si les deux champs sont vides
        cancelBtn.disableProperty().bind(
                Bindings.createBooleanBinding(
                        () -> userId.getText().isEmpty() && pwd.getText().isEmpty(),
                        userId.textProperty(), pwd.textProperty()
                )
        );

        // 3. Le bouton ok n'est pas cliquable si le mot de passe ne respecte pas les contraintes
        BooleanBinding passwordValid = Bindings.createBooleanBinding(
                () -> {
                    String password = pwd.getText();
                    // Au moins 8 caractères
                    boolean hasMinLength = password.length() >= 8;
                    // Au moins une majuscule
                    boolean hasUpperCase = Pattern.compile("[A-Z]").matcher(password).find();
                    // Au moins un chiffre
                    boolean hasDigit = Pattern.compile("\\d").matcher(password).find();

                    return hasMinLength && hasUpperCase && hasDigit;
                },
                pwd.textProperty()
        );

        okBtn.disableProperty().bind(passwordValid.not());
    }

    @FXML
    private void okClicked() {
        System.out.print(userId.getText() + " ");
        for (char c : pwd.getText().toCharArray()) {
            System.out.print("*");
        }
        System.out.println();
    }

    @FXML
    private void cancelClicked() {
        userId.setText("");
        pwd.setText("");
    }
}
package fr.amu.iut.exercice11;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Palette extends Application {

    private Label texteDuHaut;
    private Button vert;
    private Button rouge;
    private Button bleu;
    private BorderPane root;
    private Pane panneau;
    private HBox boutons;
    private Label texteDuBas;

    // Propriétés pour chaque couleur
    private IntegerProperty nbFoisVert;
    private IntegerProperty nbFoisRouge;
    private IntegerProperty nbFoisBleu;
    private StringProperty couleurSelectionnee;
    private StringProperty message;
    private StringProperty couleurPanneau;

    public Palette() {
        nbFoisVert = new SimpleIntegerProperty(0);
        nbFoisRouge = new SimpleIntegerProperty(0);
        nbFoisBleu = new SimpleIntegerProperty(0);
        couleurSelectionnee = new SimpleStringProperty("");
        message = new SimpleStringProperty("");
        couleurPanneau = new SimpleStringProperty("#000000");
    }

    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();

        texteDuHaut = new Label();
        texteDuHaut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(texteDuHaut, Pos.CENTER);

        panneau = new Pane();
        panneau.setPrefSize(400, 200);

        VBox bas = new VBox();
        boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10, 5, 10, 5));
        texteDuBas = new Label();
        bas.setAlignment(Pos.CENTER_RIGHT);
        bas.getChildren().addAll(boutons, texteDuBas);

        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");

        vert.setOnAction(event -> {
            nbFoisVert.set(nbFoisVert.get() + 1);
            couleurSelectionnee.set("Vert");
            message.set("Le Vert est une jolie couleur !");
            couleurPanneau.set("#00FF00");
        });

        rouge.setOnAction(event -> {
            nbFoisRouge.set(nbFoisRouge.get() + 1);
            couleurSelectionnee.set("Rouge");
            message.set("Le Rouge est une jolie couleur !");
            couleurPanneau.set("#FF0000");
        });

        bleu.setOnAction(event -> {
            nbFoisBleu.set(nbFoisBleu.get() + 1);
            couleurSelectionnee.set("Bleu");
            message.set("Le Bleu est une jolie couleur !");
            couleurPanneau.set("#0000FF");
        });

        boutons.getChildren().addAll(vert, rouge, bleu);

        root.setCenter(panneau);
        root.setTop(texteDuHaut);
        root.setBottom(bas);

        createBindings();

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createBindings() {
        // Binding du texte du haut selon la couleur sélectionnée et le compteur associé
        texteDuHaut.textProperty().bind(
                Bindings.createStringBinding(() -> {
                    switch (couleurSelectionnee.get()) {
                        case "Vert":
                            return "Nombre de clics Vert : " + nbFoisVert.get();
                        case "Rouge":
                            return "Nombre de clics Rouge : " + nbFoisRouge.get();
                        case "Bleu":
                            return "Nombre de clics Bleu : " + nbFoisBleu.get();
                        default:
                            return "Cliquez sur un bouton !";
                    }
                }, couleurSelectionnee, nbFoisVert, nbFoisRouge, nbFoisBleu)
        );

        // Binding du style du panneau
        panneau.styleProperty().bind(
                Bindings.concat("-fx-background-color: ", couleurPanneau)
        );

        // Binding du texte et de la couleur du label du bas
        texteDuBas.textProperty().bind(message);
        texteDuBas.textFillProperty().bind(
                Bindings.createObjectBinding(() -> Color.web(couleurPanneau.get()), couleurPanneau)
        );
    }
}
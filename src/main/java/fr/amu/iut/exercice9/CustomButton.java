package fr.amu.iut.exercice9;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.InputStream;

public class CustomButton extends Parent {

    private ImageView imageView;

    public CustomButton() {
        StackPane st = new StackPane();

        InputStream imageStream = getClass().getResourceAsStream("Rond.png");
        if (imageStream != null) {
            Image image = new Image(imageStream);
            imageView = new ImageView(image);
        } else {
            System.err.println("Image not found!");
        }

        Label label = new Label("Clic");
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        label.setTextFill(Color.ORANGERED);

        st.getChildren().addAll(imageView, label);
        this.getChildren().add(st);
    }

    public void addOnMousePressed(EventHandler<MouseEvent> eventHandler) {
        imageView.setOnMousePressed(eventHandler);
    }

}
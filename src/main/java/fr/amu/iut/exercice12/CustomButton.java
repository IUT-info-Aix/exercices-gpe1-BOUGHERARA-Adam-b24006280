package fr.amu.iut.exercice12;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Button;

public class CustomButton extends Button {
    private final String couleur;
    private final IntegerProperty nbClics = new SimpleIntegerProperty(0);

    public CustomButton(String text, String couleur) {
        super(text);
        this.couleur = couleur;
    }

    public int getNbClics() {
        return nbClics.get();
    }

    public void setNbClics(int value) {
        nbClics.set(value);
    }

    public IntegerProperty nbClicsProperty() {
        return nbClics;
    }

    public String getCouleur() {
        return couleur;
    }
}
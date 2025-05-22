package fr.amu.iut.exercice13;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

@SuppressWarnings("Duplicates")
public class MainPersonnes {

    private static ObservableList<Personne> lesPersonnes;
    private static ListChangeListener<Personne> unChangementListener;
    private static ListChangeListener<Personne> plusieursChangementsListener;

    public static void main(String[] args) {
        // Pour écouter les changements d'âge
        lesPersonnes = FXCollections.observableArrayList(personne ->
                new Observable[] {personne.ageProperty()});

        // Listener pour un seul changement
        unChangementListener = change -> {
            if (change.next()) {
                if (change.wasAdded()) {
                    for (Personne p : change.getAddedSubList()) {
                        System.out.println("Ajouté : " + p.getNom());
                    }
                }
                if (change.wasRemoved()) {
                    for (Personne p : change.getRemoved()) {
                        System.out.println("Supprimé : " + p.getNom());
                    }
                }
                if (change.wasUpdated()) {
                    int index = change.getFrom();
                    Personne p = lesPersonnes.get(index);
                    System.out.println(p.getNom() + " a maintenant " + p.getAge() + " ans");
                }
            }
        };

        // Listener pour plusieurs changements
        plusieursChangementsListener = change -> {
            while (change.next()) {
                if (change.wasAdded()) {
                    for (Personne p : change.getAddedSubList()) {
                        System.out.println("Ajouté : " + p.getNom());
                    }
                }
                if (change.wasRemoved()) {
                    for (Personne p : change.getRemoved()) {
                        System.out.println("Supprimé : " + p.getNom());
                    }
                }
                if (change.wasUpdated()) {
                    int index = change.getFrom();
                    Personne p = lesPersonnes.get(index);
                    System.out.println(p.getNom() + " a maintenant " + p.getAge() + " ans");
                }
            }
            System.out.println("Fin de la série de changements");
        };

        // Pour les questions 1, 2, 3 :
        //lesPersonnes.addListener(unChangementListener);

        // Pour la question 5 :
        lesPersonnes.addListener(plusieursChangementsListener);

        // Décommentez la méthode à tester :
         //question1();
        // question2();
        // question3();
         question5();
    }

    public static void question1() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
    }

    public static void question2() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
        lesPersonnes.remove(paul);
    }

    public static void question3() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
        paul.setAge(5);
    }

    public static void question5() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.addAll(pierre, paul, jacques);
        for (Personne p : lesPersonnes)
            p.setAge(p.getAge()+10);
        lesPersonnes.removeAll(paul, pierre);
    }
}
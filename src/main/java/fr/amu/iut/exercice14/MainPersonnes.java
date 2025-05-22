package fr.amu.iut.exercice14;

import javafx.beans.Observable;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

@SuppressWarnings("Duplicates")
public class MainPersonnes {

    private static SimpleListProperty<Personne> lesPersonnes;
    private static IntegerProperty ageMoyen;
    private static IntegerProperty nbParisiens;

    private static IntegerBinding calculAgeMoyen;
    private static IntegerBinding calculnbParisiens;

    public static void main(String[] args) {
        // Initialisation avec factory pour écouter les propriétés internes
        lesPersonnes = new SimpleListProperty<>(FXCollections.observableArrayList(personne ->
                new Observable[] { personne.ageProperty(), personne.villeDeNaissanceProperty() }));

        ageMoyen = new SimpleIntegerProperty(0);
        nbParisiens = new SimpleIntegerProperty(0);

        // Binding bas-niveau pour l'âge moyen
        calculAgeMoyen = new IntegerBinding() {
            {
                // Lier le binding à la liste de personnes
                bind(lesPersonnes);

                // Ajouter un listener pour rebinder quand la liste change
                lesPersonnes.addListener((Observable observable) -> {
                    // Vider les liaisons existantes
                    unbind(lesPersonnes);
                    // Rebinder à la liste
                    bind(lesPersonnes);
                    // Lier aux propriétés âge de chaque personne
                    for (Personne p : lesPersonnes) {
                        bind(p.ageProperty());
                    }
                    // Déclencher le recalcul
                    invalidate();
                });

                // Lier aux propriétés âge des personnes existantes
                for (Personne p : lesPersonnes) {
                    bind(p.ageProperty());
                }
            }

            @Override
            protected int computeValue() {
                if (lesPersonnes.isEmpty()) return 0;

                int somme = 0;
                for (Personne p : lesPersonnes) {
                    somme += p.getAge();
                }
                return somme / lesPersonnes.size();
            }
        };

        // Binding bas-niveau pour le nombre de parisiens
        calculnbParisiens = new IntegerBinding() {
            {
                // Lier le binding à la liste de personnes
                bind(lesPersonnes);

                // Ajouter un listener pour rebinder quand la liste change
                lesPersonnes.addListener((Observable observable) -> {
                    // Vider les liaisons existantes
                    unbind(lesPersonnes);
                    // Rebinder à la liste
                    bind(lesPersonnes);
                    // Lier aux propriétés villeDeNaissance de chaque personne
                    for (Personne p : lesPersonnes) {
                        bind(p.villeDeNaissanceProperty());
                    }
                    // Déclencher le recalcul
                    invalidate();
                });

                // Lier aux propriétés villeDeNaissance des personnes existantes
                for (Personne p : lesPersonnes) {
                    bind(p.villeDeNaissanceProperty());
                }
            }

            @Override
            protected int computeValue() {
                int count = 0;
                for (Personne p : lesPersonnes) {
                    if ("Paris".equals(p.getVilleDeNaissance())) {
                        count++;
                    }
                }
                return count;
            }
        };

        // Lier les propriétés aux bindings
        ageMoyen.bind(calculAgeMoyen);
        nbParisiens.bind(calculnbParisiens);

        question1();
         question2();
    }

    public static void question1() {
        System.out.println("1 - L'age moyen est de " + ageMoyen.getValue() + " ans");
        Personne pierre = new Personne("Pierre", 20);
        lesPersonnes.add(pierre);
        System.out.println("2 - L'age moyen est de " + ageMoyen.getValue() + " ans");
        Personne paul = new Personne("Paul", 40);
        lesPersonnes.add(paul);
        System.out.println("3 - L'age moyen est de " + ageMoyen.getValue() + " ans");
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(jacques);
        System.out.println("4 - L'age moyen est de " + ageMoyen.getValue() + " ans");
        paul.setAge(100);
        System.out.println("5 - L'age moyen est de " + ageMoyen.getValue() + " ans");
        lesPersonnes.remove(paul);
        System.out.println("6 - L'age moyen est de " + ageMoyen.getValue() + " ans");
    }

    public static void question2() {
        System.out.println("Il y a " + nbParisiens.getValue() + " parisiens");
        lesPersonnes.get(0).setVilleDeNaissance("Marseille");
        System.out.println("Il y a " + nbParisiens.getValue() + " parisiens");
        lesPersonnes.get(1).setVilleDeNaissance("Montpellier");
        System.out.println("Il y a " + nbParisiens.getValue() + " parisien");
        for (Personne p : lesPersonnes)
            p.setVilleDeNaissance("Paris");
        System.out.println("Il y a " + nbParisiens.getValue() + " parisiens");
    }
}
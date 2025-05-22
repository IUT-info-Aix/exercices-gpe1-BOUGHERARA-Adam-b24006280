module tp.intro.javafx {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires java.desktop;
    exports com.example.partie1;
    exports com.example.partie2;
    exports com.example.partie3;
    exports com.example.partie4;
    opens com.example.partie3 to javafx.fxml;
    opens fr.amu.iut.exercice7 to javafx.fxml;
    exports fr.amu.iut.exercice7;
    opens fr.amu.iut.exercice8 to javafx.fxml;
    exports fr.amu.iut.exercice8;
    opens fr.amu.iut.exercice9 to javafx.fxml;
    exports fr.amu.iut.exercice9;
    opens com.example.partie4 to javafx.fxml;
    exports fr.amu.iut.exercice11;
    exports fr.amu.iut.exercice12;
    exports fr.amu.iut.exercice13;
    opens fr.amu.iut.exercice15 to javafx.fxml;
    exports fr.amu.iut.exercice15;
    opens fr.amu.iut.exercice16 to javafx.fxml;
    exports fr.amu.iut.exercice16;
}

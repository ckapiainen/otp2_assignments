module app.week2_bmi {
    requires javafx.controls;
    requires javafx.fxml;


    opens app.week2_bmi to javafx.fxml;
    exports app.week2_bmi;
}
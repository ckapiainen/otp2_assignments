package app.week2_bmi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Locale;
import java.util.ResourceBundle;

public class BMIController {

    @FXML
    private Label lblWeight;

    @FXML
    private Label lblHeight;

    @FXML
    private TextField txtWeight;

    @FXML
    private TextField txtHeight;

    @FXML
    private Button btnCalculate;

    @FXML
    private Label lblResult;

    private ResourceBundle rb;

    @FXML
    public void initialize() {
        setLanguage(new Locale("en", "US"));
    }

    private void setLanguage(Locale locale) {
        try {
            rb = ResourceBundle.getBundle("messages", locale);

            lblWeight.setText(rb.getString("lblWeight.text"));
            lblHeight.setText(rb.getString("lblHeight.text"));
            btnCalculate.setText(rb.getString("btnCalculate.text"));

        } catch (Exception e) {
            lblResult.setText("Error: Language file not found for " + locale.toString());
        }

    }
    @FXML
    public void onENClick(ActionEvent actionEvent) {
        setLanguage(new Locale("en", "US"));
    }


    @FXML
    public void onFRClick(ActionEvent actionEvent) {
        setLanguage(new Locale("fr", "FR"));
    }
    @FXML
    public void onVIClick(ActionEvent actionEvent) {
        setLanguage(new Locale("vi", "VI"));
    }


    @FXML
    public void onURClick(ActionEvent actionEvent) {
        setLanguage(new Locale("ur", "PA"));
    }


    @FXML
    public void onCalculateClick() {
        try {
            double weight = Double.parseDouble(txtWeight.getText().trim());
            double height = Double.parseDouble(txtHeight.getText().trim());

            double bmi = weight / (height * height);

            String bmiString = String.format("%.2f", bmi);

            lblResult.setText(rb.getString("lblResult.text") + " " + bmiString);

        } catch (Exception e) {
            lblResult.setText(rb.getString("lblInvalid.text"));
        }
    }
}

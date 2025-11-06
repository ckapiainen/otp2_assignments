package app.week2_bmi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;

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

    @FXML
    private Label lblLocalTime;

    private Map<String, String> localizedStrings;
    private Locale currentLocale;

    @FXML
    public void initialize() {
        setLanguage(new Locale("en", "US"));
    }

    private void setLanguage(Locale locale) {
        lblResult.setText("");
        currentLocale = locale;
        localizedStrings = LocalizationService.getLocalizedStrings(locale);

        lblWeight.setText(localizedStrings.get("weight"));
        lblHeight.setText(localizedStrings.get("height"));
        btnCalculate.setText(localizedStrings.get("calculate"));

        displayLocalTime(locale);
    }

    private void displayLocalTime(Locale locale) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timeLabel = localizedStrings.get("localTime");
        lblLocalTime.setText(timeLabel + ": " + now.format(formatter));
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
            double weight = Double.parseDouble(txtWeight.getText());
            double height = Double.parseDouble(txtHeight.getText()) / 100.0;
            double bmi = weight / (height * height);

            DecimalFormat df = new DecimalFormat("#0.00");
            lblResult.setText(localizedStrings.getOrDefault("result", "Your BMI is") + " " + df.format(bmi));

            // Save to database
            String language = currentLocale.getLanguage();
            BMIResultService.saveResult(weight, height * 100, bmi, language);

        } catch (NumberFormatException e) {
            lblResult.setText(localizedStrings.getOrDefault("invalid", "Invalid input"));
        }
    }
}

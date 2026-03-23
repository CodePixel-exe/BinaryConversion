package nclan.ac.spa.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import nclan.ac.cs.topic1.conversion;
import nclan.ac.spa.SceneSwitcher;

public class ConversionController {
    @FXML
    TextField decimalInput;
    @FXML
    TextField binaryOutput;
    @FXML
    TextField decimalOutput;
    @FXML
    TextField hexadecimalOutput;
    @FXML
    TextField hexInput;
    @FXML
    TextField binaryInput;
    @FXML
    Button hxButton;


    /** Get Input and Output to Display them
     * Displays the input and output using the setText method in the textFields.
     * @param actionEvent
     */
    public void convertDecimal(ActionEvent actionEvent) {
        try {
            String input = decimalInput.getText();
            int decimal = Integer.parseInt(input);

            String binary = conversion.convertDecimalToBinary(decimal);
            String hex = conversion.convertDecimalToHex(decimal);

            decimalOutput.setText(String.valueOf(decimal));
            binaryOutput.setText(binary);
            hexadecimalOutput.setText(hex);

        } catch (Exception e) {
            SceneSwitcher.showErrorDialog("Only enter decimal numbers please!");
        }
    }
    public void convertHex(ActionEvent actionEvent) {
        try {
            String input = hexInput.getText().trim();
            int decimal = conversion.convertHexToDecimal(input);

            String binary = conversion.convertHexToBinary(decimal);
            String hex = conversion.convertDecimalToHex(decimal);


            decimalOutput.setText(String.valueOf((decimal)));
            binaryOutput.setText(binary);
            hexadecimalOutput.setText(hex);

        } catch (Exception e) {
            SceneSwitcher.showErrorDialog("Only enter hexadecimal numbers please!");
        }
    }
    public void convertBinary(ActionEvent actionEvent) {
        try {
            String input = binaryInput.getText();
            int decimal = conversion.convertBinaryToDecimal(input);
            String binary = conversion.convertDecimalToBinary(decimal);
            String hex = conversion.convertBinaryToHex(decimal);


            decimalOutput.setText(String.valueOf((decimal)));
            binaryOutput.setText(binary);
            hexadecimalOutput.setText(hex.toUpperCase());

        } catch (Exception e) {
            SceneSwitcher.showErrorDialog("Only enter binary numbers please!");
        }
    }
}

package nclan.ac.spa.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import nclan.ac.cs.topic1.conversion;
import nclan.ac.cs.topic1.representation;
import nclan.ac.spa.SceneSwitcher;


public class RepresentationController {
    @FXML
    TextField conversionInput;
    @FXML
    private RadioButton hexRb;
    @FXML
   private RadioButton decimalRb;
    @FXML
    TextField conversionOutput;
    @FXML
    Button convertBtn;


    @FXML
    public void initialize() {
        decimalRb.setSelected(true);
    }
    /**Converter for ASCII
     *Converts to Decimal
     *Converts to Hex
     * @param actionEvent
     */
    public void ASCIIConverter(javafx.event.ActionEvent actionEvent) {
        try{
            //Sets up input for characters.
            String charInput = conversionInput.getText();

            String result = " ";

            if(decimalRb.isSelected()) {
                //Converts to show number in ASCII
                result = String.valueOf(conversion.convertHexToDecimal(String.valueOf(charInput)));
            } else if (hexRb.isSelected()) {
                result = representation.stringToHex(charInput);
            }


            conversionOutput.setText(result);


        } catch (Exception e) {
            SceneSwitcher.showErrorDialog("Input only accepts characters, please try again!");
        }
    }
}

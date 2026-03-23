package nclan.ac.spa.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import nclan.ac.spa.SceneSwitcher;
import nclan.ac.cs.topic1.BitWiseLogic;

import javax.print.DocFlavor;
import java.net.URL;
import java.util.ResourceBundle;

public class BitwiseLogicController {
    @FXML
    TextField numInput1;
    @FXML
    TextField numInput2;
    @FXML
    TextField bitwiseOutput;
    @FXML
    ComboBox<String> operatorMenu;
    @FXML


   public void initialize(){
       operatorMenu.getItems().addAll("AND","OR","XOR");
   }

    public void bitwiseOperations(ActionEvent actionEvent) {
        try {
            String input1 = numInput1.getText();
            String input2 = numInput2.getText();


            String userChoice = operatorMenu.getValue();
            String bitResult = switch (userChoice) {
                case "AND" -> BitWiseLogic.binaryAND(input1, input2);
                case "OR" -> BitWiseLogic.binaryOR(input1, input2);
                case "XOR" -> BitWiseLogic.binaryXOR(input1, input2);
                default -> "";
            };
            bitwiseOutput.setText(bitResult);






        } catch (Exception e) {
            SceneSwitcher.showErrorDialog("Only enter binary numbers please!");
        }
    }
}


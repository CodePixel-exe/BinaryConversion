package nclan.ac.spa.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Node;
import nclan.ac.spa.SceneSwitcher;
import javafx.fxml.FXML;
import javafx.application.Platform;

public class HomeController {

    @FXML
    public StackPane contentArea;

    @FXML
    private Label txtMessage;

    @FXML
    private VBox leftMenu;


    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private HBox titleBar;

    @FXML
    public void initialize() {
        SceneSwitcher.setContentArea(contentArea);
        SceneSwitcher.setMessageField(txtMessage);
        // Set the default view so the center isn't empty on startup
        SceneSwitcher.changeCenter("/nclan/ac/spa/conversion.fxml");

        titleBar.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        titleBar.setOnMouseDragged(event -> {
            Stage stage = (Stage) titleBar.getScene().getWindow();
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
    }

    @FXML
    private void closeWindow() {
        Platform.exit();
    }

    @FXML
    private void minimizeWindow(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void handleExit() {
        Platform.exit();
    }

    private void highlightButton(Button selectedButton) {
        // 1. Clear the 'active' class from ALL buttons in the sidebar
        for (Node node : leftMenu.getChildren()) {
            if (node instanceof Button) {
                node.getStyleClass().remove("active");
            }
        }

        // 2. Add the 'active' class to the clicked button
        selectedButton.getStyleClass().add("active");
    }

    public void showConversion(ActionEvent actionEvent) {
        SceneSwitcher.changeCenter("/nclan/ac/spa/Conversion.fxml");
        highlightButton((Button) actionEvent.getSource());
    }
    public void showBitwiseLogic(ActionEvent actionEvent) {
        SceneSwitcher.changeCenter("/nclan/ac/spa/BitwiseLogic.fxml");
        highlightButton((Button) actionEvent.getSource());
    }
    public void showRepresentation(ActionEvent actionEvent){
        SceneSwitcher.changeCenter("/nclan/ac/spa/Representation.fxml");
        highlightButton((Button) actionEvent.getSource());
    }
    public void showAI(ActionEvent actionEvent){
        SceneSwitcher.changeCenter("/nclan/ac/spa/AiChat.fxml");
        highlightButton((Button) actionEvent.getSource());
    }
}
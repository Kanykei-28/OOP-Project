package project;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {

    @FXML
    private ChoiceBox<String> convertChoiceBox;

    @FXML
    private TextField inputTextField;

    @FXML
    private TextField resultTextField;

    @FXML
    private Button convertButton;

    @FXML
    private MenuItem exit;

    @FXML
    private MenuItem about;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Initializing ChoiceBox values
        convertChoiceBox.getItems().addAll( "Decimal to Binary", "Decimal to Hexadecimal", "Binary to Decimal", "Binary to Hexadecimal", "Hexadecimal to Decimal","Hexadecimal to Binary");
        convertChoiceBox.getSelectionModel().select("Decimal to Binary");
        convertChoiceBox.setStyle("-fx-text-fill: white;"+"-fx-background-radius:20px");

        //exit
        exit.setOnAction(e -> Platform.exit());

    }
    @FXML
    //Menu -> About option
    void aboutMenu(ActionEvent event) {
        Alert informationAlert=new Alert(Alert.AlertType.INFORMATION,"Info");
        informationAlert.setTitle("About app");
        informationAlert.setHeaderText("Completed by Kanykei");
        informationAlert.setContentText("05/27/2021\nCourse: OOP\n");
        informationAlert.showAndWait();

    }
    @FXML
    //performing specific tasks according to the selected choice
    void convert(ActionEvent event) {
        if (convertChoiceBox.getSelectionModel().getSelectedItem()=="Decimal to Binary") {
            int inputNumber = Integer.parseInt(inputTextField.getText());
            resultTextField.setText(Integer.toBinaryString(inputNumber));
        }
        else if(convertChoiceBox.getSelectionModel().getSelectedItem()=="Decimal to Hexadecimal"){
            int inputNumber=Integer.parseInt(inputTextField.getText());
            int num=inputNumber;
            String str = Integer.toHexString(num);
            resultTextField.setText(str.toUpperCase());

        }else if(convertChoiceBox.getSelectionModel().getSelectedItem()=="Binary to Decimal"){
            int inputNumber=Integer.parseInt(inputTextField.getText());
            int decimalNumber=0;
            int index=0;
            int mod=0;
            int binaryNumber=inputNumber;
            while(binaryNumber!=0){
                mod=binaryNumber%10;
                decimalNumber= (int) (decimalNumber+mod*Math.pow(2,index));
                binaryNumber=binaryNumber/10;
                index++;
            }
            resultTextField.setText(String.valueOf(decimalNumber));
        }else if(convertChoiceBox.getSelectionModel().getSelectedItem()=="Binary to Hexadecimal"){
            int inputNumber=Integer.parseInt(inputTextField.getText());
            int decimalNumber=0;
            int index=0;
            int mod=0;
            int binaryNumber=inputNumber;
            while(binaryNumber!=0){
                mod=binaryNumber%10;
                decimalNumber= (int) (decimalNumber+mod*Math.pow(2,index));
                binaryNumber=binaryNumber/10;
                index++;
            }
            int num=decimalNumber;
            String str = Integer.toHexString(num);
            resultTextField.setText(str.toUpperCase());

        }else if(convertChoiceBox.getSelectionModel().getSelectedItem()=="Hexadecimal to Decimal"){
            String inputNumber=inputTextField.getText();
            String hexVal=String.valueOf(inputNumber).toUpperCase();
            int len = hexVal.length();
            int base = 1;
            int dec_val = 0;
            for (int i = len - 1; i >= 0; i--) {

                if (hexVal.charAt(i) >= '0'
                        && hexVal.charAt(i) <= '9') {
                    dec_val += (hexVal.charAt(i) - 48) * base;
                    base = base * 16;
                }
                else if (hexVal.charAt(i) >= 'A'
                        && hexVal.charAt(i) <= 'F') {
                    dec_val += (hexVal.charAt(i) - 55) * base;
                    base = base * 16;
                }
            }
            resultTextField.setText(String.valueOf(dec_val));

        }else if(convertChoiceBox.getSelectionModel().getSelectedItem()=="Hexadecimal to Binary"){
            String inputNumber=inputTextField.getText();
            String hexVal=String.valueOf(inputNumber).toUpperCase();
            int len = hexVal.length();
            int base = 1;
            int dec_val = 0;
            for (int i = len - 1; i >= 0; i--) {
                if (hexVal.charAt(i) >= '0'
                        && hexVal.charAt(i) <= '9') {
                    dec_val += (hexVal.charAt(i) - 48) * base;
                    base = base * 16;
                }
                else if (hexVal.charAt(i) >= 'A'
                        && hexVal.charAt(i) <= 'F') {
                    dec_val += (hexVal.charAt(i) - 55) * base;
                    base = base * 16;
                }
            }
            System.out.println(dec_val);

            resultTextField.setText(Integer.toBinaryString(dec_val));

        }

    }


}


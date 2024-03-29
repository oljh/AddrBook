package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import objects.Person;
import utils.DialogManager;
import java.net.URL;

import java.util.ResourceBundle;


public class EditDialogController implements Initializable {

    @FXML
    private Button btnOk;

    @FXML
    private Button btnClose;

    @FXML
    private TextField txtFIO;

    @FXML
    private TextField txtPhone;

    private Person person;

    private ResourceBundle resourceBundle;


    public void actionClose (ActionEvent actionEvent){
        Node source = (Node)actionEvent.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.hide();
    }

    public Person getPerson(){return person;}

    public void setPerson(Person person){
        if(person == null){
            return;
        }
        this.person = person;
        txtFIO.setText(person.getFio());
        txtPhone.setText(person.getPhone());
    }

    public void actionSave(ActionEvent actionEvent){
        if(!checkValues()){
            return;
        }
        person.setPhone(txtPhone.getText());
        person.setFio(txtFIO.getText());
        actionClose(actionEvent);
    }

    private boolean checkValues() {
        if(txtFIO.getText().trim().length()==0 || txtPhone.getText().trim().length()==0){
            DialogManager.showInfoDialog(resourceBundle.getString("error"), resourceBundle.getString("fill_field"));
            return false;
        }
        return true;
    }


    public void initialize (URL location, ResourceBundle resources){this.resourceBundle = resources;}
}

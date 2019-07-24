package controllers;

import interfaces.impls.CollectionAddressBook;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import objects.Person;

import java.io.IOException;

public class MainController {
private CollectionAddressBook addressBookImpls = new CollectionAddressBook();
    @FXML
    private Button addButton;

    @FXML
    private Button delButton;

    @FXML
    private Button searchButton;

    @FXML
    private Button changeButton;

    @FXML
    private TableView tableAddressBook;

    @FXML
    private TextField txtSearch;

    @FXML
    private TableColumn<Person, String> columnFIO;

    @FXML
    private TableColumn<Person, String> columnPhone;

    @FXML
    private Label labelCount;



    @FXML
    private void initialize(){
        columnFIO.setCellValueFactory(new PropertyValueFactory<Person, String>("fio"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));

        addressBookImpls.fillTestData();

        tableAddressBook.setItems(addressBookImpls.getPersonList());


    }

    public void updateCountLable(){
        labelCount.setText("Количество записей " + addressBookImpls.getPersonList().size());
    }
    public void showDialog(ActionEvent actionEvent) {
        try {

            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/edit.fxml"));
            stage.setTitle("Редактирование записи");
            stage.setMinHeight(150);
            stage.setMinWidth(300);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
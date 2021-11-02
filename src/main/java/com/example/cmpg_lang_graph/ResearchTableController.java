package com.example.cmpg_lang_graph;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import utility.DBUtility;
import utility.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ResearchTableController implements Initializable {

    @FXML
    private TableView<Answer> tableView;

    @FXML
    private TableColumn<Answer, Integer> responseIdColumn;

    @FXML
    private TableColumn<Answer, String> countryColumn;

    @FXML
    private TableColumn<Answer, Integer> yearsCodingColumn;

    @FXML
    private TableColumn<Answer, String> opSysColumn;

    @FXML
    private TableColumn<Answer, Integer> compensationColumn;

    @FXML
    private TableColumn<Answer, Integer> ageColumn;

    @FXML
    private JFXButton buttonGraph;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        responseIdColumn.setCellValueFactory(new PropertyValueFactory<>("response_id" ));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country" ));
        yearsCodingColumn.setCellValueFactory(new PropertyValueFactory<>("years_coding" ));
        opSysColumn.setCellValueFactory(new PropertyValueFactory<>("op_sys" ));
        compensationColumn.setCellValueFactory(new PropertyValueFactory<>("converted_yearly_compensation" ));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age" ));


        tableView.getItems().addAll(DBUtility.getFullTable());

    }

    @FXML
    private void changeScene(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "devCompensationView.fxml", "Graphs");
    }
}

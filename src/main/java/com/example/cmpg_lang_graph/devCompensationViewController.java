package com.example.cmpg_lang_graph;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import utility.DBUtility;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import utility.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class devCompensationViewController implements Initializable {

    //insert here modules from fxml Scene Builder
    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis yearsCodingAxis;

    @FXML
    private NumberAxis compensationAxis;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        barChart.getData().addAll(DBUtility.getCompensation());
        barChart.setLegendVisible(false);

        compensationAxis.setLabel("Yearly Compensation");
        yearsCodingAxis.setLabel("Years Coding");
    }

    @FXML
    private void changeScenes(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "researchTable.fxml","Research Full Table");
    }
}

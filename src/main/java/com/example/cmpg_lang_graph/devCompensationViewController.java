package com.example.cmpg_lang_graph;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import utility.DBUtility;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;

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
}

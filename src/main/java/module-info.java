module com.example.cmpg_lang_graph {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.cmpg_lang_graph to javafx.fxml;
    exports com.example.cmpg_lang_graph;
}
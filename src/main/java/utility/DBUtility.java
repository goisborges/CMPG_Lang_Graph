// This class will make the connection to our AWS database

package utility;

import javafx.scene.chart.XYChart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtility {
    private static String user = "goisborges";
    private static String pw = "AwsMarcos22720661";
    private static String connectURL = "jdbc:mysql:ls-47a503707755f08f5347974e3b57ce24375a3ab0.clh9n1ueosen.ca-central-1.rds.amazonaws.com";

    //Method that will retrieve and insert info on the languages chart
    public static XYChart.Series<String, Integer> getCompensation(){
        XYChart.Series<String, Integer> languageData = new XYChart.Series<>();

        String sql = "SELECT";

        //using the try with resources block ensures that anything opened in the (...) will be closed
        try(
                Connection conn = DriverManager.getConnection(connectURL,user,pw);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        )
        {
            while (resultSet.next())
            {
                languageData.getData().add(new XYChart.Data<>(resultSet.getString("camera"),resultSet.getInt("Units Sold")));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        return languageData;
    }

}

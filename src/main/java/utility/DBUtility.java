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
    private static String connectURL = "jdbc:mysql://ls-47a503707755f08f5347974e3b57ce24375a3ab0.clh9n1ueosen.ca-central-1.rds.amazonaws.com:3306/dbmaster?user=goisborges&password=AwsMarcos22720661";

    //Method that will retrieve and insert info on the languages chart
    public static XYChart.Series<String, Integer> getCompensation(){
        XYChart.Series<String, Integer> languageData = new XYChart.Series<>();

        String sql = "SELECT converted_yearly_compensation AS 'Yearly Compensation',  years_coding AS 'Years Coding' FROM ComputerLanguages GROUP BY years_coding ORDER BY years_coding ASC;";

        //using the try with resources block ensures that anything opened in the (...) will be closed
        try(
                Connection conn = DriverManager.getConnection(connectURL,user,pw);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        )
        {
            while (resultSet.next())
            {
                languageData.getData().add(new XYChart.Data<>(resultSet.getString("Years Coding"),resultSet.getInt("Yearly Compensation")));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        return languageData;
    }

}

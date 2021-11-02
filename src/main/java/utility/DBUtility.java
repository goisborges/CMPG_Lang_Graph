// This class will make the connection to our AWS database

package utility;

import com.example.cmpg_lang_graph.Answer;
import javafx.scene.chart.XYChart;

import java.sql.*;
import java.util.ArrayList;


public class DBUtility {

    //connection to AWS server and database
    private static String user = "goisborges";
    private static String pw = "AwsMarcos22720661";
    private static String connectURL = "jdbc:mysql://ls-47a503707755f08f5347974e3b57ce24375a3ab0.clh9n1ueosen.ca-central-1.rds.amazonaws.com:3306/dbmaster";


    //Method that will retrieve and insert info on the compensation chart
    public static XYChart.Series<String, Integer> getCompensation(){
        XYChart.Series<String, Integer> languageData = new XYChart.Series<>();

        String sql = "SELECT AVG(converted_yearly_compensation) AS 'Yearly Compensation',  years_coding AS 'Years Coding' FROM ComputerLanguages GROUP BY years_coding ORDER BY CAST(years_coding AS UNSIGNED) ASC;";


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

    public static ArrayList<Answer> getFullTable(){
        ArrayList<Answer> answers = new ArrayList<>();

        String sql = "SELECT response_id, country, age, years_coding, op_sys, converted_yearly_compensation \n" +
                "FROM ComputerLanguages" ;

        try (
                Connection conn = DriverManager.getConnection(connectURL, user, pw);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                ) {
            while (resultSet.next())
            {
                int response_id = resultSet.getInt("response_id");
                String country = resultSet.getString("country");
                String age = resultSet.getString("age");
                String years_coding = resultSet.getString("years_coding");
                String op_sys = resultSet.getString("op_sys");
                int converted_yearly_compensation = resultSet.getInt("converted_yearly_compensation");

                //Create an Answer Object with the values
                Answer newAnswer = new Answer(response_id, country, age, years_coding, op_sys, converted_yearly_compensation);
                newAnswer.setResponseId(response_id);
                newAnswer.setConverted_yearly_compensation(converted_yearly_compensation);
                newAnswer.setAge(age);
                newAnswer.setCountry(country);
                newAnswer.setOp_sys(op_sys);
                newAnswer.setYears_coding(years_coding);
                answers.add(newAnswer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answers;
    }

}

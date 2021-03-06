package gmibank.step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmibank.utilities.DatabaseUtility;
import gmibank.utilities.ReadTxt;
import gmibank.utilities.WriteToTxt;
import org.junit.Assert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseStep {

    private final static String url = "jdbc:postgresql://157.230.48.97:5432/gmibank_db";
    private final static String user = "techprodb_user";
    private final static String password = "Techpro_@126";

    List <Object> allSSNs;
    String fileName = "C:\\Users\\hiset\\IdeaProjects\\Gmibankapplication\\src\\test\\resources\\test_data\\CustomerSSNs.txt";

    @Given("user gets all data from database")
    public void user_gets_all_data_from_database() {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Java JDBC PostgreSQL Example");
            // When this class first attempts to establish a connection, it automatically
            // loads any JDBC 4.0 drivers found within
            // the class path. Note that your application must manually load any JDBC
            // drivers prior to version 4.0.
//            Class.forName("org.postgresql.Driver");
            System.out.println("Connected to PostgreSQL database!");
            Statement statement = connection.createStatement();
            System.out.println("Reading customer records...");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.tp_country");


            System.out.println("get all columns: ===> "+resultSet.getMetaData().getColumnCount());
            System.out.println(resultSet.getMetaData());

            while (resultSet.next()) {
                System.out.printf("%-30.30s  %-30.30sn", resultSet.getString("id"),
                        resultSet.getString("name"));
                System.out.println("===================");
                System.out.println(resultSet.getString(2));
            }
        } /*
         * catch (ClassNotFoundException e) {
         * System.out.println("PostgreSQL JDBC driver not found."); e.printStackTrace();
         * }
         */ catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @Given("user reads and gets all ssn {string} using db")
    public void user_reads_and_gets_all_ssn_using_db(String string) {


    }

    @Given("user reads and gets all ssn {string} and {string} using db")
    public void user_reads_and_gets_all_ssn_and_using_db(String ssn, String query) {

         allSSNs = DatabaseUtility.getColumnData(query,ssn);

    }
    @Given("user saves the ssn ids to correspondent files")
    public void user_saves_the_ssn_ids_to_correspondent_files() {

        WriteToTxt.saveAllSSNs(fileName,allSSNs);
    }

    @Then("user validates them")
    public void user_validates_them() {
        List<String> ssns = new ArrayList<>();
        ssns.add("231-89-4203");
        ssns.add("204-02-8950");

        Assert.assertTrue("The SSN ids provided from UI do nopt match!", ReadTxt.returnCustomerSNNList(fileName).containsAll(ssns));

    }


}


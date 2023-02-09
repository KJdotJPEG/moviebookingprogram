import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLSearch {

    public static String Moviesearch(String NameStr,String MovieName,String DescStr,String MovieDesc,boolean satbool,String Satisfaction,int ARInt,String AgeRating,int MRint,String MovieRuntime,String LabelText){


    }

    public static String SQLsearch(String NameStr,String MovieName,String DescStr,String MovieDesc,boolean satbool,String Satisfaction,int ARInt,String AgeRating,int MRint,String MovieRuntime,String LabelText) {

        int x = 0;

        //refers to directory to get records
        String DatabaseLocation = System.getProperty("user.dir") + "\\MovieDatabase.accdb";

        try {
            //Establishes connection to database (done by julie)
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation, "", "");

            //forms a statement which is used to format the results from your SQL
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            //selecting all records from the table "movie"
            String sql = "SELECT * FROM Movie";

            //If using an INSERT, UPDATE, DELETE use stmt.executeUpdate(query) instead
            ResultSet rs = stmt.executeQuery(sql);

            //establishing repeating loop until no more records are found



                //puts all strings into one value, returns and moves it back to Stringconcat
                LabelText = String.valueOf(((new StringBuilder()).append(MovieName).append("\n").append(MovieDesc)
                        .append("\n").append(Satisfaction).append("\n").append(AgeRating).append("\n").append(MovieRuntime)));

                System.out.println(LabelText);



            }

            //closes connections because they're no longer needed
            rs.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error in the SQL class: " + e);
        }

        return LabelText;
    }
}

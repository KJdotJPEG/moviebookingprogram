//start of sql handler class

import java.io.File;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

public class SQLHandler {

    //handles all sql methods



    public static void SQLsearcher(String NameStr, String MovieName, String DescStr, String MovieDesc, String Satisfaction,String AgeRating, String MovieRuntime) {

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
            //String temp = "SELECT * FROM Reviews";

            //If using an INSERT, UPDATE, DELETE use stmt.executeUpdate(query) instead
            ResultSet rs = stmt.executeQuery(sql);



            //establishing repeating loop until no more records are found

            while (rs.next()) {
                while (rs.next()) {

                    MovieName = rs.getString("MovieName");
                    System.out.println("Movie name : " +MovieName+ "");

                    MovieDesc = rs.getString("MovieDesc");
                    System.out.println("Movie description :" +MovieDesc+ "");

                    boolean tempbool = rs.getBoolean("UserSatisfaction");
                    Satisfaction = String.valueOf(tempbool);
                    System.out.println("Were users satisfied? : "+Satisfaction+"");

                    int tempint = rs.getInt("AgeRating");
                    AgeRating = String.valueOf(tempint);
                    System.out.println("Age rating : "+AgeRating+"");

                    tempint = rs.getInt("MovieRuntime");
                    MovieRuntime = String.valueOf(tempint);
                    System.out.println("Movie Runtime : "+MovieRuntime+"");
                    SQLconcat(NameStr,MovieName,DescStr,MovieDesc,Satisfaction,AgeRating,MovieRuntime);
                    System.out.println("\n");
                }

                //would've handled reviews if i could get it to work

                //rs = stmt.executeQuery(temp);

                //while (rs.next()) {

                //review info

                //UserStr = rs.getString("Username");
                //System.out.println("User : " + UserStr);

                //ReviewTitle = rs.getString("ReviewTitle");
                //System.out.println("Title : " + ReviewTitle);

                //ReviewDesc = rs.getString("ReviewMain");
                //System.out.println("Text : " + ReviewDesc);

                //StarRating = rs.getInt("Stars");
                //System.out.println("Rating : " + String.valueOf(StarRating));

                //System.out.println("\n");
                //}

            }

            //closes connections because they're no longer needed
            rs.close();
            con.close();

        } catch(Exception e){
            System.out.println("Error in the SQL class: " + e);
        }
    }




    //combining the results and writing them into the file.
    public static void SQLconcat(String NameStr, String MovieName, String DescStr, String MovieDesc, String Satisfaction, String AgeRating, String MovieRuntime){


        String temptext = MovieName +"|"+ MovieDesc +"|"+ Satisfaction +"|"+ AgeRating +"|"+ MovieRuntime;
        System.out.println(temptext);


        //int j = 100;
        //boolean found = false;
        //Object movielist = new Object [j];
        //for (int x = 0; x<=j;x++){
            //if (movielist[j]!=null){
                //movielist[j] = temptext;
                //found = true;
                //break;
            //}

       //}

        FileHandler.filewriter(temptext);
    }




}
//end of sqlhandler class

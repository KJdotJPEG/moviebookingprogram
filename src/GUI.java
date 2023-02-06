import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class GUI extends JFrame{

    private static ArrayList SQLRead(ArrayList GUIlist) {

        //
        return GUIlist;
    }

    private JPanel mainpanel;
    private JPanel MovieList;
    private JPanel ReviewList;
    private JPanel UserLog;
    private JTextField Username;
    private JPasswordField UserPassword;
    private JTextField UsernameInputField;
    private JButton confirm;
    private JButton skipLoginButton;
    private JPanel MainMenu;
    private JLabel MovieLabel;
    private JButton toMovieList;

    public GUI() {

        ArrayList<String> GUIlist = new ArrayList<String>();

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
            String LabelText = new String();

            while (rs.next()) {


                //individual fields printed out
                String MovieName = "MovieName : " + rs.getString("MovieName");
                //System.out.println(MovieName);

                //description in text form + printed out
                String MovieDesc = "Description :" + rs.getString("MovieDesc");
                //System.out.println(MovieDesc);

                //user satisfaction in text form + printed out
                boolean satbool = rs.getBoolean("UserSatisfaction");
                //conversion of the boolean value in the UserSatisfaction record into a String
                String Satisfaction = ("Were users satisfied with this movie? : " + String.valueOf(satbool));
                //System.out.println(Satisfaction);

                //Age rating in text form + printed out
                int ARInt = rs.getInt("AgeRating");
                String AgeRating = "Age Rating : " + String.valueOf(ARInt) + " years and over";
                //System.out.println(AgeRating);

                //Movie runtime in text form + printed out
                int MRint = rs.getInt("MovieRuntime");
                String MovieRuntime = "Movie runtime : " + String.valueOf(MRint) + " minutes";
                //System.out.println(MovieRuntime);


                x++;

                //method converting all strings into one big string, separated by \n
                //made a labeltextform beforehand so i can use it in its string form.
                //returns GUIlist back to SQLread

                //puts all strings into one value, returns and moves it back to Stringconcat
                LabelText = String.valueOf(((new StringBuilder()).append(MovieName).append("\n").append(MovieDesc)
                        .append("\n").append(Satisfaction).append("\n").append(AgeRating).append("\n").append(MovieRuntime)));

                System.out.println(LabelText);


            }

            MovieLabel.getText();

            //closes connections because they're no longer needed
            rs.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error in the SQL class: " + e);
        }


        Username.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        UserPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        skipLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Username = "Guest";
                mainpanel.removeAll();
                mainpanel.add(MainMenu);
                mainpanel.repaint();
                mainpanel.revalidate();
            }
        });
        toMovieList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainpanel.removeAll();
                mainpanel.add(MovieList);
                mainpanel.repaint();
                mainpanel.revalidate();
            }
        });
    }

    public static void main(String[] args) {

        GUI obj = new GUI();
        obj.setContentPane(obj.mainpanel);
        obj.setTitle("Movie Booking Program");
        obj.setSize(800,800);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setResizable(false);

        //moved the SQL statement here from main so they can interact w/ eachother better
        System.out.println();
    }
}

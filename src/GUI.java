import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
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

    private JLabel label;
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
        MovieLabel.addComponentListener(new ComponentAdapter() {
        });
        MovieLabel.addContainerListener(new ContainerAdapter() {
            @Override
            public void componentAdded(ContainerEvent e) {
                super.componentAdded(e);
                MovieLabel.getText();
            }
        });
    }

    public static void SQLsearcher(String NameStr, String MovieName, String DescStr, String MovieDesc, boolean satbool, String Satisfaction, int ARInt, String AgeRating, int MRint, String MovieRuntime, String LabelText, String UserStr, String ReviewTitle, String ReviewDesc,int StarRating) {

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
            String temp = "SELECT * FROM Reviews";

            //If using an INSERT, UPDATE, DELETE use stmt.executeUpdate(query) instead
            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {
                while (rs.next()) {
                    MovieName = rs.getString("MovieName");
                    System.out.println("Movie : " + String.valueOf(MovieName));

                    MovieDesc = rs.getString("MovieDesc");
                    System.out.println("Desc : " + MovieDesc);

                    satbool = rs.getBoolean("UserSatisfaction");
                    System.out.println("Users satisfied with this movie? : " + String.valueOf(satbool));

                    ARInt = rs.getInt("AgeRating");
                    System.out.println("Age Rating : " + String.valueOf(ARInt));

                    MRint = rs.getInt("MovieRuntime");
                    System.out.println("Movie Runtime : " + String.valueOf(MRint));

                    System.out.println("\n");
                }
                rs = stmt.executeQuery(temp);
                while (rs.next()) {

                    //review info

                    UserStr = rs.getString("Username");
                    System.out.println("User : " + UserStr);

                    ReviewTitle = rs.getString("ReviewTitle");
                    System.out.println("Title : " + ReviewTitle);

                    ReviewDesc = rs.getString("ReviewMain");
                    System.out.println("Text : " + ReviewDesc);

                    StarRating = rs.getInt("Stars");
                    System.out.println("Rating : " + String.valueOf(StarRating));

                    System.out.println("\n");
                }

            }


                //establishing repeating loop until no more records are found


                //concatenating all of the stuff grabbed from the SQL statement and put them into one string

                LabelText = String.valueOf(((new StringBuilder()).append(MovieName).append("\n").append(MovieDesc)
                        .append("\n").append(Satisfaction).append("\n").append(AgeRating).append("\n").append(MovieRuntime)));

                System.out.println(LabelText);

                //closes connections because they're no longer needed
                rs.close();
                con.close();

            } catch(Exception e){
                System.out.println("Error in the SQL class: " + e);
            }
        }


        //mainline code
        public static void main (String[]args){

            GUI obj = new GUI();
            obj.setContentPane(obj.mainpanel);
            obj.setTitle("Movie Booking Program");
            obj.setSize(800, 800);
            obj.setVisible(true);
            obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            obj.setResizable(false);


            //establishing variables so they can be used outside of method

            String NameStr = new String();
            String MovieName = new String();
            String DescStr = new String();
            String MovieDesc = new String();
            boolean satbool = false;
            String Satisfaction = new String();
            int ARInt = 0;
            String AgeRating = new String();
            int MRint = 0;
            String MovieRuntime = new String();
            String LabelText = new String();

            String UserStr = new String();
            String ReviewTitle = new String();
            String ReviewDesc = new String();
            int StarRating = 0;


            SQLsearcher(NameStr, MovieName, DescStr, MovieDesc, satbool, Satisfaction, ARInt, AgeRating, MRint, MovieRuntime, LabelText,UserStr,ReviewTitle,ReviewDesc,StarRating);


            System.out.println();
        }
    }

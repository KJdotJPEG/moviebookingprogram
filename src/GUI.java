//start of gui class
//concerns visual user interface

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUI extends JFrame{

    //links everything from other classes into the GUI mainframe

    //gui elements
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
    private JButton toReviewList;
    public JTextArea Reviews;
    private JButton toAccountCreation;
    private JPanel UserCreate;
    private JTextField UserAcc;
    private JPasswordField PassAcc;
    private JButton confirmButton;
    private JButton toUserLog;
    private JTextArea Movielist;


    public GUI() {
        //all action listeners are buttons that link one jpanel to another


        ArrayList<String> GUIlist = new ArrayList<>();


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
                System.out.println("successfully gone to next panel");
            }
        });
        toMovieList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainpanel.removeAll();
                mainpanel.add(MovieList);
                mainpanel.repaint();
                mainpanel.revalidate();
                System.out.println("successfully gone to next panel");
            }
        });

        toReviewList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainpanel.removeAll();
                mainpanel.add(ReviewList);
                mainpanel.repaint();
                mainpanel.revalidate();
                System.out.println("successfully gone to next panel");
            }
        });
        toAccountCreation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainpanel.removeAll();
                mainpanel.add(UserCreate);
                mainpanel.repaint();
                mainpanel.revalidate();
                System.out.println("successfully gone to next panel");
            }

        });
        toUserLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainpanel.removeAll();
                mainpanel.add(UserLog);
                mainpanel.repaint();
                mainpanel.revalidate();
                System.out.println("successfully gone to next panel");

            }
        });
    }


        //main code
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
            String UserStr = new String();
            String ReviewTitle = new String();
            String ReviewDesc = new String();
            int StarRating = 0;

            SQLHandler.SQLsearcher(NameStr, MovieName, DescStr, MovieDesc, Satisfaction, AgeRating, MovieRuntime);

            //Reviews.setText(myStringBuilder.toString());


        }


    public boolean isModified(GUI data) {
        return false;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

//end of gui class

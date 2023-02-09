import javax.swing.*;
import java.awt.event.*;
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


    //mainline code
    public static void main(String[] args) {


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


        SQLSearch.SQLsearch(NameStr,MovieName,DescStr,MovieDesc,satbool,Satisfaction,ARInt,AgeRating,MRint,MovieRuntime,LabelText);


        GUI obj = new GUI();
        obj.setContentPane(obj.mainpanel);
        obj.setTitle("Movie Booking Program");
        obj.setSize(800,800);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setResizable(false);

        System.out.println();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{
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

    public GUI() {

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
    }

    public static void main(String[] args) {
        GUI obj = new GUI();
        obj.setContentPane(obj.mainpanel);
        obj.setTitle("Movie Booking Program");
        obj.setSize(800,800);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setResizable(false);
    }
}

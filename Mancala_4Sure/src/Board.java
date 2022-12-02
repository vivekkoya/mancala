
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Board extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Board frame = new Board();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Board() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPlayerAName = new JLabel("Player A Name: ");
        lblPlayerAName.setBounds(22, 12, 111, 15);
        contentPane.add(lblPlayerAName);

        JTextField textField = new JTextField();
        textField.setBounds(165, 10, 114, 19);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblPlayerBName = new JLabel("Player B Name: ");
        lblPlayerBName.setBounds(22, 32, 111, 15);
        contentPane.add(lblPlayerBName);

        JTextField textField_1 = new JTextField();
        textField_1.setBounds(165, 30, 114, 19);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblWelcomeToMancala = new JLabel("Welcome to Mancala (in Java)!");
        lblWelcomeToMancala.setBounds(95, 144, 211, 15);
        contentPane.add(lblWelcomeToMancala);

        JLabel lblPleaseEnterPlayers = new JLabel("Please enter Player's Names to continue ...");
        lblPleaseEnterPlayers.setBounds(55, 186, 308, 15);
        contentPane.add(lblPleaseEnterPlayers);

    }
}

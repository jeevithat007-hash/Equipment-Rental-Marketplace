import javax.swing.*;
import java.awt.*;
public class RenterDashboard extends JFrame {
    JLabel title;
    JButton viewEquipmentButton;
    JButton rentEquipmentButton;
    JButton myRentalsButton;
    JButton logoutButton;
    public RenterDashboard() {
        setTitle("Renter Dashboard");
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        // Title
        title = new JLabel("WELCOME RENTER");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(130, 40, 250, 30);
        // View Equipment
        viewEquipmentButton = new JButton("View Equipment");
        viewEquipmentButton.setBounds(100, 100, 250, 45);
        viewEquipmentButton.addActionListener(e -> {
            new ViewEquipmentFrame();
            dispose();
        });

        // Rent Equipment
        rentEquipmentButton = new JButton("Rent Equipment");
        rentEquipmentButton.setBounds(100, 160, 250, 45);

        rentEquipmentButton.addActionListener(e -> {
            new RentEquipmentFrame();
            dispose();
        });

        // My Rentals
        myRentalsButton = new JButton("My Rentals");
        myRentalsButton.setBounds(100, 220, 250, 45);

        myRentalsButton.addActionListener(e -> {
            new MyRentalsFrame();
            dispose();
        });

        // Logout
        logoutButton = new JButton("Logout");
        logoutButton.setBounds(100, 290, 250, 45);

        logoutButton.addActionListener(e -> {
            new LoginFrame();
            dispose();
        });

        // Add components
        panel.add(title);
        panel.add(viewEquipmentButton);
        panel.add(rentEquipmentButton);
        panel.add(myRentalsButton);
        panel.add(logoutButton);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RenterDashboard();
    }
}
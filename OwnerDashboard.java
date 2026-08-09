import javax.swing.*;

public class OwnerDashboard extends JFrame {

    JButton addEquipmentButton;
    JButton viewEquipmentButton;
    JButton rentalHistoryButton;
    JButton logoutButton;

    public OwnerDashboard() {

        setTitle("Owner Dashboard");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel title = new JLabel("WELCOME OWNER");
        title.setBounds(120, 20, 200, 30);

        addEquipmentButton = new JButton("Add Equipment");
        addEquipmentButton.addActionListener(e -> {new AddEquipmentFrame();dispose();});
        addEquipmentButton.setBounds(100, 80, 180, 35);

        viewEquipmentButton = new JButton("View Equipment");
        viewEquipmentButton.setBounds(100, 130, 180, 35);

        rentalHistoryButton = new JButton("Rental History");
        rentalHistoryButton.setBounds(100, 180, 180, 35);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(100, 230, 180, 35);

        panel.add(title);
        panel.add(addEquipmentButton);
        panel.add(viewEquipmentButton);
        panel.add(rentalHistoryButton);
        panel.add(logoutButton);

        add(panel);
        setVisible(true);
    }
}

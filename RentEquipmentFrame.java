import javax.swing.*;
import java.awt.*;

public class RentEquipmentFrame extends JFrame {

    JLabel title, equipmentIdLabel, daysLabel;
    JTextField equipmentIdField, daysField;
    JButton rentButton, backButton;

    public RentEquipmentFrame() {

        setTitle("Rent Equipment");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        title = new JLabel("Rent Equipment");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(140, 30, 200, 30);

        equipmentIdLabel = new JLabel("Equipment ID");
        equipmentIdLabel.setBounds(50, 100, 120, 25);

        equipmentIdField = new JTextField();
        equipmentIdField.setBounds(180, 100, 180, 25);

        daysLabel = new JLabel("Rental Days");
        daysLabel.setBounds(50, 150, 120, 25);

        daysField = new JTextField();
        daysField.setBounds(180, 150, 180, 25);

        rentButton = new JButton("Rent");
        rentButton.setBounds(80, 220, 100, 35);

        backButton = new JButton("Back");
        backButton.setBounds(230, 220, 100, 35);

        backButton.addActionListener(e -> {
            new RenterDashboard();
            dispose();
        });

        panel.add(title);
        panel.add(equipmentIdLabel);
        panel.add(equipmentIdField);
        panel.add(daysLabel);
        panel.add(daysField);
        panel.add(rentButton);
        panel.add(backButton);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RentEquipmentFrame();
    }
}
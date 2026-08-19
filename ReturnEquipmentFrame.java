import javax.swing.*;
import java.awt.*;
import java.sql.*;
public class ReturnEquipmentFrame extends JFrame {
    JLabel title, rentalIdLabel;
    JTextField rentalIdField;
    JButton returnButton, backButton;
    public ReturnEquipmentFrame() {
        setTitle("Return Equipment");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        title = new JLabel("Return Equipment");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(130, 30, 220, 30);
        rentalIdLabel = new JLabel("Rental ID:");
        rentalIdLabel.setBounds(60, 100, 100, 25);
        rentalIdField = new JTextField();
        rentalIdField.setBounds(170, 100, 180, 25);
        returnButton = new JButton("Return");
        returnButton.setBounds(80, 170, 120, 35);
        backButton = new JButton("Back");
        backButton.setBounds(230, 170, 120, 35);

        returnButton.addActionListener(e -> returnEquipment());

        backButton.addActionListener(e -> {
            new RenterDashboard();
            dispose();
        });

        panel.add(title);
        panel.add(rentalIdLabel);
        panel.add(rentalIdField);
        panel.add(returnButton);
        panel.add(backButton);

        add(panel);
        setVisible(true);
    }

    private void returnEquipment() {

        String rentalText = rentalIdField.getText();

        if (rentalText.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Enter Rental ID");
            return;
        }

        try {

            int rentalId = Integer.parseInt(rentalText);

            String sql =
                    "UPDATE rentals SET return_date = CURDATE() " +
                    "WHERE rental_id = ?";

            try (Connection con = DBConnection.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setInt(1, rentalId);

                int result = ps.executeUpdate();

                if (result > 0) {

                    JOptionPane.showMessageDialog(this,
                            "Equipment Returned Successfully!");

                    rentalIdField.setText("");

                } else {

                    JOptionPane.showMessageDialog(this,
                            "Rental ID not found!");
                }
            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(this,
                    "Enter a valid Rental ID");

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this,
                    "Return Failed: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new ReturnEquipmentFrame();
    }
}

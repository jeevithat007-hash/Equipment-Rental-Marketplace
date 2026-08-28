import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class EditEquipmentFrame extends JFrame {

    JLabel title;
    JLabel equipmentIdLabel;
    JLabel nameLabel;
    JLabel rentLabel;
    JLabel availabilityLabel;

    JTextField equipmentIdField;
    JTextField nameField;
    JTextField rentField;

    JComboBox<String> availabilityBox;

    JButton updateButton;
    JButton backButton;

    public EditEquipmentFrame() {

        setTitle("Edit Equipment");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Title
        title = new JLabel("Edit Equipment");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(160, 30, 220, 35);

        // Equipment ID
        equipmentIdLabel = new JLabel("Equipment ID:");
        equipmentIdLabel.setBounds(50, 100, 130, 25);

        equipmentIdField = new JTextField();
        equipmentIdField.setBounds(190, 100, 200, 25);

        // Equipment Name
        nameLabel = new JLabel("Equipment Name:");
        nameLabel.setBounds(50, 150, 130, 25);

        nameField = new JTextField();
        nameField.setBounds(190, 150, 200, 25);

        // Rent Per Day
        rentLabel = new JLabel("Rent Per Day:");
        rentLabel.setBounds(50, 200, 130, 25);

        rentField = new JTextField();
        rentField.setBounds(190, 200, 200, 25);

        // Availability
        availabilityLabel = new JLabel("Availability:");
        availabilityLabel.setBounds(50, 250, 130, 25);

        String[] availabilityOptions = {
                "Available",
                "Unavailable"
        };

        availabilityBox = new JComboBox<>(availabilityOptions);
        availabilityBox.setBounds(190, 250, 200, 25);

        // Update Button
        updateButton = new JButton("Update");
        updateButton.setBounds(100, 330, 120, 40);

        updateButton.addActionListener(e -> updateEquipment());

        // Back Button
        backButton = new JButton("Back");
        backButton.setBounds(270, 330, 120, 40);

        backButton.addActionListener(e -> dispose());

        // Add components
        panel.add(title);

        panel.add(equipmentIdLabel);
        panel.add(equipmentIdField);

        panel.add(nameLabel);
        panel.add(nameField);

        panel.add(rentLabel);
        panel.add(rentField);

        panel.add(availabilityLabel);
        panel.add(availabilityBox);

        panel.add(updateButton);
        panel.add(backButton);

        add(panel);

        setVisible(true);
    }

    private void updateEquipment() {

        String idText = equipmentIdField.getText().trim();
        String name = nameField.getText().trim();
        String rentText = rentField.getText().trim();

        if (idText.isEmpty() ||
            name.isEmpty() ||
            rentText.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all fields!"
            );

            return;
        }

        try {

            int equipmentId = Integer.parseInt(idText);
            double rentPerDay = Double.parseDouble(rentText);

            if (rentPerDay <= 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Rent per day must be greater than 0!"
                );

                return;
            }

            // Convert availability
            int availability;

            if (availabilityBox.getSelectedItem()
                    .toString()
                    .equals("Available")) {

                availability = 1;

            } else {

                availability = 0;
            }

            Connection con = DBConnection.getConnection();

            // Check equipment exists
            String checkSQL =
                    "SELECT equipment_id " +
                    "FROM equipment " +
                    "WHERE equipment_id = ?";

            PreparedStatement checkPS =
                    con.prepareStatement(checkSQL);

            checkPS.setInt(1, equipmentId);

            ResultSet rs = checkPS.executeQuery();

            if (!rs.next()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Equipment ID not found!"
                );

                rs.close();
                checkPS.close();
                con.close();

                return;
            }

            rs.close();
            checkPS.close();

            // Update equipment
            String updateSQL =
                    "UPDATE equipment SET " +
                    "equipment_name = ?, " +
                    "rent_per_day = ?, " +
                    "availability = ? " +
                    "WHERE equipment_id = ?";

            PreparedStatement updatePS =
                    con.prepareStatement(updateSQL);

            updatePS.setString(1, name);
            updatePS.setDouble(2, rentPerDay);
            updatePS.setInt(3, availability);
            updatePS.setInt(4, equipmentId);

            int rowsUpdated =
                    updatePS.executeUpdate();

            if (rowsUpdated > 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Equipment Updated Successfully!"
                );

                equipmentIdField.setText("");
                nameField.setText("");
                rentField.setText("");
                availabilityBox.setSelectedIndex(0);

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Equipment update failed!"
                );
            }

            updatePS.close();
            con.close();

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Equipment ID and Rent must be valid numbers!"
            );

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Update Failed:\n" + ex.getMessage()
            );
        }
    }

    public static void main(String[] args) {

        new EditEquipmentFrame();
    }
}
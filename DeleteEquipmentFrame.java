import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class DeleteEquipmentFrame extends JFrame {

    JLabel title;
    JLabel equipmentIdLabel;

    JTextField equipmentIdField;

    JButton deleteButton;
    JButton backButton;

    public DeleteEquipmentFrame() {

        setTitle("Delete Equipment");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // ---------------- TITLE ----------------

        title = new JLabel("Delete Equipment");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(150, 40, 250, 35);

        // ---------------- EQUIPMENT ID ----------------

        equipmentIdLabel = new JLabel("Equipment ID:");
        equipmentIdLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        equipmentIdLabel.setBounds(60, 120, 130, 25);

        equipmentIdField = new JTextField();
        equipmentIdField.setBounds(190, 120, 200, 28);

        // ---------------- DELETE BUTTON ----------------

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(100, 190, 120, 40);

        deleteButton.addActionListener(e -> deleteEquipment());

        // ---------------- BACK BUTTON ----------------

        backButton = new JButton("Back");
        backButton.setBounds(270, 190, 120, 40);

        backButton.addActionListener(e -> dispose());

        // ---------------- ADD COMPONENTS ----------------

        panel.add(title);

        panel.add(equipmentIdLabel);
        panel.add(equipmentIdField);

        panel.add(deleteButton);
        panel.add(backButton);

        add(panel);

        setVisible(true);
    }

    // =====================================================
    // DELETE / REMOVE EQUIPMENT
    // =====================================================

    private void deleteEquipment() {

        String idText = equipmentIdField.getText().trim();

        // Check empty ID
        if (idText.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter Equipment ID!"
            );

            return;
        }

        try {

            int equipmentId = Integer.parseInt(idText);

            // Connect database
            Connection con = DBConnection.getConnection();

            // -------------------------------------------------
            // STEP 1: Check whether equipment exists
            // -------------------------------------------------

            String checkSQL =
                    "SELECT equipment_name, availability " +
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

            String equipmentName =
                    rs.getString("equipment_name");

            int currentAvailability =
                    rs.getInt("availability");

            rs.close();
            checkPS.close();

            // -------------------------------------------------
            // STEP 2: Check already unavailable
            // -------------------------------------------------

            if (currentAvailability == 0) {

                JOptionPane.showMessageDialog(
                        this,
                        equipmentName
                        + " is already unavailable."
                );

                con.close();

                return;
            }

            // -------------------------------------------------
            // STEP 3: Confirmation
            // -------------------------------------------------

            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Remove this equipment from rental?\n\n"
                    + "Equipment ID: " + equipmentId
                    + "\nEquipment Name: " + equipmentName,
                    "Confirm Remove",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            if (choice != JOptionPane.YES_OPTION) {

                con.close();

                return;
            }

            // -------------------------------------------------
            // STEP 4: Make equipment unavailable
            // -------------------------------------------------

            String updateSQL =
                    "UPDATE equipment " +
                    "SET availability = 0 " +
                    "WHERE equipment_id = ?";

            PreparedStatement updatePS =
                    con.prepareStatement(updateSQL);

            updatePS.setInt(1, equipmentId);

            int rowsUpdated =
                    updatePS.executeUpdate();

            // -------------------------------------------------
            // STEP 5: Show result
            // -------------------------------------------------

            if (rowsUpdated > 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Equipment Removed Successfully!\n\n"
                        + equipmentName
                        + " is now unavailable for rental."
                );

                equipmentIdField.setText("");

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Equipment could not be removed!"
                );
            }

            updatePS.close();
            con.close();

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid Equipment ID!"
            );

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Database Error:\n"
                    + ex.getMessage()
            );

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Operation Failed:\n"
                    + ex.getMessage()
            );
        }
    }

    // =====================================================
    // MAIN METHOD
    // =====================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new DeleteEquipmentFrame();
        });
    }
}
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class PaymentFrame extends JFrame {

    private int userId;

    JLabel title;
    JLabel rentalIdLabel;
    JLabel amountLabel;
    JLabel methodLabel;

    JTextField rentalIdField;
    JTextField amountField;

    JComboBox<String> methodBox;

    JButton getAmountButton;
    JButton payButton;
    JButton backButton;

    public PaymentFrame(int userId) {

        this.userId = userId;

        setTitle("Make Payment");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // ---------------- TITLE ----------------

        title = new JLabel("MAKE PAYMENT");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(160, 30, 220, 35);

        // ---------------- RENTAL ID ----------------

        rentalIdLabel = new JLabel("Rental ID:");
        rentalIdLabel.setBounds(70, 100, 120, 30);

        rentalIdField = new JTextField();
        rentalIdField.setBounds(200, 100, 200, 30);

        // ---------------- GET AMOUNT BUTTON ----------------

        getAmountButton = new JButton("Get Amount");
        getAmountButton.setBounds(200, 140, 200, 30);

        getAmountButton.addActionListener(e -> fetchAmount());

        // ---------------- AMOUNT ----------------

        amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(70, 185, 120, 30);

        amountField = new JTextField();
        amountField.setBounds(200, 185, 200, 30);

        amountField.setEditable(false);

        // ---------------- PAYMENT METHOD ----------------

        methodLabel = new JLabel("Payment Method:");
        methodLabel.setBounds(70, 235, 120, 30);

        methodBox = new JComboBox<>(
                new String[]{
                        "UPI",
                        "Cash",
                        "Card"
                }
        );

        methodBox.setBounds(200, 235, 200, 30);

        // ---------------- PAY BUTTON ----------------

        payButton = new JButton("Pay");
        payButton.setBounds(110, 320, 120, 40);

        payButton.addActionListener(e -> makePayment());

        // ---------------- BACK BUTTON ----------------

        backButton = new JButton("Back");
        backButton.setBounds(270, 320, 120, 40);

        backButton.addActionListener(e -> dispose());

        // ---------------- ADD COMPONENTS ----------------

        panel.add(title);

        panel.add(rentalIdLabel);
        panel.add(rentalIdField);

        panel.add(getAmountButton);

        panel.add(amountLabel);
        panel.add(amountField);

        panel.add(methodLabel);
        panel.add(methodBox);

        panel.add(payButton);
        panel.add(backButton);

        add(panel);

        setVisible(true);
    }

    // =====================================================
    // FETCH AMOUNT
    // =====================================================

    private void fetchAmount() {

        String rentalText =
                rentalIdField.getText().trim();

        if (rentalText.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter Rental ID!"
            );

            return;
        }

        try {

            int rentalId =
                    Integer.parseInt(rentalText);

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "SELECT total_amount " +
                    "FROM rentals " +
                    "WHERE rental_id = ? AND user_id = ?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, rentalId);
            ps.setInt(2, userId);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                double amount =
                        rs.getDouble("total_amount");

                amountField.setText(
                        String.valueOf(amount)
                );

            } else {

                amountField.setText("");

                JOptionPane.showMessageDialog(
                        this,
                        "Rental ID not found for this user!"
                );
            }

            rs.close();
            ps.close();
            con.close();

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid Rental ID!"
            );

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Database Error:\n"
                    + ex.getMessage()
            );
        }
    }

    // =====================================================
    // MAKE PAYMENT
    // =====================================================

    private void makePayment() {

        String rentalText =
                rentalIdField.getText().trim();

        String amountText =
                amountField.getText().trim();

        if (rentalText.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter Rental ID!"
            );

            return;
        }

        if (amountText.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please click Get Amount first!"
            );

            return;
        }

        try {

            int rentalId =
                    Integer.parseInt(rentalText);

            double amount =
                    Double.parseDouble(amountText);

            String paymentMethod =
                    methodBox.getSelectedItem().toString();

            if (amount <= 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid payment amount!"
                );

                return;
            }

            Connection con =
                    DBConnection.getConnection();

            // -------------------------------------------------
            // CHECK RENTAL BELONGS TO USER
            // -------------------------------------------------

            String checkSQL =
                    "SELECT rental_id " +
                    "FROM rentals " +
                    "WHERE rental_id = ? AND user_id = ?";

            PreparedStatement checkPS =
                    con.prepareStatement(checkSQL);

            checkPS.setInt(1, rentalId);
            checkPS.setInt(2, userId);

            ResultSet rs =
                    checkPS.executeQuery();

            if (!rs.next()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Rental ID not found for this user!"
                );

                rs.close();
                checkPS.close();
                con.close();

                return;
            }

            rs.close();
            checkPS.close();

            // -------------------------------------------------
            // INSERT PAYMENT
            // -------------------------------------------------

            String insertSQL =
                    "INSERT INTO payments " +
                    "(rental_id, amount, payment_method, payment_date) " +
                    "VALUES (?, ?, ?, CURDATE())";

            PreparedStatement ps =
                    con.prepareStatement(insertSQL);

            ps.setInt(1, rentalId);
            ps.setDouble(2, amount);
            ps.setString(3, paymentMethod);

            int result =
                    ps.executeUpdate();

            if (result > 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Payment Successful!\n\n"
                        + "Rental ID: " + rentalId
                        + "\nAmount: ₹" + amount
                        + "\nMethod: " + paymentMethod
                );

                rentalIdField.setText("");
                amountField.setText("");
                methodBox.setSelectedIndex(0);
            }

            ps.close();
            con.close();

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid Rental ID!"
            );

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Database Error:\n"
                    + ex.getMessage()
            );
        }
    }

    // =====================================================
    // MAIN
    // =====================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new PaymentFrame(1);
        });
    }
}
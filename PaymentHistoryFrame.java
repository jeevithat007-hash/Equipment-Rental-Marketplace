import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class PaymentHistoryFrame extends JFrame {

    JTable table;
    DefaultTableModel model;
    JButton closeButton;

    public PaymentHistoryFrame() {

        setTitle("Payment History");
        setSize(750, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        model = new DefaultTableModel();

        model.addColumn("Payment ID");
        model.addColumn("Rental ID");
        model.addColumn("Amount");
        model.addColumn("Payment Date");
        model.addColumn("Status");
        model.addColumn("Payment Method");

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        closeButton = new JButton("Close");

        closeButton.addActionListener(e -> dispose());

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(closeButton);

        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        loadPayments();

        setVisible(true);
    }

    private void loadPayments() {

        String sql = "SELECT payment_id, rental_id, amount, " +
                     "payment_date, payment_status, payment_method " +
                     "FROM payments ORDER BY payment_id DESC";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {

                model.addRow(new Object[]{
                    rs.getInt("payment_id"),
                    rs.getInt("rental_id"),
                    rs.getDouble("amount"),
                    rs.getDate("payment_date"),
                    rs.getString("payment_status"),
                    rs.getString("payment_method")
                });
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                this,
                "Database Error:\n" + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        new PaymentHistoryFrame();
    }
}
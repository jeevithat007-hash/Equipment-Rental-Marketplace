import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class MyRentalsFrame extends JFrame {

    JTable table;
    DefaultTableModel model;
    JButton closeButton;

    public MyRentalsFrame() {

        setTitle("My Rentals");
        setSize(750, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        model = new DefaultTableModel();

        model.addColumn("Rental ID");
        model.addColumn("Equipment ID");
        model.addColumn("Renter Email");
        model.addColumn("Rental Days");
        model.addColumn("Total Amount");
        model.addColumn("Rental Date");

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());

        add(scrollPane, BorderLayout.CENTER);
        add(closeButton, BorderLayout.SOUTH);

        loadRentals();

        setVisible(true);
    }

    private void loadRentals() {

        String sql = "SELECT id, equipment_id, renter_email, " +
                     "rental_days, total_amount, rental_date " +
                     "FROM rentals";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            model.setRowCount(0);

            while (rs.next()) {

                model.addRow(new Object[] {
                    rs.getInt("id"),
                    rs.getInt("equipment_id"),
                    rs.getString("renter_email"),
                    rs.getInt("rental_days"),
                    rs.getDouble("total_amount"),
                    rs.getTimestamp("rental_date")
                });
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this,
                    "Failed to load rentals: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new MyRentalsFrame();
    }
}
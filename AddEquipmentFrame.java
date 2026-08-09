import javax.swing.*;

public class AddEquipmentFrame extends JFrame {

    JLabel nameLabel, categoryLabel, rentLabel;
    JTextField nameField, categoryField, rentField;
    JButton addButton, backButton;

    public AddEquipmentFrame() {

        setTitle("Add Equipment");
        setSize(400,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        nameLabel = new JLabel("Equipment Name");
        nameLabel.setBounds(30,40,120,25);

        nameField = new JTextField();
        nameField.setBounds(170,40,170,25);

        categoryLabel = new JLabel("Category");
        categoryLabel.setBounds(30,90,120,25);

        categoryField = new JTextField();
        categoryField.setBounds(170,90,170,25);

        rentLabel = new JLabel("Rent Per Day");
        rentLabel.setBounds(30,140,120,25);

        rentField = new JTextField();
        rentField.setBounds(170,140,170,25);

        addButton = new JButton("Add Equipment");
        addButton.setBounds(40,220,140,35);

        backButton = new JButton("Back");
        backButton.addActionListener(e -> {new OwnerDashboard();dispose();});
        backButton.setBounds(220,220,100,35);

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(categoryLabel);
        panel.add(categoryField);
        panel.add(rentLabel);
        panel.add(rentField);
        panel.add(addButton);
        panel.add(backButton);

        add(panel);
        setVisible(true);
    }
}

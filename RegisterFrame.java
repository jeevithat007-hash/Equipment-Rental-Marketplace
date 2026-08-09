import javax.swing.*;
import java.awt.*;

public class RegisterFrame extends JFrame {

    JLabel title, nameLabel, emailLabel, passwordLabel, roleLabel;
    JTextField nameField, emailField;
    JPasswordField passwordField;
    JComboBox<String> roleBox;
    JButton registerButton, backButton;

    public RegisterFrame() {

        setTitle("User Registration");
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        title = new JLabel("User Registration");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(120, 20, 250, 30);

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(50, 80, 100, 25);

        nameField = new JTextField();
        nameField.setBounds(170, 80, 200, 25);

        emailLabel = new JLabel("Email");
        emailLabel.setBounds(50, 130, 100, 25);

        emailField = new JTextField();
        emailField.setBounds(170, 130, 200, 25);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(50, 180, 100, 25);

        passwordField = new JPasswordField();
        passwordField.setBounds(170, 180, 200, 25);

        roleLabel = new JLabel("Role");
        roleLabel.setBounds(50, 230, 100, 25);

        String roles[] = {"Owner", "Renter"};
        roleBox = new JComboBox<>(roles);
        roleBox.setBounds(170, 230, 200, 25);

        registerButton = new JButton("Register");
        registerButton.setBounds(80, 310, 120, 35);

        backButton = new JButton("Back");
        backButton.addActionListener(e -> {new LoginFrame();dispose();});
        backButton.setBounds(230, 310, 120, 35);

        panel.add(title);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(roleLabel);
        panel.add(roleBox);
        panel.add(registerButton);
        panel.add(backButton);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RegisterFrame();
    }
}

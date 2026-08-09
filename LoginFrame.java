import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    JLabel title, emailLabel, passwordLabel;
    JTextField emailField;
    JPasswordField passwordField;
    JButton loginButton, registerButton;

    public LoginFrame() {

        setTitle("Equipment Rental Marketplace");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        title = new JLabel("Equipment Rental Marketplace");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBounds(70, 20, 300, 30);

        emailLabel = new JLabel("Email");
        emailLabel.setBounds(50, 80, 100, 25);

        emailField = new JTextField();
        emailField.setBounds(150, 80, 200, 25);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(50, 130, 100, 25);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 130, 200, 25);

        loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {new OwnerDashboard();dispose();});
        loginButton.setBounds(80, 200, 100, 35);

        registerButton = new JButton("Register");
        registerButton.addActionListener(e -> {new RegisterFrame();dispose();});
        registerButton.setBounds(220, 200, 100, 35);

        panel.add(title);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(registerButton);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankBalanceApp {

    private double balance = 0.0; // Starting balance

    // Create components for the UI
    private JFrame frame;
    private JPanel panel;
    private JLabel balanceLabel;
    private JTextField amountField;
    private JButton depositButton, withdrawButton, exitButton;

    public BankBalanceApp() {
        // Set up the frame
        frame = new JFrame("Bank Balance Application");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up the panel
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        // Set up the components
        balanceLabel = new JLabel("Current Balance: $" + balance);
        amountField = new JTextField();
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        exitButton = new JButton("Exit");

        // Add components to the panel
        panel.add(new JLabel("Enter amount:"));
        panel.add(amountField);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(balanceLabel);
        panel.add(new JLabel()); // Empty cell for spacing
        panel.add(exitButton);

        // Add panel to the frame
        frame.add(panel);

        // Add action listeners for buttons
        depositButton.addActionListener(new ButtonListener());
        withdrawButton.addActionListener(new ButtonListener());
        exitButton.addActionListener(new ButtonListener());

        // Display the frame
        frame.setVisible(true);
    }

    // Event handler for button clicks
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double amount = Double.parseDouble(amountField.getText());

                if (e.getSource() == depositButton) {
                    balance += amount;
                    JOptionPane.showMessageDialog(frame, "Deposited $" + amount);
                } else if (e.getSource() == withdrawButton) {
                    if (amount <= balance) {
                        balance -= amount;
                        JOptionPane.showMessageDialog(frame, "Withdrew $" + amount);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Insufficient funds");
                    }
                }

                // Update balance label
                balanceLabel.setText("Current Balance: $" + balance);
                amountField.setText(""); // Clear input field

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid amount");
            }

            if (e.getSource() == exitButton) {
                JOptionPane.showMessageDialog(frame, "Exiting with balance: $" + balance);
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        new BankBalanceApp();
    }
}
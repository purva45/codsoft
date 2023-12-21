import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMInterface extends JFrame {
    private JTextField userInput;
    private JLabel balanceLabel;
    private double balance = 1000.0; // Initial balance

    public ATMInterface() {
        setTitle("ATM Interface");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Enter Amount:");
        userLabel.setBounds(10, 20, 120, 25);
        panel.add(userLabel);

        userInput = new JTextField(20);
        userInput.setBounds(140, 20, 120, 25);
        panel.add(userInput);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(10, 80, 120, 25);
        panel.add(withdrawButton);

        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(140, 80, 120, 25);
        panel.add(depositButton);

        balanceLabel = new JLabel("Balance: $" + balance);
        balanceLabel.setBounds(10, 120, 200, 25);
        panel.add(balanceLabel);

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(userInput.getText());
                    if (amount > 0 && amount <= balance) {
                        balance -= amount;
                        updateBalanceLabel();
                        JOptionPane.showMessageDialog(null, "Withdrawn: $" + amount);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid amount or insufficient funds.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                }
            }
        });

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(userInput.getText());
                    if (amount > 0) {
                        balance += amount;
                        updateBalanceLabel();
                        JOptionPane.showMessageDialog(null, "Deposited: $" + amount);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter a valid deposit amount.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                }
            }
        });
    }

    private void updateBalanceLabel() {
        balanceLabel.setText("Balance: $" + balance);
    }

    public static void main(String[] args) {
        new ATMInterface();
    }
}

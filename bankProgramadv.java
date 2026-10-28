import javax.swing.JOptionPane;
public class bankProgramadv {

    public static void main(String[] args) {

        double balance = 300;
        boolean isRunning = true;

        String[] options = {
            "Show Balance",
            "Deposit",
            "Withdraw",
            "Exit"
        };

        while (isRunning) {

            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Welcome To My Banking Program!",
                    "BANKING PROGRAM",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            switch (choice) {
                case 0 -> showBalance(balance);
                case 1 -> balance += deposit();
                case 2 -> balance = withdraw(balance);
                case 3, -1 -> isRunning = false;
            }
        }

        JOptionPane.showMessageDialog(null,
                "Thank you! And Welcome Again");
    }

    static void showBalance(double balance) {
        JOptionPane.showMessageDialog(null,
                String.format("Your balance is: $%.2f", balance));
    }

    static double deposit() {
        while (true) {
            String input = JOptionPane.showInputDialog(
                    "Enter amount to deposit:");

            if (input == null) return 0;

            try {
                double amount = Double.parseDouble(input.trim());

                if (!Double.isFinite(amount) || amount <= 0) {
                    JOptionPane.showMessageDialog(null,
                            "Enter a valid positive amount!");
                    continue;
                }

                return amount;

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Invalid input! Enter a number.");
            }
        }
    }

    static double withdraw(double balance) {
        while (true) {
            String input = JOptionPane.showInputDialog(
                    "Enter amount to withdraw:");

            if (input == null) return balance;

            try {
                double amount = Double.parseDouble(input.trim());

                if (!Double.isFinite(amount) || amount <= 0) {
                    JOptionPane.showMessageDialog(null,
                            "Invalid withdrawal amount!");
                } else if (amount > balance) {
                    JOptionPane.showMessageDialog(null,
                            "Insufficient funds!");
                } else {
                    return balance - amount;
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Invalid input! Enter a number.");
            }
        }
    }
}


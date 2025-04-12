import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RestaurantBilling extends JFrame {

    JTextField nameField, mobileField;
    JComboBox<String> itemMenu;
    JSpinner quantitySpinner;

    String[] items = {"Pizza", "Burger", "Pasta", "Fries"};
    int[] prices = {300, 150, 200, 100};

    public RestaurantBilling() {
        setTitle("Hotel Billing System");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10));

        add(new JLabel("Customer Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Mobile Number:"));
        mobileField = new JTextField();
        add(mobileField);

        add(new JLabel("Select Item:"));
        itemMenu = new JComboBox<>(new String[] {
                "Pizza - ₹300",
                "Burger - ₹150",
                "Pasta - ₹200",
                "Fries - ₹100"
        });
        add(itemMenu);

        add(new JLabel("Quantity:"));
        quantitySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 20, 1));
        add(quantitySpinner);

        JButton billButton = new JButton("Generate Bill Slip");
        billButton.addActionListener(e -> generateTextBill());

        add(new JLabel()); // empty cell
        add(billButton);

        setVisible(true);
    }

    public void generateTextBill() {
        String name = nameField.getText().trim();
        String mobile = mobileField.getText().trim();

        if (name.isEmpty() || mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter customer details.", "Missing Info", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int index = itemMenu.getSelectedIndex();
        String itemName = items[index];
        int price = prices[index];
        int quantity = (int) quantitySpinner.getValue();
        int total = price * quantity;

        String fileName = "BillSlip_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".txt";

        try (PrintWriter writer = new PrintWriter(fileName)) {
            writer.println("==================== HOTEL BILLING ====================");
            writer.println("Date: " + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
            writer.println("Customer Name : " + name);
            writer.println("Mobile Number : " + mobile);
            writer.println("--------------------------------------------------------");
            writer.printf("%-20s %-10s %-10s %-10s\n", "Item", "Price", "Qty", "Total");
            writer.println("--------------------------------------------------------");
            writer.printf("%-20s ₹%-9d %-10d ₹%-10d\n", itemName, price, quantity, total);
            writer.println("--------------------------------------------------------");
            writer.printf("%-20s ₹%-10d\n", "Grand Total", total);
            writer.println("========================================================");
            writer.println("Thank you for dining with us! Please visit again.");
            writer.println("========================================================");

            Desktop.getDesktop().open(new File(fileName));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error generating bill.", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RestaurantBilling::new);
    }
}

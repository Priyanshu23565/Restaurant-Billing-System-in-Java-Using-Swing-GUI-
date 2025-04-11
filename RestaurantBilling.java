import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class RestaurantBilling extends JFrame {

    JTextField nameField, mobileField;
    JComboBox<String> itemMenu;
    JSpinner quantitySpinner;

    public RestaurantBilling() {
        setTitle("Restaurant Billing System");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Mobile Number:"));
        mobileField = new JTextField();
        add(mobileField);

        add(new JLabel("Select Item:"));
        String[] items = {"Pizza - ₹300", "Burger - ₹150", "Pasta - ₹200", "Fries - ₹100"};
        itemMenu = new JComboBox<>(items);
        add(itemMenu);

        add(new JLabel("Quantity:"));
        quantitySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 20, 1));
        add(quantitySpinner);

        JButton billButton = new JButton("Generate Bill");
        billButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generateTextBill(); // Text file instead of PDF
            }
        });

        add(new JLabel()); // empty cell
        add(billButton);

        setVisible(true);
    }

    public void generateTextBill() {
        String name = nameField.getText().trim();
        String mobile = mobileField.getText().trim();
        String selectedItem = (String) itemMenu.getSelectedItem();
        int quantity = (int) quantitySpinner.getValue();

        String itemName = selectedItem.split(" - ")[0];
        int price = Integer.parseInt(selectedItem.split("₹")[1]);
        int total = price * quantity;

        try {
            String fileName = "Bill_" + System.currentTimeMillis() + ".txt";
            PrintWriter writer = new PrintWriter(fileName);

            writer.println("======== RESTAURANT BILL SLIP ========");
            writer.println("Customer Name : " + name);
            writer.println("Mobile Number : " + mobile);
            writer.println("---------------------------------------");
            writer.println("Item          : " + itemName);
            writer.println("Price/Item    : ₹" + price);
            writer.println("Quantity      : " + quantity);
            writer.println("Total Amount  : ₹" + total);
            writer.println("---------------------------------------");
            writer.println("Thank you for visiting us!");
            writer.println("=======================================");
            writer.close();

            // Open in Notepad
            Desktop.getDesktop().open(new File(fileName));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new RestaurantBilling();
    }
}

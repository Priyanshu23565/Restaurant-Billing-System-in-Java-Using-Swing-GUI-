# Restaurant-Billing-System-in-Java-Using-Swing-GUI-
his Java program is a Graphical User Interface (GUI) based Restaurant Billing System, developed using Java Swing and AWT components. It allows the user (restaurant cashier/waiter) to generate a simple bill slip for customer food orders. Instead of generating a PDF, this version generates a text file (.txt) a



🔧 Key Features:
Customer Information Input:

User can enter Customer Name and Mobile Number.

Item Selection:

A drop-down (JComboBox) is provided to select an item from:

Pizza - ₹300

Burger - ₹150

Pasta - ₹200

Fries - ₹100

Quantity Selection:

Quantity can be selected using a JSpinner (minimum 1, maximum 20).

Bill Generation:

On clicking the “Generate Bill” button:

A properly formatted text bill slip is generated and saved in the project directory.

The bill contains customer info, item name, price per item, quantity, and total amount.

The file is opened in Notepad automatically for immediate view.

🖥️ Technologies Used:
Java Swing: For creating GUI components like labels, buttons, text fields, combo box, and spinner.

Java AWT (Abstract Window Toolkit): For layout and event handling.

File I/O (java.io): To create and write the bill text file.

Desktop API (java.awt.Desktop): To open the generated bill in Notepad.




--------------------------------------------------------------------------------------------



📄 Sample Output (Text Bill):
markdown
Copy
Edit
======== RESTAURANT BILL SLIP ========
Customer Name : Rahul Sharma
Mobile Number : 9876543210
---------------------------------------
Item          : Pizza
Price/Item    : ₹300
Quantity      : 2
Total Amount  : ₹600
---------------------------------------
Thank you for visiting us!
=======================================

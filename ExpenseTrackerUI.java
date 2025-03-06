import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ExpenseTrackerUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Expense Tracker");
        frame.setSize(700, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Top Panel - Form Inputs with Padding
        JPanel inputPanel = new JPanel(new GridLayout(2, 4, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JTextField amountField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField dateField = new JTextField();
        JTextField descriptionField = new JTextField();
        JButton addButton = new JButton("Add Expense");
        
        inputPanel.add(new JLabel("Amount:"));
        inputPanel.add(amountField);
        inputPanel.add(new JLabel("Category:"));
        inputPanel.add(categoryField);
        inputPanel.add(new JLabel("Date (YYYY-MM-DD):"));
        inputPanel.add(dateField);
        inputPanel.add(new JLabel("Description:"));
        inputPanel.add(descriptionField);
        
        // Table to Display Expenses with Custom Styling
        String[] columns = {"Amount", "Category", "Date", "Description"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setBackground(Color.LIGHT_GRAY);
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Bottom Panel - Buttons with Styling
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        addButton.setFont(new Font("Arial", Font.BOLD, 14));
        addButton.setBackground(new Color(50, 150, 250));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        buttonPanel.add(addButton);

        // Add components to frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(tableScrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Action Listener for Add Button
        addButton.addActionListener(e -> {
            String amount = amountField.getText();
            String category = categoryField.getText();
            String date = dateField.getText();
            String description = descriptionField.getText();

            if (!amount.isEmpty() && !category.isEmpty() && !date.isEmpty() && !description.isEmpty()) {
                model.addRow(new Object[]{amount, category, date, description});
                amountField.setText("");
                categoryField.setText("");
                dateField.setText("");
                descriptionField.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setVisible(true);
    }
}

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;

public class LegalAssistant {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Smart Legal Assistant");
        JLabel label = new JLabel("Enter your legal query:");
        JTextField textField = new JTextField();
        JButton predictButton = new JButton("Get Legal Advice");
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);

        frame.setSize(500, 300);
        frame.setLayout(null);

        label.setBounds(20, 20, 200, 30);
        textField.setBounds(20, 50, 440, 30);
        predictButton.setBounds(20, 90, 200, 30);
        outputArea.setBounds(20, 130, 440, 100);

        frame.add(label);
        frame.add(textField);
        frame.add(predictButton);
        frame.add(outputArea);

        predictButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String query = textField.getText();
                try {
                    // Call Python script and capture result
                    ProcessBuilder pb = new ProcessBuilder("python", "C:\\Users\\DELL\\Desktop\\SmartLegalAssistant\\ai-model\\predict.py", query);
                    pb.redirectErrorStream(true);
                    Process process = pb.start();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    String category = reader.readLine();
                    String advice = reader.readLine();

                    outputArea.setText("Category: " + category + "\nAdvice: " + advice + "\n\n[Disclaimer] Educational Use Only.");

                    // Save to DB
                    DBHandler.save(query, category, advice);

                } catch (Exception ex) {
                    outputArea.setText("Error: " + ex.getMessage());
                }
            }
        });

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

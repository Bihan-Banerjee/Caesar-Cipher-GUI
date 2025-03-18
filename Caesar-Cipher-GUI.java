import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaesarCipherGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Caesar Cipher");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        JLabel inputLabel = new JLabel("Enter Text:");
        JTextField inputField = new JTextField();
        JLabel shiftLabel = new JLabel("Shift:");
        JTextField shiftField = new JTextField();
        JButton encryptButton = new JButton("Encrypt");
        JButton decryptButton = new JButton("Decrypt");
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);
        panel.add(inputLabel);
        panel.add(inputField);
        panel.add(shiftLabel);
        panel.add(shiftField);
        panel.add(encryptButton);
        panel.add(decryptButton);
        panel.add(new JLabel("Result:"));
        panel.add(resultArea);

        encryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = inputField.getText();
                int shift = Integer.parseInt(shiftField.getText());
                resultArea.setText(encrypt(text, shift));
            }
        });
        
        decryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = inputField.getText();
                int shift = Integer.parseInt(shiftField.getText());
                resultArea.setText(decrypt(text, shift));
            }
        });
        
        frame.add(panel);
        frame.setVisible(true);
    }
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                result.append((char) ((c - base + shift) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - (shift % 26));
    }
}

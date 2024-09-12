import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import javax.swing.*;

public class InteractiveMenuOrange extends JFrame {
    public InteractiveMenuOrange() {
        setTitle("Interactive Menu Orange");
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create Menu Bar and Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");

        // Create MenuItems 1 through 4
        JMenuItem printDateTimeMenuItem = new JMenuItem("Print Date and Time");
        JMenuItem saveToLogMenuItem = new JMenuItem("Save to log.txt");
        JMenuItem colorChangeMenuItem = new JMenuItem("Change Background Color. Current Hue: 0");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        // Add MenuItems to Menu
        menu.add(printDateTimeMenuItem);
        menu.add(saveToLogMenuItem);
        menu.add(colorChangeMenuItem);
        menu.add(exitMenuItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Create TextArea to display output and make it non-editable
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        // Create ScrollPane to enable scrolling within the TextArea
        JScrollPane scrollPane = new JScrollPane(textArea);
        // Add padding around the scroll pane
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(scrollPane, BorderLayout.CENTER);

        // Set actions for MenuItems

        // Action for "Print Date Time" Menu Item
        printDateTimeMenuItem.addActionListener((ActionEvent e) -> {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = now.format(formatter);
            textArea.append(formattedDateTime + "\n");
        });

        // Action for "Save to log.txt" Menu Item
        saveToLogMenuItem.addActionListener((ActionEvent e) -> {
            String textToWrite = textArea.getText(); // Get text from the text area
            try (FileWriter writer = new FileWriter("log.txt")) { // Try to write to log.txt
                writer.write(textToWrite);
                System.out.println("Text written to log.txt successfully!");
            } catch (IOException err) { // Handle potential IOException
                System.err.println("Error writing to log.txt: " + err.getMessage());
            }
        });

        // Action for "Change Color" and "Current Hue" Menu Item
        colorChangeMenuItem.addActionListener((ActionEvent e) -> {
            Random random = new Random();
            int red = 255; // Fixed red value for orange hue
            int green = random.nextInt(256); // Random green value for varying orange shades
            int blue = 0; // Fixed blue = 0 value for orange hue
            
            Color randomOrangeHue = new Color(red, green, blue);
            getContentPane().setBackground(randomOrangeHue); // Change Frame background color
            textArea.setBackground(randomOrangeHue); // Change textArea background color
            // Change scrollPane border color to match background color
            scrollPane.setBorder(BorderFactory.createLineBorder(randomOrangeHue, 10));
            
            // Convert RGB to HSB and extract hue
            float[] hsb = Color.RGBtoHSB(red, green, blue, null);
            
            int hue = (int) (hsb[0] * 360); // Convert hue to degrees (0-360)
            
            // Update "Current Hue" in the menu item
            colorChangeMenuItem.setText("Change Background Color. Current Hue: " + hue);
        });
        
        // Action for "Exit" Menu Item
        exitMenuItem.addActionListener((ActionEvent e) -> {
            dispose(); // Close the window
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new InteractiveMenuOrange().setVisible(true);
        });
    }

}
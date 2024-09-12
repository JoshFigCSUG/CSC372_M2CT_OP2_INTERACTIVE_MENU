import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        // Action for "Change Color" and "Current Hue" Menu Item
        // Action for "Exit" Menu Item

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new InteractiveMenuOrange().setVisible(true);
        });
    }

}
import javax.swing.*;

public class InteractiveMenuOrange extends JFrame {
    public InteractiveMenuOrange() {
        setTitle("Interactive Menu Orange");
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create Menu Bar and Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new InteractiveMenuOrange().setVisible(true);
        });
    }

}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class MenuDrivenInterface extends JFrame {
    private JTextArea textArea;

    public MenuDrivenInterface() {
        // Set up the JFrame
        setTitle("Menu UI");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Set up the text area
        textArea = new JTextArea(5, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Create the menu bar and menu items
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        menuBar.add(menu);
        setJMenuBar(menuBar);

        JMenuItem dateTimeItem = new JMenuItem("Print Date & Time");
        JMenuItem saveLogItem = new JMenuItem("Save to log.txt");
        JMenuItem changeColorItem = new JMenuItem("Change Background Color");
        JMenuItem exitItem = new JMenuItem("Exit");

        // Add menu items to menu
        menu.add(dateTimeItem);
        menu.add(saveLogItem);
        menu.add(changeColorItem);
        menu.add(exitItem);

        // Action listeners for each menu item
        dateTimeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printDateTime();
            }
        });

        saveLogItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToLog();
            }
        });

        changeColorItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeBackgroundColor();
            }
        });

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void printDateTime() {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        textArea.append("Date and Time: " + currentDateTime.format(formatter) + "\n");
    }

    private void saveToLog() {
        // Write the contents of the text area to a log.txt file
        try (FileWriter writer = new FileWriter("log.txt")) {
            writer.write(textArea.getText());
            textArea.append("Content saved to log.txt\n");
        } catch (IOException ex) {
            textArea.append("Error saving to log.txt\n");
        }
    }

    private void changeBackgroundColor() {
        // Generate a random shade of green
        Random random = new Random();
        int greenValue = 128 + random.nextInt(128);  // greenValue between 128 and 255
        Color randomGreenColor = new Color(50, greenValue, 50);  // Slightly offset green tone
        getContentPane().setBackground(randomGreenColor);
        textArea.append("Background color changed to " + randomGreenColor.toString() + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuDrivenInterface app = new MenuDrivenInterface();
            app.setVisible(true);
        });
    }
}
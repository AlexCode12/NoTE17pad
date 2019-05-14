import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class GUI {
    private JButton openButton;
    private JButton saveButton;
    private JButton helpButton;
    private JTextArea textArea1;
    private JPanel panelen;
    String filename;

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new GUI().panelen);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public GUI() {
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String File;
                JFileChooser fc = new JFileChooser();
                int result = fc.showOpenDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File = fc.getSelectedFile().getAbsolutePath();
                } else {
                    File = "exempel.txt";
                }


                FileReader fr = null;
                try {
                    fr = new FileReader(File);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                BufferedReader inFile = new BufferedReader(fr);

                try {
                    String line = inFile.readLine();
                    while ((line = inFile.readLine()) != null) {
                        textArea1.append(line + "\n");
                    }

                    inFile.close();


                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             JOptionPane.showMessageDialog(null, "Not finished!");
            }
        });
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Not finished!");
            }
        });
    }
}


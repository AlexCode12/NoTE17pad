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
                JFileChooser fc = new JFileChooser();
                int result = fc.showOpenDialog(null);
                String filnamn;
                if (result == JFileChooser.APPROVE_OPTION) {
                    filnamn = fc.getSelectedFile().getAbsolutePath();
                } else {
                    filnamn = "exempel.txt";
                }
                FileWriter fw = null;
                try {
                    fw = new FileWriter(filnamn);
                } catch (IOException e0) {
                    e0.printStackTrace();
                }
                FileReader fr = null;
                try {
                    fr = new FileReader(filnamn);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                BufferedReader infil = new BufferedReader(fr);
                PrintWriter outFile = new PrintWriter(fw);
                String rad;
                try {
                    while ((rad = infil.readLine() ) != null){
                        outFile.println(rad);
                    }
                    infil.close();
                    outFile.flush();
                    outFile.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
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


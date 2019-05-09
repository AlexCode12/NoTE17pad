import javax.swing.*;
import java.io.*;

public class exempel2 {
    public static void main(String[] args) {
        JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog(null);
        String filnamn;
        if (result == JFileChooser.APPROVE_OPTION) {
            filnamn = fc.getSelectedFile().getAbsolutePath();
        } else {
            filnamn = "exempel.txt";
        }

        FileReader fr = null;
        try {
            fr = new FileReader(filnamn);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader infil = new BufferedReader(fr);

        String filnamn2 = filnamn+"Copy";
        FileWriter fw = null;
        try {
            fw = new FileWriter(filnamn2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter outFile = new PrintWriter(bw);

        String rad;
        try {
            while ((rad = infil.readLine() ) != null){
                outFile.println(rad);
            }
            infil.close();
            outFile.flush();
            outFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

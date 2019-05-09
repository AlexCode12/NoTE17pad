import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class exempel {
    public static void main(String[] args) {
        String filnamn = "exempel.txt";
        FileReader fr = null;
        try {
            fr = new FileReader(filnamn);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader infil = new BufferedReader(fr);

        String rad;
        try {
            while ((rad = infil.readLine() ) != null){
            System.out.println(rad);
            }
            infil.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

package Streams.Lec;

import java.io.FileInputStream;
import java.io.IOException;

public class NOTES_Example {
    public static void main(String[] args) throws IOException {

        String path = "/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";

        FileInputStream fileIn = new FileInputStream(path);

        int oneByte = fileIn.read();

        while (oneByte >= 0) {
            System.out.print((char) oneByte);
            oneByte = fileIn.read();

        }

        fileIn.close();

//        --------------
//        втори вриант с трай-катч , без файнали - да затваря накрая ,с автоматично затваряне, за да хване ексепшън във всички случаи - при отваряне и при затваряне:
        try (FileInputStream fileInp = new FileInputStream(path)) { //опитай да създадеш и накрая автоматично затвори потока

            int onebyte = fileInp.read();

            while (onebyte >= 0) {
                System.out.print((char) onebyte);
                onebyte = fileInp.read();
            }

        } catch (IOException e) {
            System.out.println(e);
        }

//        -------------------

        //        трети вриант с трай-катч с файнали, за да затвари потока накрая
//
        FileInputStream fileInpu = null;
        try {
            fileInpu = new FileInputStream(path);
            int byte1 = fileInpu.read();

            while (byte1 >= 0) {
                System.out.print((char) byte1);
                byte1 = fileInpu.read();
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            fileInpu.close();
        }
    }
}

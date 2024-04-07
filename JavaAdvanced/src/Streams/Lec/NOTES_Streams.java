package Streams.Lec;

import java.io.*;
import java.nio.file.Files;

public class NOTES_Streams {

    public static void main(String[] args) throws IOException {


        //Стриймовете - фуния, по която се прехвърлят данните от даден файл от хард диска в оперативната памет,
//    за да могат да бъдат обработвани. Докато са на хард диска, файловете не могат да се обработват.
//    Input и Output streams - винаги са еднопосочни!
//    Зареждат ни данните от файл в приложението.
//    Могат да четат/записват от/във различни видове файлове:
//    -txt
//    -json
//    -xml
//    -property
//    -binary
//    -csv

//    !!! Сртиймовете за четене от файл са различни от стреамовете за четене от л=колекция,
//    които пускаме върху някаква колекция с различни функции: Collections.stream().map(), Collections.stream().filter(), Collections.stream().reduce()...

// fileStream.read() - чете по един байт
//    всеки знак (буква/цифра...) според аскии таблицата се записва в един байт и съдържа от 0 до 255(това са кодовете от аскии таблицата)
//        read() методът чете буква по буква (байт по байт). Ако искаме да конвертираме прочетения код в 0 и 1, ползваме Integer.toBinaryString(oneByte)
//    ако искаме byte-a да го превърнем в буква, парсваме го към char character = (char) oneByte
//    ако върне -1, значи няма повече байтове за четене

//        String path = "C://someFile.txt";
//        FileInputStream fileInput = new FileInputStream(path); // насочваме стрийма по даден път;
//        // може да даде грешка, защото никой не ни гарантира, че на диска имаме такъв файл - да се добавя грешка към мейн метода
//
//        int oneByte = fileInput.read();
//        while (oneByte >= 0) {
//            System.out.println(oneByte);
//            oneByte = fileInput.read();
//        }

        // ексепшъните имат йерархична структура и се наследяват , като се допълват.
        // Примерно IOException е парент на FileNotFoundException.
        // И можем да сложим да се хвърля парента като най-общ, ако не искаме да специфицираме вида на ексешъна.


        //FileInputStream + FileOutputStream => byte streams - read the ascii code and write the ascii code of each symbol byte per byte. If we want them in chars/in 0 and 1 , we have to convert each byte

        //FileReader + FileWriter => char streams - read char per char (one char may consists of several bytes)-
//    they read in  bulk - collect some bytes and then transfer it in bulk and write it at once
//    example of their known descendants : Scanner and PintWriter - четат и принтират по няколко символа наведнъж, което е по-бързо
//    вместо да се връщат за всеки символ напред-назад

        //BufferedReader i BufferedWriter - четат на парчета(по няколко байта наведнъж) и можем да им задаваме по колко байта наведнъж да четат

//    chatGPT:
//In Java, there are different types of streams for handling input and output operations. The main differences between byte streams, char streams, and buffered streams lie in the types of data they handle, how they handle buffering, and their intended use cases:
//
//Byte Streams:
//
//Byte streams (InputStream and OutputStream) are used for reading and writing raw binary data, such as images, audio files, or any other type of data that is not composed of characters.
//Byte streams read and write data in the form of bytes (8-bit binary values).
//They are suitable for low-level input/output operations where the data is not interpreted as characters but as raw bytes.
//Character Streams:
//
//Character streams (Reader and Writer) are used for reading and writing text-based data, where the characters are represented using a character encoding (such as ASCII, UTF-8, etc.).
//Character streams handle the conversion of characters to bytes and vice versa, using the specified character encoding, making them suitable for text processing.
//They provide higher-level abstractions compared to byte streams, as they handle characters directly rather than raw bytes.
//Buffered Streams:
//
//Buffered streams (BufferedInputStream, BufferedOutputStream, BufferedReader, BufferedWriter, etc.) add buffering functionality to byte and character streams to improve performance.
//Buffered streams read and write data in chunks, reducing the number of actual I/O operations by reading or writing larger blocks of data to and from an internal buffer.
//They provide higher performance compared to unbuffered streams, especially when dealing with disk or network I/O operations, as they reduce the overhead of frequent disk or network access.
//In summary, byte streams are used for handling raw binary data, character streams are used for handling text-based data, and buffered streams provide improved performance by adding buffering functionality to byte and character streams. The choice of stream type depends on the type of data you are working with and the performance requirements of your application.

  //FileInputStream & FileOutputStream - byte streams - read byte per byte
//        Scanner, PrintWriter - char streams. read char by char, descend from char streams FileReader & FileWriter
//        BufferedReader & BufferedWriter - to read and write data in chunks
//        Path & Paths - репресентират път на нашия компютър
//        Files - дава ни полезни методи за работа с пътища
//        File - позволява ни да работим с файлове/директории
//        ObjectInputStream & ObjectOutputSTream - за четене и писнае на цели обекти (при сериализация)


        String pathIn = "/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String pathOut = "/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/04. Java-Advanced-Files-and-Streams-Lab-Resources/02.WriteToFileOutput.txt";
        BufferedReader br = new BufferedReader(new FileReader(pathIn));
        BufferedWriter bw  = new BufferedWriter(new FileWriter(pathOut));

        String line = br.readLine();
        bw.write(line);
        bw.flush();
        bw.newLine();


        line = br.readLine();
        bw.write(line);
        bw.flush();

//------------------
//StandardOpenOption is an enumeration in the java.nio.file package that provides options for how a file should be opened or created when performing file operations using the Files.write() method.
//
//Here are the main options it offers:
//
//READ: Opens the file for reading. If the file does not exist or is inaccessible, an IOException will be thrown.
//WRITE: Opens the file for writing. If the file does not exist, it will be created. If the file exists, its contents will be overwritten.
//APPEND: Opens the file for writing, but appends data to the end of the file rather than overwriting existing content. If the file does not exist, it will be created.
//CREATE: Creates a new file if it does not already exist. If the file exists, this option has no effect. It is often used in conjunction with WRITE or APPEND.
//CREATE_NEW: Creates a new file, but if the file already exists, it will throw a FileAlreadyExistsException. This option ensures that the file is not overwritten accidentally.
//DELETE_ON_CLOSE: Deletes the file when it is closed. This option is typically used with temporary files that should be automatically cleaned up when no longer needed.
//TRUNCATE_EXISTING: Truncates the file to size 0 if it exists. This means that the file will be emptied but not deleted. It is often used in conjunction with WRITE.
//SYNC: Forces every update to the file's content to be written synchronously to the underlying storage device.
//DSYNC: Forces every update to the file's content to be written synchronously to the underlying storage device, but it does not require updating the file's metadata.
//These options provide flexibility and control over file operations in Java, allowing developers to specify precisely how they want files to be handled. Depending on the use case, you can choose the appropriate options to achieve the desired behavior when working with files.

    }
}

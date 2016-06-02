package first;

import java.io.*;

/**
 * Created by Dima on 30.05.2016.
 */
public class FileToConcoleMain {
    public static void main(String[] args) throws IOException {
        File file=new File("file.txt");
        FileToConcole tr=new FileToConcole();
        tr.showFile(file);
    }
}

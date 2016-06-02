package second;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Dima on 30.05.2016.
 */
public class RandomIntMain {
    public static void main(String[] args)  {
        File file = new File("numbers.txt");
        File file1=new File("finalnumbers.txt");
        RandomInt randomInt=new RandomInt();
        ArrayList<Integer>list =new ArrayList<Integer>();
        randomInt.randomList(list);
        randomInt.recordFile(file,list);
        list.clear();
        randomInt.print(list);
        list=randomInt.readFila(file);
        Collections.sort(list);
        randomInt.print(list);
        randomInt.recordFile(file1,list);
    }
}

package second;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Dima on 30.05.2016.
 */
public class RandomInt {
    public  ArrayList<Integer> readFila(File file){
        String number="";
        int count,countMas=0;
        ArrayList<Integer> list=new ArrayList<Integer>();
        try(FileReader reader=new FileReader(file)){
            while ((count=reader.read())!=-1){
                if((char)count>' '){
                    number=number+(char)count;
                }else if((char)count==' '){
                    if(number.length()>0){
                        list.add(Integer.parseInt(number));
                    }
                    number="";
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(number.length()>0){
            list.add(Integer.parseInt(number));
        }
        return list;
    }
    public  void recordFile(File file1, List list){

        try(FileWriter wrt=new FileWriter(file1)){
            for (int i=0;i<list.size();i++){
                wrt.write(list.get(i)+" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  void print(List<Integer>list){
        for (int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }
    public  void randomList(List<Integer> list){
        Random random=new Random();
        int sizeList=random.nextInt(15);
        for(int i=0;i<sizeList;i++){
            list.add(random.nextInt());
        }
    }
}

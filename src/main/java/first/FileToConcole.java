package first;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Dima on 30.05.2016.
 */
public class FileToConcole {
    public  void showFile(File file){
        int count=0;
        int[] mas=new int[2];
        int countMas=0;
        try(FileInputStream rd= new FileInputStream(file)) {
            while ((count=rd.read())!=-1){
                if((char)count==' '){
                    if(countMas<3) {
                        System.out.print((char) mas[0] + "" + (char) mas[1]);
                    }
                    countMas=0;
                    mas=new int[2];
                    System.out.print(" ");
                    continue;
                }else if(countMas==2){                      //123 60
                    bigSymbols(mas);
                    countMas+=1;
                    count=smallToBig(count);
                    System.out.print((char)mas[0]+""+(char) mas[1]+""+(char)count);
                    continue;
                }else if(countMas>=2){
                    count=smallToBig(count);
                    countMas+=1;
                    System.out.print((char)count);
                    continue;
                }else if(countMas<2){
                    mas[countMas++]=count;
                    continue;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(countMas<3) {
            System.out.print((char) mas[0] + "" + (char) mas[1]);
        }
    }
    public static int smallToBig(int number){
        if(number<123 && number>96){
            number-=32;
        }
        return number;
    }
    public static void bigSymbols(int[] mas){
        for(int i=0;i<mas.length;i++){
            if(mas[i]<123 && mas[i]>96){
                mas[i]-=32;
            }
        }
    }
}

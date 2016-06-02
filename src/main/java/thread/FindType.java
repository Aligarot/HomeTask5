package thread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Dima on 30.05.2016.
 */
public class FindType {
    public  void WhatAType(File file,String type){
        switch (type){
            case("int"):
                readInt(file);
                break;
            case("double"):
                readDouble(file);
                break;
            case("char"):
                readChar(file);
                break;
            case ("String"):
                readString(file);
                break;
            default:
                readString(file);
        }
    }
    public  void readInt(File file){
        try (FileReader reader = new FileReader(file)) {
            int value;
            String bigValue = "";
            while ((value = reader.read()) != -1) {
                if ((char) value == ' ') {
                    System.out.print(bigValue + " ");
                    bigValue = "";
                } else {
                    if (value > 47 && value < 58) {
                        bigValue += (char) value;
                    } else {
                        bigValue = "";
                        while (((char) reader.read()) != ' ') ;
                    }
                }
            }
            System.out.print(bigValue + " ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  void readDouble(File file){
        boolean hasDot = false;
        try (FileReader reader = new FileReader(file)) {
            int value;
            String bigValue = "";
            while ((value = reader.read()) != -1) {
                if ((char) value == ' ') {
                    if (hasDot == true) {
                        System.out.print(bigValue + " ");
                        hasDot = false;
                    }
                    bigValue = "";
                } else {
                    if ((value > 47 && value < 58) || value == 46) {
                        bigValue += (char) value;
                        if (hasDot == true && value == 46) {
                            bigValue = "";
                            hasDot = false;
                            while (((char) reader.read()) != ' ') ;
                        }
                        if (value == 46) hasDot = true;
                    } else {
                        hasDot = false;
                        bigValue = "";
                        while (((char) reader.read()) != ' ') ;
                    }
                }
            }
            if (hasDot == true) {
                System.out.print(bigValue + " ");
                hasDot = false;
            }
            bigValue = "";
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  void readChar(File file){
        try (FileReader reader = new FileReader(file)) {
            int value;
            String bigValue = "";
            while ((value = reader.read()) != -1) {
                if ((char) value == ' ') {
                    System.out.print(bigValue + " ");
                    bigValue = "";
                } else {
                    if (bigValue.length() < 1) {
                        bigValue += (char) value;
                    } else {
                        bigValue = "";
                        while (((char) reader.read()) != ' ') ;
                    }
                }
            }

            System.out.print(bigValue + " ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  void readString(File file){
        try (FileReader reader = new FileReader(file)) {
            int value;
            boolean dot=false;
            boolean line=false;
            String bigValue = "";
            while ((value = reader.read()) != -1) {
                if ((char) value == ' ') {
                    if ((line==true)&&(bigValue.length()>1)) {
                        System.out.print(bigValue +" ");

                    }
                    bigValue = "";
                    line=false;
                    dot=false;
                } else {
                    if (!(value > 47 && value < 58) & value != 46) {
                        line=true;
                    }
                    if((value == 46)&&(dot==true)){
                        line=true;
                    }
                    if (((value == 46)&&(dot==false))){
                        dot=true;
                    }
                    bigValue += (char) value;
                }
            }
            if ((line==true)&&(bigValue.length()>1)) {
                System.out.print(bigValue +" ");

            }
            bigValue = "";
            line=false;
            dot=false;

            System.out.print(bigValue + " ");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }

    }
}

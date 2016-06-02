package forth;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Dima on 30.05.2016.
 */
public class forth {
    public static void main(String[] args) throws IOException {
        File fileEmail=new File("Email.txt");
        File fileGroup=new File("Group.txt");
        File fileAll=new File("All.txt");
        Reader emails=new FileReader(fileEmail);
        Reader groups=new FileReader(fileGroup);
        processData(emails,groups);
    }
    public static void processData(Reader emails,Reader groups) throws IOException {
        ArrayList<String>emailsLIst=new ArrayList<>();
        ArrayList<String>groupsLIst=new ArrayList<>();
        ArrayList<String>userLIst=new ArrayList<>();
        int value;
        String string="";
        while ((value=emails.read())!=-1){
            if(value==117){
                string+=(char)value;
                emailsLIst.add(string);
                string="";
                continue;
            }
            string+=(char)value;
        }
        emailsLIst.add(string);
        printList(emailsLIst);
    }
    public static void printList(ArrayList list){
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
            System.out.println("+++++++++++++++++++++++++++++++++++++++_____________________________+++++++++++++++++++++++++++++++++++");
        }
    }
}

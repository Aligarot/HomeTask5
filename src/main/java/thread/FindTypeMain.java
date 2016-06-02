package thread;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Dima on 30.05.2016.
 */
public class FindTypeMain {
    public static void main(String[] args) {
        FindType findType=new FindType();
        Scanner sc = new Scanner(System.in);
        String unknownType = sc.nextLine();
        File file = new File("aLotOfType.txt");
        findType.WhatAType(file,unknownType);
    }
}

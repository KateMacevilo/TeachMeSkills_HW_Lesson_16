package com.teachMeskills.lesson_16;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Укажите путь к файлам: ");
        String pathDir = scanner.next();

        System.out.println("Укажите кол-во документов для обработки: ");
        int n = scanner.nextInt();

        Parser parser = new Parser();
        Map<String, Document> mapDoc;

        mapDoc = parser.parseDoc(pathDir, n);

        if (mapDoc != null) {
            System.out.println(mapDoc);
        }

    }

}

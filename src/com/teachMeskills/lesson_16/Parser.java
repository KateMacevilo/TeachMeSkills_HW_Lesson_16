package com.teachMeskills.lesson_16;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Parser {


    public Map<String, Document> parseDoc(String path, int countDoc) {

        File folder = new File(path);

        if (folder.isDirectory()) {

            List<File> files = Arrays.stream(folder.listFiles((dir, name) -> name.endsWith("txt")))
                    .limit(countDoc)
                    .collect(Collectors.toList());

            if (files.size() == 0) {
                System.out.println("Нет подходящих файлов формата txt");
                return null;
            }

            System.out.println(files);

            Map<String, Document> mapListDoc = new HashMap<>();
            String nameFile;
            int n = 0;

            for (File file : files) {
                n = file.getName().indexOf(".txt");
                nameFile = file.getName().substring(0, n);

                mapListDoc.put(nameFile, readFile(file));
            }

            return mapListDoc;

        } else {
            System.out.println("Неверный путь");
            return null;
        }

    }


    private Document readFile(File file) {

        Pattern docPattern = Pattern.compile("\\d{4}[-][a-zа-я]{3}[-]\\d{4}[-][a-zа-я]{3}[-]\\d[a-zа-я]\\d[a-zа-я]", Pattern.CASE_INSENSITIVE);
        Pattern phonePattern = Pattern.compile("(\\+*)[(]\\d{2}[)]\\d{7}([\\W\\n\\t]|$)");
        Pattern emailPattern = Pattern.compile("[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}", Pattern.CASE_INSENSITIVE);

        Document document = new Document();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String docOneLine;

            // читаем документ посстрочно и анализируем
            while ((docOneLine = reader.readLine()) != null) {
                Matcher docMatcher = docPattern.matcher(docOneLine);
                Matcher phoneMatcher = phonePattern.matcher(docOneLine);
                Matcher emailMatcher = emailPattern.matcher(docOneLine);

                if (docMatcher.find()) {
                    document.addNameDoc(docOneLine.substring(docMatcher.start(), docMatcher.end()));
                }

                if (phoneMatcher.find()) {
                    document.addPhoneNumb(docOneLine.substring(phoneMatcher.start(), phoneMatcher.end()));
                }

                if (emailMatcher.find()) {
                    document.addEmail(docOneLine.substring(emailMatcher.start(), emailMatcher.end()));
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return document;
    }

}

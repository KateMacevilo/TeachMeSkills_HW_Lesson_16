package com.teachMeskills.lesson_16;

import java.util.ArrayList;
import java.util.List;

public class Document {

    private List<String> nameDoc = new ArrayList<>();
    private List<String> phoneNumb = new ArrayList<>();
    private List<String> email = new ArrayList<>();

    public Document(List<String> nameDoc, List<String> phoneNumb, List<String> email) {
        this.nameDoc = nameDoc;
        this.phoneNumb = phoneNumb;
        this.email = email;
    }

    public Document() {
    }


    public void addNameDoc (String str){
        nameDoc.add(str);
    }

    public void addPhoneNumb (String str){
        phoneNumb.add(str);
    }

    public void addEmail (String str){
        email.add(str);
    }


    public List<String> getNameDoc() {
        return nameDoc;
    }

    public List<String> getPhoneNumb() {
        return phoneNumb;
    }

    public List<String> getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Document: " +
                "nameDoc= " + nameDoc +
                ", phoneNumb= " + phoneNumb +
                ", email= " + email;
    }

}

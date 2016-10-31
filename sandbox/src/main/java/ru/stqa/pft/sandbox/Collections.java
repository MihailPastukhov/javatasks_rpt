package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 31.10.2016.
 */
public class Collections {
    public static void main(String[] args){
        String[] lang = new String[4];
        lang[0]="Java";
        lang[1]="C#";
        lang[2]="Pyton";
        lang[3]="PHP";
/*
        for (int i = 0; i < lang.length; i++){
            System.out.println("Я хочу выучить " + lang[i]);
        }

        System.out.println("");

        for (String l : lang){
            System.out.println("Я хочу выучить " + l);
        }
*/
        List<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("C#");
        languages.add("Pyton");
        languages.add("PHP");

        for (String l : languages){
            System.out.println("Я хочу выучить " + l );
        }

        System.out.println("");

        for (int i = 0; i < languages.size(); i++){
            System.out.println("Я хочу выучить " + languages.get(i) );
        }


    }
}

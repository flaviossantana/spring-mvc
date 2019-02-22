package org.spring.mvc.loja;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class Normalize {

    public static void main(String[] args){

        String texto = "Flávio @ # $ %  Souça P. Santanã 666 aáeéiíoóöőuúüű AÁEÉIÍOÓÖŐUÚÜŰ";

        System.out.println(texto);
        System.out.println(unaccent(texto));

    }

    public static String unaccent (String text){
        return Normalizer
                .normalize(text, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "")
                .replaceAll("[^a-zA-Z ]", "")
                .replaceAll("\\s+", " ");
    }

    public static String unAccent(String s) {
        //
        // JDK1.5
        //   use sun.text.Normalizer.normalize(s, Normalizer.DECOMP, 0);
        //
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("");
    }

}

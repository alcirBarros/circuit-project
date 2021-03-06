package com.regex;

import java.text.Normalizer;

public class RevomeAcentuacao {
    
    public static void main(String[] args) {
        String string = removerAcentuacao("285.018.018-10");
        System.out.print(string);
    }

    public static String removerAcentuacao(String input) {
        String output = Normalizer.normalize(input, Normalizer.Form.NFD);
        output = output.replaceAll("[^\\p{ASCII}]", "");
        return output;
    }
}
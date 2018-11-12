package br.com.configuracao.util;

import java.text.Normalizer;

public class StringUtil {

    public static String removerCaracteresEspeciais(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[.-]", "").trim();
    }
}

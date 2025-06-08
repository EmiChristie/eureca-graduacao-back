package br.com.eurecagraduacao.backend.util;

public class StringUtils {
    public static String formatarNome(String texto) {
        if (texto == null || texto.isEmpty()) {
            return texto;
        }

        String[] palavras = texto.toLowerCase().split(" ");
        StringBuilder s = new StringBuilder();

        for (String palavra : palavras) {
            if (!palavra.isEmpty()) {
                s.append(Character.toUpperCase(palavra.charAt(0)))
                        .append(palavra.substring(1))
                        .append(" ");
            }
        }

        return s.toString().trim();
    }
}

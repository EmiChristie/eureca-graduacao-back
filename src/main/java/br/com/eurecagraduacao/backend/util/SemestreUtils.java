package br.com.eurecagraduacao.backend.util;

public class SemestreUtils {

    public static String proximoSemestre(String codigoSemestre) {
        if (codigoSemestre == null || !codigoSemestre.matches("\\d{4}\\.\\d")) {
            throw new IllegalArgumentException("Formato de semestre inválido. Use o formato 'YYYY.S'. Ex: '2024.1'");
        }

        String[] partes = codigoSemestre.split("\\.");
        int ano = Integer.parseInt(partes[0]);
        int semestre = Integer.parseInt(partes[1]);

        if (semestre == 1) {
            return ano + ".2";
        } else if (semestre == 2) {
            return (ano + 1) + ".1";
        } else {
            throw new IllegalArgumentException("Semestre deve ser 1 ou 2.");
        }
    }

    public static int calcularNumeroPeriodo(String p1, String p2) {
        int count = 1;
        String atual = p1;

        while (!atual.equals(p2)) {
            atual = SemestreUtils.proximoSemestre(atual);
            count++;
            if (count > 100) break;
        }

        return count;
    }

    public static int parsePeriodo(String periodo) {
        String[] partes = periodo.split("\\.");
        int ano = Integer.parseInt(partes[0]);
        int semestre = Integer.parseInt(partes[1]);
        return ano * 10 + semestre;
    }

}
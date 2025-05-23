package br.com.eurecagraduacao.backend.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class CalculoUtils {
    public static double calcularMedia(List<Double> valores) {
        if (valores.isEmpty()) return 0.0;
        double soma = 0;
        for (double v : valores) {
            soma += v;
        }
        return soma / valores.size();
    }

    public static double calcularMediaInteiros(List<Integer> valores) {
        if (valores == null || valores.isEmpty()) return 0.0;
        return valores.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public static double calcularDesvioPadrao(List<Double> valores, double media) {
        if (valores.size() <= 1) return 0.0;

        double somaDosQuadrados = 0;
        for (double v : valores) {
            somaDosQuadrados += Math.pow(v - media, 2);
        }
        return Math.sqrt(somaDosQuadrados / valores.size());
    }

    public static double calcularDesvioPadraoInteiros(List<Integer> valores, double media) {
        if (valores == null || valores.isEmpty()) return 0.0;
        double soma = 0.0;
        for (int v : valores) {
            soma += Math.pow(v - media, 2);
        }
        return Math.sqrt(soma / valores.size());
    }

    public static double round2(double valor) {
        return BigDecimal.valueOf(valor).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public static double round1(double valor) {
        return BigDecimal.valueOf(valor).setScale(1, RoundingMode.HALF_UP).doubleValue();
    }
}

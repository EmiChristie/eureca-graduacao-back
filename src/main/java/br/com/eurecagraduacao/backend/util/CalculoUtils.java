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

    public static double calcularDesvioPadrao(List<Double> valores, double media) {
        if (valores.size() <= 1) return 0.0;

        double somaDosQuadrados = 0;
        for (double v : valores) {
            somaDosQuadrados += Math.pow(v - media, 2);
        }
        return Math.sqrt(somaDosQuadrados / valores.size());
    }

    public static double round2(double valor) {
        return BigDecimal.valueOf(valor).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}

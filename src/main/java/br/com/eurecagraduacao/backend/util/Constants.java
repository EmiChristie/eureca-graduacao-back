package br.com.eurecagraduacao.backend.util;

import org.springframework.beans.factory.annotation.Value;

public class Constants {

    public static String dominio = "sti";
    public static String dasUrl = "https://eureca."+dominio+".ufcg.edu.br/das/v2/";
    public static String dasSigUrl = "https://eureca."+dominio+".ufcg.edu.br/das-sig/v1/";
    public static String periodoDe = "2014.1";
    public static String periodoDeMetricasDisciplinas = "2019.1";
    public static String periodoAte = "2024.1";
    public static String periodoAteScao = "2023.2";

    public static double limiteAtivos = 10.0; //10%

    public static int qtdPeriodosEvasao = 5; //mostrar 5 períodos com mais evasão
}

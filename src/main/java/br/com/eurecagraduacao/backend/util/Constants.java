package br.com.eurecagraduacao.backend.util;

public class Constants {

    public static String dominio = "lsd";
    public static String dasUrl = "https://eureca."+dominio+".ufcg.edu.br/das/v2/";
    public static String dasSigUrl = "https://eureca."+dominio+".ufcg.edu.br/das-sig/v1/";
    public static String periodoDe = "2015.1";
    public static String periodoAte = "2025.1";
    public static String periodoDeDisciplinasReprovacao = "2022.1";
    public static String periodoAteDisciplinasReprovacao = "2024.1";

    public static String periodoDeMetricas = "2015.1";
    public static String periodoDeMetricasDisciplinas = "2020.1";
    public static String periodoAteMetricas = "2025.1";
    public static double limiteAtivos = 10.0; //10%

    public static int qtdPeriodosEvasao = 5; //mostrar 5 períodos com mais evasão
}

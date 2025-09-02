package br.com.eurecagraduacao.backend.util;

import br.com.eurecagraduacao.backend.model.eureca.CourseModel;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static br.com.eurecagraduacao.backend.util.Constants.dasUrl;

public class MapeamentoUtils {

    private static final RestTemplate restTemplate = new RestTemplate();

    public static String mapArea(Integer area){
        if(area == null){
            return "Sem registro";
        }
        return switch (area) {
            case 1 -> "Medicina";
            case 2 -> "Veterinária, Odontologia, Zootecnia";
            case 3 -> "Ciências Exatas e da Terra";
            case 4 -> "Ciências Biológicas";
            case 5 -> "Engenharias";
            case 6 -> "Tecnólogos";
            case 7 -> "Nutrição, Farmácia";
            case 8 -> "Ciências Agrárias";
            case 9 -> "Ciências Exatas – Computação";
            case 10 -> "Ciências Exatas – Matemática e Estatística";
            case 11 -> "Arquitetura/Urbanismo";
            case 12 -> "Artes";
            case 13 -> "Música";
            case 14 -> "Enfermagem, Fisioterapia, Fonoaudiologia e Educação Física";
            case 15 -> "Ciências Sociais Aplicadas";
            case 16 -> "Direito";
            case 17 -> "Linguística e Letras";
            case 18 -> "Ciências Humanas";
            case 19 -> "Psicologia";
            case 20 -> "Formação de Professor";
            default -> "Sem registro";
        };
    }

    public static Integer buscarAreaDeRetencao(Integer codigoDoCurso) {
        String url = dasUrl +
                "/cursos" +
                "?curso=" + codigoDoCurso;

        try {
            ResponseEntity<List<CourseModel>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<CourseModel>>() {}
            );

            List<CourseModel> cursos = response.getBody();
            return (cursos != null && !cursos.isEmpty()) ? cursos.get(0).getAreaDeRetencao() : null;

        } catch (HttpClientErrorException | HttpServerErrorException ex) {
            System.err.println("Erro ao buscar curso: " + ex.getStatusCode() + " - " + ex.getMessage());
            return null;

        } catch (RestClientException ex) {
            System.err.println("Erro na comunicação com o serviço: " + ex.getMessage());
            return null;
        }
    }

}

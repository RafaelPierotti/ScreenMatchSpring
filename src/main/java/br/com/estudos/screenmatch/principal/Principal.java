package br.com.estudos.screenmatch.principal;

import br.com.estudos.screenmatch.model.DadosEpisodios;
import br.com.estudos.screenmatch.model.DadosSerie;
import br.com.estudos.screenmatch.model.DadosTemporadas;
import br.com.estudos.screenmatch.service.ConsumoApi;
import br.com.estudos.screenmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner scanner = new Scanner(System.in);

    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    private final String ENDERECO = "http://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=43a88045";

    public void exibeMenu(){
//        System.out.println("Digite o nome da seríe para buscar: ");
//        var nomeSerie = scanner.nextLine();
//        var json = consumoApi.obeterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
//        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
//        System.out.println(dados);
//
//        List<DadosTemporadas> temporadas = new ArrayList<>();
//
//        for (int i = 1; i <= dados.totalTemporadas(); i++){
//            json = consumoApi.obeterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
//            DadosTemporadas dadosTemporadas = conversor.obterDados(json, DadosTemporadas.class);
//            temporadas.add(dadosTemporadas);
//        }
//        temporadas.forEach(System.out::println);
//
//        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

        List<String> nomes = Arrays.asList("Rafael", "Andre", "Rodrigo", "Bruno", "Marcussi");

        nomes.stream()
                .sorted()
                .limit(5)
                .filter(n -> n.startsWith("R"))
                .map(n -> n.toUpperCase())
                .forEach(System.out::println);
    }
}

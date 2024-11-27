package br.com.estudos.screenmatch;

import br.com.estudos.screenmatch.model.DadosEpisodios;
import br.com.estudos.screenmatch.model.DadosSerie;
import br.com.estudos.screenmatch.model.DadosTemporadas;
import br.com.estudos.screenmatch.service.ConsumoApi;
import br.com.estudos.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obeterDados("http://www.omdbapi.com/?t=game+of+thrones&apikey=43a88045");

		System.out.println(json);

		ConverteDados conversor = new ConverteDados();

		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);

		json = consumoApi.obeterDados("http://www.omdbapi.com/?t=game+of+thrones&season=1&episode=1&apikey=43a88045");
		DadosEpisodios dadosEpisodios = conversor.obterDados(json, DadosEpisodios.class);
		System.out.println(dadosEpisodios);

		List<DadosTemporadas> temporadas = new ArrayList<>();

		for (int i = 1; i <= dados.totalTemporadas(); i++){
			json = consumoApi.obeterDados("http://www.omdbapi.com/?t=game+of+thrones&season=" + i + "&apikey=43a88045");
			DadosTemporadas dadosTemporadas = conversor.obterDados(json, DadosTemporadas.class);
			temporadas.add(dadosTemporadas);
		}
		temporadas.forEach(System.out::println);
	}
}

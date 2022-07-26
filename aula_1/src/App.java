import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App
{
	public static void main(String[] args) throws Exception
	{
		String	base = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";
		HttpClient client = HttpClient.newHttpClient();
		URI	adress = URI.create(base);
		HttpRequest request = HttpRequest.newBuilder(adress).GET().build();
		HttpResponse<String>	response = client.send(request,
										   BodyHandlers.ofString());
		String	body = response.body();
		JsonParser	parser = new JsonParser();
		List<Map<String, String>> listaDeFilmes = parser.parse(body);
		System.out.println(listaDeFilmes.size());
		for (Map<String, String> filme : listaDeFilmes)
		{
			System.out.println("Title" + filme.get("title"));
			System.out.println(filme.get("image"));
			System.out.println(filme.get("imDbRating"));
			System.out.println();
		}
	}
}

package com.example.tabbedtienda.ui.datos;

import static okhttp3.internal.Internal.instance;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.widget.TextView;

import com.example.tabbedtienda.ui.models.Plataforma;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class VolleyGET {

	private final static String urlStarter = "https://arkadio.duckdns.org/ws/";

	private static ArrayList<Plataforma> listaPlataformas = new ArrayList<Plataforma>();
	private static int color;


	/*public static void llamadaGET(String funcion, TextView tvInput, TextView tvOutput, Context context){
		VolleyGET.urlFinisher = funcion;
		ejecutarGET(tvInput, tvOutput, context);
	}*/

	//---------->> TRAMPA!! OFFLINE
	public static String devolverSinBuscar(){
		return "[{\"id\":1,\"plataforma\":\"Play Station 5\",\"juego\":[{\"id\":1,\"nombre\":\"Minute of Islands\",\"descripcion\":\"Un bonito juego con un estilo art\\u00edstico colorido, en el cual la protagonista tiene una actitud t\\u00f3xica con sigo misma y su familia alienandose de ella.\",\"pegi\":7,\"desarrolladora\":\"Mixtvision Games\",\"precioVenta\":19.99,\"precioAlquiler\":5,\"imagen\":\"https:\\/\\/almi.eus\\/wp-content\\/uploads\\/2016\\/12\\/Laguntzaile-Digitala1.png\"},{\"id\":6,\"nombre\":\"The Last of Us 2\",\"descripcion\":\"Es como el primero pero peor y mas largo\",\"pegi\":18,\"desarrolladora\":\"Naughty Dog\",\"precioVenta\":20,\"precioAlquiler\":14.55,\"imagen\":\"https:\\/\\/almi.eus\\/wp-content\\/uploads\\/2016\\/12\\/Laguntzaile-Digitala1.png\"}]},{\"id\":2,\"plataforma\":\"Play Station 4\",\"juego\":[{\"id\":2,\"nombre\":\"What Remains of Edith Finch\",\"descripcion\":\"Una historia en la que exploras la casa de una extra\\u00f1a familia y descubres los secretos de sus muertes.\",\"pegi\":16,\"desarrolladora\":\"Giant Sparrow\",\"precioVenta\":19.99,\"precioAlquiler\":5,\"imagen\":\"https:\\/\\/almi.eus\\/wp-content\\/uploads\\/2016\\/12\\/Laguntzaile-Digitala1.png\"},{\"id\":5,\"nombre\":\"Bloodborn\",\"descripcion\":\"Es como dark souls pero como sin escudos y con escopeta\",\"pegi\":18,\"desarrolladora\":\"From Software\",\"precioVenta\":20,\"precioAlquiler\":14.55,\"imagen\":\"https:\\/\\/almi.eus\\/wp-content\\/uploads\\/2016\\/12\\/Laguntzaile-Digitala1.png\"},{\"id\":6,\"nombre\":\"The Last of Us 2\",\"descripcion\":\"Es como el primero pero peor y mas largo\",\"pegi\":18,\"desarrolladora\":\"Naughty Dog\",\"precioVenta\":20,\"precioAlquiler\":14.55,\"imagen\":\"https:\\/\\/almi.eus\\/wp-content\\/uploads\\/2016\\/12\\/Laguntzaile-Digitala1.png\"},{\"id\":8,\"nombre\":\"The Last of Us\",\"descripcion\":\"Simulador de padre en el apocalipsis.\",\"pegi\":18,\"desarrolladora\":\"Naughty Dog\",\"precioVenta\":20,\"precioAlquiler\":14.55,\"imagen\":\"https:\\/\\/almi.eus\\/wp-content\\/uploads\\/2016\\/12\\/Laguntzaile-Digitala1.png\"}]},{\"id\":3,\"plataforma\":\"Play Station 3\",\"juego\":[{\"id\":8,\"nombre\":\"The Last of Us\",\"descripcion\":\"Simulador de padre en el apocalipsis.\",\"pegi\":18,\"desarrolladora\":\"Naughty Dog\",\"precioVenta\":20,\"precioAlquiler\":14.55,\"imagen\":\"https:\\/\\/almi.eus\\/wp-content\\/uploads\\/2016\\/12\\/Laguntzaile-Digitala1.png\"}]},{\"id\":5,\"plataforma\":\"Play Station 1\",\"juego\":[{\"id\":5,\"nombre\":\"Bloodborn\",\"descripcion\":\"Es como dark souls pero como sin escudos y con escopeta\",\"pegi\":18,\"desarrolladora\":\"From Software\",\"precioVenta\":20,\"precioAlquiler\":14.55,\"imagen\":\"https:\\/\\/almi.eus\\/wp-content\\/uploads\\/2016\\/12\\/Laguntzaile-Digitala1.png\"}]},{\"id\":7,\"plataforma\":\"Xbox One\",\"juego\":[{\"id\":2,\"nombre\":\"What Remains of Edith Finch\",\"descripcion\":\"Una historia en la que exploras la casa de una extra\\u00f1a familia y descubres los secretos de sus muertes.\",\"pegi\":16,\"desarrolladora\":\"Giant Sparrow\",\"precioVenta\":19.99,\"precioAlquiler\":5,\"imagen\":\"https:\\/\\/almi.eus\\/wp-content\\/uploads\\/2016\\/12\\/Laguntzaile-Digitala1.png\"}]},{\"id\":8,\"plataforma\":\"Xbox One X\",\"juego\":[{\"id\":4,\"nombre\":\"Halo: Reach\",\"descripcion\":\"Embarcate en la aventura con el mas chef y sus amigos\",\"pegi\":12,\"desarrolladora\":\"343 Industries\",\"precioVenta\":8.19,\"precioAlquiler\":1,\"imagen\":\"https:\\/\\/almi.eus\\/wp-content\\/uploads\\/2016\\/12\\/Laguntzaile-Digitala1.png\"}]},{\"id\":11,\"plataforma\":\"Switch\",\"juego\":[{\"id\":9,\"nombre\":\"Super Mario Odisey\",\"descripcion\":\"Acompa\\u00f1a a Mario en su increible aventura para adentrarse en las bragas de Peach.\",\"pegi\":3,\"desarrolladora\":\"Nintendo\",\"precioVenta\":20,\"precioAlquiler\":14.55,\"imagen\":\"https:\\/\\/almi.eus\\/wp-content\\/uploads\\/2016\\/12\\/Laguntzaile-Digitala1.png\"},{\"id\":10,\"nombre\":\"Zelda Breath of The Wild\",\"descripcion\":\"Embarcate en una aventura con Zelda trepando monta\\u00f1as.\",\"pegi\":16,\"desarrolladora\":\"Nintendo\",\"precioVenta\":20,\"precioAlquiler\":14.55,\"imagen\":\"https:\\/\\/almi.eus\\/wp-content\\/uploads\\/2016\\/12\\/Laguntzaile-Digitala1.png\"},{\"id\":11,\"nombre\":\"Pokemon Espada\",\"descripcion\":\"Otro Pokemon hecho sin ganas y con la misma formula de hace a\\u00f1os.\",\"pegi\":3,\"desarrolladora\":\"Gamefreak\",\"precioVenta\":20,\"precioAlquiler\":14.55,\"imagen\":\"https:\\/\\/almi.eus\\/wp-content\\/uploads\\/2016\\/12\\/Laguntzaile-Digitala1.png\"}]},{\"id\":18,\"plataforma\":\"PC\",\"juego\":[{\"id\":1,\"nombre\":\"Minute of Islands\",\"descripcion\":\"Un bonito juego con un estilo art\\u00edstico colorido, en el cual la protagonista tiene una actitud t\\u00f3xica con sigo misma y su familia alienandose de ella.\",\"pegi\":7,\"desarrolladora\":\"Mixtvision Games\",\"precioVenta\":19.99,\"precioAlquiler\":5,\"imagen\":\"https:\\/\\/almi.eus\\/wp-content\\/uploads\\/2016\\/12\\/Laguntzaile-Digitala1.png\"},{\"id\":2,\"nombre\":\"What Remains of Edith Finch\",\"descripcion\":\"Una historia en la que exploras la casa de una extra\\u00f1a familia y descubres los secretos de sus muertes.\",\"pegi\":16,\"desarrolladora\":\"Giant Sparrow\",\"precioVenta\":19.99,\"precioAlquiler\":5,\"imagen\":\"https:\\/\\/almi.eus\\/wp-content\\/uploads\\/2016\\/12\\/Laguntzaile-Digitala1.png\"},{\"id\":3,\"nombre\":\"Oxenfree\",\"descripcion\":\"Un grupo de adolescentes se pierde en una isla encantada y tienen que afrontar su pasado para poder salir con vida.\",\"pegi\":12,\"desarrolladora\":\"Night School Studio\",\"precioVenta\":8.19,\"precioAlquiler\":1,\"imagen\":\"https:\\/\\/almi.eus\\/wp-content\\/uploads\\/2016\\/12\\/Laguntzaile-Digitala1.png\"},{\"id\":4,\"nombre\":\"Halo: Reach\",\"descripcion\":\"Embarcate en la aventura con el mas chef y sus amigos\",\"pegi\":12,\"desarrolladora\":\"343 Industries\",\"precioVenta\":8.19,\"precioAlquiler\":1,\"imagen\":\"https:\\/\\/almi.eus\\/wp-content\\/uploads\\/2016\\/12\\/Laguntzaile-Digitala1.png\"}]}]";
	}

	/*private static void ejecutarGET(TextView tvInput, TextView tvOutput, Context context){

		// Instantiate the RequestQueue.
		RequestQueue queue = Volley.newRequestQueue(context);

		// Request a string response from the provided URL.
		StringRequest stringRequest = crearRequest(urlFinisher);
		// Add the request to the RequestQueue.
		queue.add(stringRequest);
	}*/

	public static ArrayList<Plataforma> crearRequest(String llamada){

		return listaPlataformas;
	}

}

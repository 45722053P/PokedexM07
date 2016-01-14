package sample;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by 45722053p on 18/12/15.
 */
public class Llamadas {

    private static String BASE_URL = "http://pokeapi.co/";
    private static String POKEDEX_URL = BASE_URL + "api/v1/pokedex/1/";
    private static String URL_REFERNCIA = "api/v1/pokemon/1/";
    private static String URL_POKEMON = BASE_URL + URL_REFERNCIA;

    public static String getJSON(String URLtoRead) {

        try {
            StringBuilder stringJSON = new StringBuilder();
            URL url = new URL(URLtoRead);
            HttpURLConnection c = (HttpURLConnection) url.openConnection();
            c.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(c.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                stringJSON.append(line);
            }

            reader.close();
            return stringJSON.toString();
        } catch (Exception one) {
            return "Error al intentar acceder a la API";
        }
    }

    public static Pokemon inforPokemon (int poke){
        Pokemon pokemon = null;
        //Pasamos a String la id del pokemon para anadirla a la peticion
        String pokeID = String.valueOf(poke);

        //Generamos la peticion con la id del pokemon
        String peticioPoke = "http://pokeapi.co/api/v1/pokemon/" + pokeID;

        try {
            //Creamos un objeto generico que es lo que devuelve el JSON
            Object obj = JSONValue.parse(getJSON(peticioPoke));

            //Lo pasamos a un objeto simple con la libreria JSONSimple
            JSONObject objJSimple = (JSONObject) obj;

            String nombre = (String) objJSimple.get("name");
            long hp =  (Long)objJSimple.get("hp");
            String peso = (String) objJSimple.get("weight");


            pokemon = new Pokemon(nombre,(int)hp,peso);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return pokemon;
    }

    public static void listaView() {

        int id;
        String nombre;

        for (int iterador = 1; iterador < 15; iterador++) {


            String ID = String.valueOf(iterador);
            String peticionPokemon = "http://pokeapi.co/api/v1/pokemon/" + ID;

            try{
                String Jpoke= getJSON(peticionPokemon);
                Object object = JSONValue.parse(Jpoke);
                JSONObject object1 = (JSONObject)object;

                nombre = new String(String.valueOf(object1.get("name")));
                id = Integer.parseInt((object1.get("pkdx_id").toString()));
                Controller.items.add(new Pokemon(id,nombre));
            }catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}

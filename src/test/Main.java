package test;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.*;
import com.fasterxml.jackson.*;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void ejemplo1JSON() throws JSONException{
        ArrayList<String> cursos = new ArrayList<>();
        cursos.add("andorid");
        cursos.add("machinelearning");
        cursos.add("desarrolloweb");

        var user = new JSONObject();

        user.put("name", "Pol");
        user.put("apellido", "Surriel");
        user.put("edad", Integer.valueOf(24));
        user.put("isMail", Boolean.TRUE);
        user.put("cursos", new JSONArray(cursos));

        var userJson = user.toString();
        System.out.println(userJson);
    }

    public static void ejemplo2JSON() throws JSONException{
        String data = """
                {"name": "John Doe",
                "occupation": "gardener",
                "siblings": "2",
                "height": "172.35",
                "married": "true"}""";

        var user = new JSONObject(data);

        System.out.println(user.get("name"));
        System.out.println(user.get("occupation"));
        System.out.println(user.get("siblings"));
    }

    public void ejemplo3JSON() throws JSONException, IOException {

        String data = Files.readString(Paths.get("src/test/pelis.json"),
                StandardCharsets.UTF_8);

        JSONObject readed = new JSONObject(data);

        JSONArray pelisArray = readed.getJSONArray("peliculas");

        for (int i = 0; i < pelisArray.length(); i++) {
            var peli = pelisArray.getJSONObject(i);
            var name = peli.getString("name");
            var duration = peli.getInt("duracion");

            String description = "sin descripcion";

            try {
                description = peli.getString("descripcion");
            }catch (JSONException e){}

            var rating = peli.getDouble("valoracion");

            System.out.println(name);
            System.out.println(duration);
            System.out.println(description);
            System.out.println(rating);
        }


    }

    public static void main(String [] args) throws JSONException, IOException {

//        XmlMapper  mapper = new XmlMapper();
//
//        ArrayList<Peli> pelis = new ArrayList<>();
//        pelis.add(new Peli("toy story",200, "dsdsdd", 5.0));
//        pelis.add(new Peli("el pieanista",50, "dsdsdd", 5.6));
//        pelis.add(new Peli("aventuras en el espacio",10, "dsdsdd", 5.0));
//        pelis.add(new Peli("espacio en las aventuras",200, "dsdsdd", 5.0));
//
//
//        mapper.writeValue(new File("pelis2.xml"), pelis);

    }




}
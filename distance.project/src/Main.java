import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.*;
import com.google.common.collect.Multiset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;


/**
 * Created by tvv89 on 08.02.2017 for JavaLabs.
 */
public class Main {
    public static void main(final String[] args) throws IOException, JSONException {

        final String baseUrl = "http://maps.googleapis.com/maps/api/distancematrix/json";// путь к Geocoding API по HTTP
        final Map<String, String> params = Maps.newHashMap();
        params.put("sensor", "false");// указывает, исходит ли запрос на геокодирование от устройства с датчиком
        params.put("language", "ru");// язык данных
        params.put("mode", "driving");// идем пешком, может быть driving, walking, bicycling
        // адрес или координаты отправных пунктов
        final String[] origins = { "50.453204,30.501077",
                "50.445344,30.506468",
                "50.446324,30.513731",
                "50.461141,30.521590",
                "50.409671,30.634816"
        };
        params.put("origins", Joiner.on('|').join(origins));
        // адрес или координаты пунктов назначения
        final String[] destionations = { //
                "50.453204,30.501077",
                "50.445344,30.506468",
                "50.446324,30.513731",
                "50.461141,30.521590",
                "50.409671,30.634816"

        };
        TrackParameters[][] tracks = new TrackParameters[origins.length][origins.length];
                // в запросе адреса должны разделяться символом '|'
        params.put("destinations", Joiner.on('|').join(destionations));
        final String url = baseUrl + '?' + encodeParams(params);// генерируем путь с параметрами
        //System.out.println(url); // Можем проверить что вернет этот путь в браузере
        JSONObject response = JsonReader.read(url);// делаем запрос к вебсервису и получаем от него ответ
        Date start = new Date();
        JSONArray destin = response.getJSONArray("origin_addresses");
        //destin.forEach(System.out::println);
        System.out.println((String)(destin.get(0)));
        for (int i=0; i<(response.getJSONArray("rows")).length();i++) {
           // System.out.println("el"+i+": "+response.getJSONArray("rows").getJSONObject(i));
            JSONObject location = response.getJSONArray("rows").getJSONObject(i);
            JSONArray array = location.getJSONArray("elements");
            for (int j=0; j<array.length();j++) {
                JSONObject element = array.getJSONObject(j);

                Integer dist_el = (Integer) ((JSONObject)element.get("distance")).get("value");
                Integer time_el = (Integer) ((JSONObject)element.get("duration")).get("value");
                if (i==j)
                {dist_el = 10000000;
                time_el = 10000000;}
                    tracks[i][j] = new TrackParameters(dist_el,time_el,destin.getString(i).toString(),destin.get(j).toString());
                //System.out.print("el["+i+", "+j+"]:"+dist_el+"m   "+time_el+"sec        ");

            }
            //System.out.println();
        }
        /*System.out.println(tracks.length);
        System.out.println();
        Date stop = new Date();
        System.out.println(stop.getTime()-start.getTime());*/
        PostmanTrack tmp = new PostmanTrack(tracks);
        tmp.Tracks();
        System.out.println();
       // System.out.println(tmp.grate_for_zero());
       // System.out.println(tmp.max_of_grade(tmp.grate_for_zero()));
      //  tmp.printMass();
        //JSONObject location = response.getJSONArray("rows").getJSONObject(0);
        //JSONArray arrays = location.getJSONArray("elements");// Здесь лежат все рассчитанные значения
        // Ищем путь на который мы потратим минимум времени

        //System.out.println(((JSONObject)location.get("elements")).
    }
    private static String encodeParams(final Map<String, String> params) {
        final String paramsUrl = Joiner.on('&').join(// получаем значение вида key1=value1&key2=value2...
                Iterables.transform(params.entrySet(), new Function<Map.Entry<String, String>, String>() {

                    @Override
                    public String apply(final Map.Entry<String, String> input) {
                        try {
                            final StringBuffer buffer = new StringBuffer();
                            buffer.append(input.getKey());// получаем значение вида key=value
                            buffer.append('=');
                            buffer.append(URLEncoder.encode(input.getValue(), "utf-8"));// кодируем строку в соответствии со стандартом HTML 4.01
                            return buffer.toString();
                        } catch (final UnsupportedEncodingException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }));
        return paramsUrl;
    }
}

package google.service;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import google.service.entity.TrackParameters;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 13.02.2017.
 */
public class JSONrequest{
    public List<String> Origin_addr = new ArrayList<>();
    public List<String> Destination_addr = new ArrayList<>();
    public String URL_api(String[] origins, String[] destionations)
    {
        final String baseUrl = "http://maps.googleapis.com/maps/api/distancematrix/json";// путь к Geocoding API по HTTP
        final Map<String, String> params = Maps.newHashMap();
        params.put("sensor", "false");// указывает, исходит ли запрос на геокодирование от устройства с датчиком
        params.put("language", "ru");// язык данных
        params.put("mode", "driving");// идем пешком, может быть driving, walking, bicycling
        // адрес или координаты отправных пунктов
        params.put("origins", Joiner.on('|').join(origins));
        // в запросе адреса должны разделяться символом '|'
        params.put("destinations", Joiner.on('|').join(destionations));
        final String url = baseUrl + '?' + encodeParams(params);// генерируем путь с параметрами
        return url;
    }

    public TrackParameters[][]  readMatrix(String inURL)  throws IOException, JSONException
    {
        JSONObject response = JsonReader.read(inURL);// делаем запрос к вебсервису и получаем от него ответ
        JSONArray origin = response.getJSONArray("origin_addresses");
        JSONArray destin = response.getJSONArray("destination_addresses");
        for (int i = 0; i <origin.length() ; i++) {
            Origin_addr.add(origin.get(i).toString());
        }
        for (int i = 0; i <destin.length() ; i++) {
            Destination_addr.add(destin.get(i).toString());
        }
        TrackParameters[][] tracks = new TrackParameters[origin.length()][destin.length()];
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
                 tracks[i][j] = new google.service.entity.TrackParameters(dist_el,time_el,
                        origin.getString(i).toString(),destin.get(j).toString());
            }
        }
        return tracks;
    }

    private String encodeParams(final Map<String, String> params) {
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

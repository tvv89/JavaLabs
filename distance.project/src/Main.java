import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.*;

import google.service.JSONrequest;
import google.service.JsonReader;
import google.service.controller.Controller;
import google.service.controller.ControllerCollections;
import google.service.entity.TrackParameters;
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
        final String[] origins = {
                "50.453204,30.501077",
                "50.445344,30.506468",
                "50.446324,30.513731",
                "50.461141,30.521590",
                "50.409671,30.634816",
                "50.437116,30.436232",
                "50.430429,30.516551",
                "50.510761,30.420233"
        };
        // адрес или координаты пунктов назначения
        final String[] destionations = { //
                "50.453204,30.501077",
                "50.445344,30.506468",
                "50.446324,30.513731",
                "50.461141,30.521590",
                "50.409671,30.634816",
                "50.437116,30.436232",
                "50.430429,30.516551",
                "50.510761,30.420233"
        };
        List<List<TrackParameters>> tracks = new ArrayList<>();
        JSONrequest request = new JSONrequest();
        tracks = request.readMatrixToList(request.URL_api(origins,destionations));
        ControllerCollections tmp = new ControllerCollections();
        List<TrackParameters> res = new ArrayList<>();
        res = tmp.Matrix_reduct(tracks);
        res.forEach(System.out::println);
        System.out.println();
        /*for (TrackParameters i:tmp.result_track) {
            System.out.println(i.toString());
        }*/

    }

}

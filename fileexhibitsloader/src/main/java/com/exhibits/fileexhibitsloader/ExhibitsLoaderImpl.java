package com.exhibits.fileexhibitsloader;

import com.exhibits.model.Exhibit;
import com.exhibits.model.ExhibitsLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tourdyiev Roman on 4/21/19.
 */
public class ExhibitsLoaderImpl implements ExhibitsLoader {

    private List<Exhibit> exhibits = new ArrayList<>();
    private String title = "";
    private String[] images;

    @Override
    public List<Exhibit> getExhibitList(String json) throws JSONException {
        exhibits.clear();
        JSONArray jsonArray = new JSONArray(json);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject exhibitObj = jsonArray.getJSONObject(i);
            title = exhibitObj.has("title") ? exhibitObj.getString("title") : "";
            if (exhibitObj.has("images")) {
                JSONArray imagesJsonArray = exhibitObj.getJSONArray("images");
                images = new String[imagesJsonArray.length()];
                for (int j = 0; j < imagesJsonArray.length(); j++) {
                    images[j] = imagesJsonArray.getString(j);
                }
            } else {
                images = new String[]{};
            }
            exhibits.add(new Exhibit(title, images));
        }
        return exhibits;
    }
}

package com.exhibits.model;

import org.json.JSONException;

import java.util.List;

/**
 * Created by Tourdyiev Roman on 4/21/19.
 */
public interface ExhibitsLoader{
    List<Exhibit> getExhibitList(String json) throws JSONException;
}

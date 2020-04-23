package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject sandwichJson = new JSONObject(json);
            JSONObject sandwichName = sandwichJson.getJSONObject("name");

            return new Sandwich(
                sandwichName.getString("mainName"),
                getStringsFrom(sandwichName.getJSONArray("alsoKnownAs")),
                sandwichJson.getString("placeOfOrigin"),
                sandwichJson.getString("description"),
                sandwichJson.getString("image"),
                getStringsFrom(sandwichJson.getJSONArray("ingredients"))
            );
        } catch (JSONException jse) {
            return null;
        }
    }

    private static List<String> getStringsFrom(JSONArray jsonArray) throws JSONException {
        List<String> strings = new ArrayList<>(jsonArray.length());
        for (int i = 0; i < jsonArray.length(); i++) {
            strings.add(i, jsonArray.getString(i));
        }
        return strings;
    }
}

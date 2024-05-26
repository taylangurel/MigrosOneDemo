package com.migrosone.MigrosOneDemo.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.migrosone.MigrosOneDemo.model.StoreInfoModel;

import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonReader {

    public static List<StoreInfoModel> readJsonFile() {
        Gson gson = new Gson();
        List<StoreInfoModel> stores = new ArrayList<>();

        try (Reader reader = new InputStreamReader(JsonReader.class.getResourceAsStream("/stores.json"))) {
            Type storeListType = new TypeToken<List<StoreInfoModel>>() {
            }.getType();
            stores = gson.fromJson(reader, storeListType);
        } catch (Exception e) {
            System.err.println("Error reading the file: " + e.getMessage());
            e.printStackTrace();
        }

        if (stores.isEmpty()) {
            System.err.println("No stores found or failed to parse the JSON.");
        } else {
            System.out.println("Successfully parsed stores.");
        }

        return stores;
    }
}
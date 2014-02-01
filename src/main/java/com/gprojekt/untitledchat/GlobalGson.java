package com.gprojekt.untitledchat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Jochen on 01.02.14.
 */
public class GlobalGson {
    private Gson gson;

    private GlobalGson() {
        GsonBuilder builder = new GsonBuilder();
        this.gson = builder.create();
    }

    private static class LazyHolder {
        private static final GlobalGson INSTANCE = new GlobalGson();
    }

    public static Gson get() {
        return LazyHolder.INSTANCE.gson;
    }
}

package com.library.config;

public class ConfigurationManager {
    private static ConfigurationManager instance;

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public String getLibraryName() { return "Biblioteca Unifesp"; }

    public int getLoanLimit() { return 3; }
}

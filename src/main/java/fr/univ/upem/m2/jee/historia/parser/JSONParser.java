/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ.upem.m2.jee.historia.parser;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.stream.JsonReader;
import fr.univ.upem.m2.jee.historia.entity.Monument;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Lamine
 */
public class JSONParser {
    public static <T> T parse(String path,Class<T> T) {             
        try {
            // Get Gson object
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            // read JSON file data as String
            String fileData = new String(Files.readAllBytes(Paths.get(path)));

            // parse json string to object
            return  gson.fromJson(fileData, T);
        } catch (IOException ex) {
            return null;
        }

        }
		
	
}

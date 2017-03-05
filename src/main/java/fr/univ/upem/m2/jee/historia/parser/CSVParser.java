/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ.upem.m2.jee.historia.parser;

import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashSet;

/**
 *
 * @author Lamine
 */
public class CSVParser {
    public static <T> HashSet<T> parse(String path,Class<T> T){
		BeanListProcessor<T> rowProcessor = new BeanListProcessor<>(T);
		CsvParserSettings settings = new CsvParserSettings();
                settings.getFormat().setDelimiter(';');
		settings.setProcessor(rowProcessor);
		settings.setHeaderExtractionEnabled(true);
		settings.setSkipEmptyLines(true);
		settings.setReadInputOnSeparateThread(true);
		CsvParser parser = new CsvParser(settings);
		

		try (InputStreamReader file = new InputStreamReader(new FileInputStream(path), Charset.forName("windows-1252"))){
			parser.parse(file);


		} catch (FileNotFoundException e ) {
                    e.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

         
		return new HashSet<>(rowProcessor.getBeans());
	}
}

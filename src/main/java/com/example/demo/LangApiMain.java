package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LangApiMain {

	public static void appendPropertiesEng(String key, String data) {
		FileOutputStream fileOut = null;
        FileInputStream fileIn = null;
        try {
            Properties configProperty = new Properties();
            //Properties pathing
            File file = new File("C:\\Users\\Avaca\\OneDrive\\Documents\\LangApp\\src\\main\\resources\\messages.properties");
            fileIn = new FileInputStream(file);
            configProperty.load(fileIn);
            //Adding properties
            configProperty.setProperty(key+".message", data);
            fileOut = new FileOutputStream(file);
            configProperty.store(fileOut, "sample properties");

        } catch (Exception ex) {
            Logger.getLogger(LangApiMain.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                fileOut.close();
            } catch (IOException ex) {
                Logger.getLogger(LangApiMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
	}
	
	public static void appendPropertiesSwe(String key, String data) {
		FileOutputStream fileOut = null;
        FileInputStream fileIn = null;
        try {
            Properties configProperty = new Properties();

            File file = new File("C:\\Users\\Avaca\\OneDrive\\Documents\\LangApp\\src\\main\\resources\\messages_se.properties");
            fileIn = new FileInputStream(file);
            configProperty.load(fileIn);
            configProperty.setProperty(key+".message", data);
            fileOut = new FileOutputStream(file);
            configProperty.store(fileOut, "sample properties");

        } catch (Exception ex) {
            Logger.getLogger(LangApiMain.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                fileOut.close();
            } catch (IOException ex) {
                Logger.getLogger(LangApiMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
	}
}
	

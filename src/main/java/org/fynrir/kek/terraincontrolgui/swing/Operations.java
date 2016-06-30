/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fynrir.kek.terraincontrolgui.swing;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author cbg-fynrir
 */
public class Operations {
    
    private String[][] FromImageBiomeColors; //Index 1: Name of biome, Index 2: The hex color of the biome as written in the Biome .ini file.
    private String[][][][] BO3ObjectsWorld; //Index 1: World name, Index 2: Category (folder), 0 is 'Undefined'. Index 3: Name of object, Index 4: Contents of bo3 file.
    private String[][][] BO3ObjectsGlobal; //Index 1: Category (folder), 0 is 'undefined'. Index 2: Name of object, Index 3: Contents of .bo3 file.
    private String[][][] BiomesWorld; //Index 1: World name, Index 2: Biome name, Index 3: Contents of the Biome .ini .
    private String[][] BiomesGlobal; //Index 1: Biome name, Index 2: Contents of the biome .ini file.
    private String TerrainControlINI = ""; //The contents of the TerrainControl.ini
    private String[][] WorldConfigINI; //First index is the name of the world. And the second index is the contents of it's WorldConfig.ini file.
    private String[][] BiomeConfigsINI; 
    private String TerrainControlFolderPath;
    
    
    
    public String[] LoadFromDirectory(File[] Paths, String FolderPath) {
    
    String LoadFailed = "false";
    String Message;
    String[] Error = new String[2];
    ArrayList filenames = new ArrayList();
    ArrayList filepaths = new ArrayList();
    
    for (int i = 0; i < Paths.length; i++) {
    
    filenames.add(i, Paths[i].getName());
    filepaths.add(i, Paths[i].getAbsolutePath());
    }
    
    if (!filenames.contains("GlobalBiomes")) {
        LoadFailed = "true";
        Message = "The folder 'GlobalBiomes' is missing or incorrectly named, it is required that it exists in your TerrainControl folder in order to load the project.";
        Error[0] = LoadFailed;
        Error[1] = Message;
    }
    if (!filenames.contains("GlobalObjects")) {
        LoadFailed = "true";
        Message = "The folder 'GlobalObjects' is missing or incorrectly named, it is required that it exists in your TerrainControl folder in order to load the project.";
        Error[0] = LoadFailed;
        Error[1] = Message;
    }
    if (!filenames.contains("TerrainControl.ini")) {
        LoadFailed = "true";
        Message = "The config file 'TerrainControl.ini' is missing or incorrectly named, it is required that it exists in your TerrainControl folder in order to load the project.";
        Error[0] = LoadFailed;
        Error[1] = Message;
    }
        if ("false".equals(LoadFailed)) {
            setTerrainControlFolderPath(FolderPath);
            ArrayList CopyOfArrayList = new ArrayList();
            
            for (int i = 0; i < filepaths.size(); i++) {
                String text = (String) filepaths.get(i);
                CopyOfArrayList.add(text);
            }
            
            for (int i = 0; i < CopyOfArrayList.size(); i++) {
                String pathtobetrimmed = CopyOfArrayList.get(i).toString();
                String trimmedpath = pathtobetrimmed.substring(pathtobetrimmed.lastIndexOf('/')+1);
                CopyOfArrayList.set(i, trimmedpath);
            }
            
            int index = CopyOfArrayList.indexOf("TerrainControl.ini");
            String path = filepaths.get(index).toString();
            
        try {
            setTerrainControlINI(readFile(path));
            System.out.println(getTerrainControlINI());
        } catch (IOException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
        } else {
            //Do nothing.
        }
    
        return Error;
    }
    //This method when called will remove all data from the operations object. Do not run
    //this carelessly!
    public void ResetMemory() {
        //Assigning 'null' to all String arrays, effectively resetting the operations object.
        setFromImageBiomeColors(null);
        setBO3ObjectsWorld(null);
        setBO3ObjectsGlobal(null);
        setBiomesWorld(null);
        setBiomesGlobal(null);
        setTerrainControlINI("");
        setWorldConfigINI(null);
        setBiomeConfigsINI(null);
        setTerrainControlFolderPath(null);
        
    }
    
    public void AutoBackupp() {
        
        Runnable backuppRunnable = new Runnable() {
    public void run() {
        
        }
    };

    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    executor.scheduleAtFixedRate(backuppRunnable, 0, 5, TimeUnit.MINUTES);
        
        
    }

    /**
     * @return the FromImageBiomeColors
     */
    public String[][] getFromImageBiomeColors() {
        return FromImageBiomeColors;
    }

    /**
     * @param FromImageBiomeColors the FromImageBiomeColors to set
     */
    public void setFromImageBiomeColors(String[][] FromImageBiomeColors) {
        this.FromImageBiomeColors = FromImageBiomeColors;
    }

    /**
     * @return the BO3ObjectsWorld
     */
    public String[][][][] getBO3ObjectsWorld() {
        return BO3ObjectsWorld;
    }

    /**
     * @param BO3ObjectsWorld the BO3ObjectsWorld to set
     */
    public void setBO3ObjectsWorld(String[][][][] BO3ObjectsWorld) {
        this.BO3ObjectsWorld = BO3ObjectsWorld;
    }

    /**
     * @return the BO3ObjectsGlobal
     */
    public String[][][] getBO3ObjectsGlobal() {
        return BO3ObjectsGlobal;
    }

    /**
     * @param BO3ObjectsGlobal the BO3ObjectsGlobal to set
     */
    public void setBO3ObjectsGlobal(String[][][] BO3ObjectsGlobal) {
        this.BO3ObjectsGlobal = BO3ObjectsGlobal;
    }

    /**
     * @return the BiomesWorld
     */
    public String[][][] getBiomesWorld() {
        return BiomesWorld;
    }

    /**
     * @param BiomesWorld the BiomesWorld to set
     */
    public void setBiomesWorld(String[][][] BiomesWorld) {
        this.BiomesWorld = BiomesWorld;
    }

    /**
     * @return the BiomesGlobal
     */
    public String[][] getBiomesGlobal() {
        return BiomesGlobal;
    }

    /**
     * @param BiomesGlobal the BiomesGlobal to set
     */
    public void setBiomesGlobal(String[][] BiomesGlobal) {
        this.BiomesGlobal = BiomesGlobal;
    }

    /**
     * @return the TerrainControlINI
     */
    public String getTerrainControlINI() {
        return TerrainControlINI;
    }

    /**
     * @param TerrainControlINI the TerrainControlINI to set
     */
    public void setTerrainControlINI(String TerrainControlINI) {
        this.TerrainControlINI = TerrainControlINI;
    }

    /**
     * @return the WorldConfigINI
     */
    public String[][] getWorldConfigINI() {
        return WorldConfigINI;
    }

    /**
     * @param WorldConfigINI the WorldConfigINI to set
     */
    public void setWorldConfigINI(String[][] WorldConfigINI) {
        this.WorldConfigINI = WorldConfigINI;
    }

    /**
     * @return the BiomeConfigsINI
     */
    public String[][] getBiomeConfigsINI() {
        return BiomeConfigsINI;
    }

    /**
     * @param BiomeConfigsINI the BiomeConfigsINI to set
     */
    public void setBiomeConfigsINI(String[][] BiomeConfigsINI) {
        this.BiomeConfigsINI = BiomeConfigsINI;
    }

    /**
     * @return the TerrainControlFolderPath
     */
    public String getTerrainControlFolderPath() {
        return TerrainControlFolderPath;
    }

    /**
     * @param TerrainControlFolderPath the TerrainControlFolderPath to set
     */
    public void setTerrainControlFolderPath(String TerrainControlFolderPath) {
        this.TerrainControlFolderPath = TerrainControlFolderPath;
    }
    
    
    public String readFile(String path) throws FileNotFoundException, IOException {
        // The name of the file to open.
        String filePath = path;
        String text = null;
        
         // Open the file that is the first 
  // command line parameter
  FileInputStream fstream = new FileInputStream(filePath);
  // Get the object of DataInputStream
  DataInputStream in = new DataInputStream(fstream);
  BufferedReader br = new BufferedReader(new InputStreamReader(in));
  String strLine;
  //Read File Line By Line
  while ((strLine = br.readLine()) != null)   {
  // Print the content on the console
  //System.out.println (strLine);
  text += strLine + "\n";
  }
  //Close the input stream
  in.close();
        
        return text;
    }
    
    public String removeComments(String text) {
        String lines = text;
        
                lines = lines.replaceAll("(.*#.*\r?\n)", "");
                
          
        
        
        
        System.out.println("-------------------------------------");
        System.out.println(lines);
        System.out.println("-------------------------------------");
        return lines;
    }
    
    public static int countLines(String str) {
    if(str == null || str.isEmpty())
    {
        return 0;
    }
    int lines = 1;
    int pos = 0;
    while ((pos = str.indexOf("\n", pos) + 1) != 0) {
        lines++;
    }
    return lines;
    }
    
    public String getTerrainControlINISettings () {
        String string = getTerrainControlINI();
        System.out.println(string);
        string = removeComments(string);
        
        return string;
    }
    
    
    
}

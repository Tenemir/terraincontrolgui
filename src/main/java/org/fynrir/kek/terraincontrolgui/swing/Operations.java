/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fynrir.kek.terraincontrolgui.swing;

import java.awt.Component;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
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
    
    private HashMap[][] FromImageBiomeColors; //Index 1: Name of biome, Index 2: The hex color of the biome as written in the Biome .ini file.
    private HashMap[][][][] BO3ObjectsWorld; //Index 1: World name, Index 2: Category (folder), 0 is 'Undefined'. Index 3: Name of object, Index 4: Contents of bo3 file.
    private HashMap[][][] BO3ObjectsGlobal; //Index 1: Category (folder), 0 is 'undefined'. Index 2: Name of object, Index 3: Contents of .bo3 file.
    private HashMap[][][] BiomesWorld; //Index 1: World name, Index 2: Biome name, Index 3: Contents of the Biome .ini .
    private HashMap[][] BiomesGlobal; //Index 1: Biome name, Index 2: Contents of the biome .ini file.
    private String TerrainControlINI; //The contents of the TerrainControl.ini
    private HashMap[][] WorldConfigINI; //First index is the name of the world. And the second index is the contents of it's WorldConfig.ini file.
    private HashMap[][] BiomeConfigsINI; 
    private String TerrainControlFolderPath;
    private ArrayList TerrainControlFilePaths;
    private ArrayList TerrainControlFilePathsIndexes;
    
    
    
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
        this.TerrainControlFilePathsIndexes = CopyOfArrayList;
        this.TerrainControlFilePaths = filepaths;
        String path = filepaths.get(index).toString();
            
        try {
            String text = readFile(path);
            setTerrainControlINI(text);
            
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
//        System.out.println("-------------------------------------");
//        System.out.println("variable lines in removecomments contains:");
//        System.out.println("-------------------------------------");
//        System.out.println(lines);
//        System.out.println("-------------------------------------");
//        System.out.println("Attempting to replaceall lines containing # with nothing");
//        System.out.println("-------------------------------------");
                lines = lines.replaceAll("(.*#.*\r?\n)", "");
        //System.out.println("-------------------------------------");
                lines = lines.replaceAll("((?m)^\\s+)", "");
          
        
        
        
//        System.out.println("-------------------------------------");
//        System.out.println("variable lines should now contain only the lines with no comments.");
//        System.out.println("-------------------------------------");
//        System.out.println(lines);
//        System.out.println("-------------------------------------");
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
        string = removeComments(string);
        
        return string;
    }
    
    public HashMap LoadTerrainControlInitoTCINIEditor () {
        String settings = getTerrainControlINISettings();
        String lines[] = settings.split("\r?\n");
        String linesArrayFixed[] = new String[3];
        for (int i = 1; i < lines.length; i++) {
            linesArrayFixed[i-1] = lines[i];
        }
        
        String SettingLineToBeSplitted;
        String[] DivideSettingNameAndValue;
        String[] SettingLineSplittedValue = new String[3];
        String[] SettingLineSplittedKey = new String[3];
        String Key;
        String Value;
        HashMap hm = new HashMap();
        int NumberOfLines = countLines(settings);
        for (int i = 0; i < linesArrayFixed.length; i++) {
            
            SettingLineToBeSplitted = linesArrayFixed[i];
            
            
            //System.out.println(SettingLineToBeSplitted);
            DivideSettingNameAndValue = SettingLineToBeSplitted.split(":");
            //System.out.println(DivideSettingNameAndValue[0]);
            //System.out.println(DivideSettingNameAndValue[1]);
            
            Key = DivideSettingNameAndValue[0];
            Value = DivideSettingNameAndValue[1];
            
            
                SettingLineSplittedValue[i] = Value.trim();
            SettingLineSplittedKey[i] = Key.trim(); 
            
                
        }
        
        JOptionPane.showConfirmDialog(null, "Lol not even triggering my jimmes.");
        //System.out.println(Arrays.toString(SettingLineSplittedKey));
        //System.out.println(Arrays.toString(SettingLineSplittedValue));
        
        for (int i = 0; i < SettingLineSplittedKey.length; i++) {
                
            hm.put(SettingLineSplittedKey[i], SettingLineSplittedValue[i]);
            
            }
        
//        System.out.println("---------------------------------");
//        System.out.println("Trying to print the hashmap that results from the method LoadTerrainControlInitoTCINIEditor");
//        System.out.println("---------------------------------");
//        System.out.println(hm);
//        System.out.println("---------------------------------");
//        System.out.println(hm.get("SettingsMode"));
//        System.out.println("---------------------------------");
//        System.out.println(hm.get("BiomeConfigExtension"));
//        System.out.println("---------------------------------");
//        System.out.println(hm.get("LogLevel"));
//        System.out.println("---------------------------------");
        return hm;
    }
    
    public String SaveTerrainControlIniToClassObject(String SettingsMode, String LogLevel, String BiomeConfigExtension) {
        String ini = getTerrainControlINI();
        System.out.println("--------------------------------------");
        System.out.println(SettingsMode);
        System.out.println(LogLevel);
        System.out.println(BiomeConfigExtension);
        System.out.println("--------------------------------------");
        ini = ini.replaceAll("(?m-i)^.*?SettingsMode.*$", SettingsMode);
        ini = ini.replaceAll("(?m-i)^.*?LogLevel.*$", LogLevel);
        ini = ini.replaceAll("(?m-i)^.*?BiomeConfigExtension.*$", BiomeConfigExtension);
        System.out.println(ini);
        setTerrainControlINI(ini);
        
        
        //regular expression: ^.*SettingsMode.*$
        //regular expression: ^.*LogLevel.*$
        //regular expression: ^.*BiomeConfigExtension.*$
        String Success = "Success";
        return Success;
    }
    
    

    /**
     * @return the FromImageBiomeColors
     */
    public HashMap[][] getFromImageBiomeColors() {
        return FromImageBiomeColors;
    }

    /**
     * @param FromImageBiomeColors the FromImageBiomeColors to set
     */
    public void setFromImageBiomeColors(HashMap[][] FromImageBiomeColors) {
        this.FromImageBiomeColors = FromImageBiomeColors;
    }

    /**
     * @return the BO3ObjectsWorld
     */
    public HashMap[][][][] getBO3ObjectsWorld() {
        return BO3ObjectsWorld;
    }

    /**
     * @param BO3ObjectsWorld the BO3ObjectsWorld to set
     */
    public void setBO3ObjectsWorld(HashMap[][][][] BO3ObjectsWorld) {
        this.BO3ObjectsWorld = BO3ObjectsWorld;
    }

    /**
     * @return the BO3ObjectsGlobal
     */
    public HashMap[][][] getBO3ObjectsGlobal() {
        return BO3ObjectsGlobal;
    }

    /**
     * @param BO3ObjectsGlobal the BO3ObjectsGlobal to set
     */
    public void setBO3ObjectsGlobal(HashMap[][][] BO3ObjectsGlobal) {
        this.BO3ObjectsGlobal = BO3ObjectsGlobal;
    }

    /**
     * @return the BiomesWorld
     */
    public HashMap[][][] getBiomesWorld() {
        return BiomesWorld;
    }

    /**
     * @param BiomesWorld the BiomesWorld to set
     */
    public void setBiomesWorld(HashMap[][][] BiomesWorld) {
        this.BiomesWorld = BiomesWorld;
    }

    /**
     * @return the BiomesGlobal
     */
    public HashMap[][] getBiomesGlobal() {
        return BiomesGlobal;
    }

    /**
     * @param BiomesGlobal the BiomesGlobal to set
     */
    public void setBiomesGlobal(HashMap[][] BiomesGlobal) {
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
    public HashMap[][] getWorldConfigINI() {
        return WorldConfigINI;
    }

    /**
     * @param WorldConfigINI the WorldConfigINI to set
     */
    public void setWorldConfigINI(HashMap[][] WorldConfigINI) {
        this.WorldConfigINI = WorldConfigINI;
    }

    /**
     * @return the BiomeConfigsINI
     */
    public HashMap[][] getBiomeConfigsINI() {
        return BiomeConfigsINI;
    }

    /**
     * @param BiomeConfigsINI the BiomeConfigsINI to set
     */
    public void setBiomeConfigsINI(HashMap[][] BiomeConfigsINI) {
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
    
    public void SaveAll() throws FileNotFoundException, IOException {
        //Saving the TerrainControl.ini settings to it's file.
        int index = this.TerrainControlFilePathsIndexes.indexOf("TerrainControl.ini");
        String filepath = this.TerrainControlFilePaths.get(index).toString();
        System.out.println(filepath);
        File myFoo = new File(filepath);
        FileOutputStream fooStream = new FileOutputStream(myFoo, false); // true to append
                                                                 // false to overwrite.
        byte[] myBytes = getTerrainControlINI().getBytes();
        fooStream.write(myBytes);
        fooStream.close();
        //Done saving.


    }
    
}

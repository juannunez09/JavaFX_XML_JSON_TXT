package com.campusfp.lectura;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.campusfp.lectura.Item;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

public class PruebaLeer extends Thread {
	static ArrayList<Item> ListaJSON = new ArrayList<Item>();
	static ArrayList<String> ListaTXT = new ArrayList<String>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StaXParser parseLectura = new StaXParser();
		List<Item> solucion = parseLectura.leer("config.xml");
		//List<Item> solucion2 = parseLectura.leer("config2.xml");
		
		
		for (Item item : solucion ) {
            System.out.println(item);
            ListaJSON.add(item);
        }
		LectorJSON();
		System.out.println(ListaJSON);
		
		
		/*for (Item item : solucion2 ) {
            System.out.println(item);
        }	*/
		
		 JsonParser parser = new JsonParser();
	        FileReader fr = new FileReader("prueba.json");
	        JsonElement datos = parser.parse(fr);
	        dumpJSONElement(datos);
		
	        
	        System.out.println(ListaTXT);
	        LectorTXT();
	}

		// TODO Auto-generated method stub
		 public static void dumpJSONElement(JsonElement elemento) {
			    if (elemento.isJsonObject()) {
			     
			        JsonObject obj = elemento.getAsJsonObject();
			        java.util.Set<java.util.Map.Entry<String,JsonElement>> entradas = obj.entrySet();
			        java.util.Iterator<java.util.Map.Entry<String,JsonElement>> iter = entradas.iterator();
			        while (iter.hasNext()) {
			            java.util.Map.Entry<String,JsonElement> entrada = iter.next();
			            
			            dumpJSONElement(entrada.getValue());
			        }
			 
			    } else if (elemento.isJsonArray()) {
			        JsonArray array = elemento.getAsJsonArray();
			        
			        java.util.Iterator<JsonElement> iter = array.iterator();
			        while (iter.hasNext()) {
			            JsonElement entrada = iter.next();
			            dumpJSONElement(entrada);
			        }
			    } else if (elemento.isJsonPrimitive()) {
			        
			        JsonPrimitive valor = elemento.getAsJsonPrimitive();
			        if (valor.isNumber()) {
			            System.out.println( valor.getAsNumber()+" ");
			            ListaTXT.add(valor.getAsNumber().toString());
			        } else if (valor.isString()) {
			            System.out.print( " "+valor.getAsString()+" ");
			            ListaTXT.add(valor.getAsString().toString());
			        }
			    }
			
	}
		 public static void LectorTXT() throws IOException {
		        String ruta = "prueba.txt";
		        File archivo = new File(ruta);
		        BufferedWriter bw;
		        if(archivo.exists()) {
		            bw = new BufferedWriter(new FileWriter(archivo));
		            bw.write(ListaTXT.toString());
		        } else {
		            bw = new BufferedWriter(new FileWriter(archivo));
		            bw.write("Acabo de crear el fichero de texto.");
		        }
		        bw.close();
		    }
		 
		 
	public static void main() throws java.io.IOException {
	        JsonParser parser = new JsonParser();
	        FileReader fr = new FileReader("datos.json");
	        JsonElement datos = parser.parse(fr);
	        dumpJSONElement(datos);
	    }
	public static void LectorJSON() throws IOException {

	    
	        String ruta = "prueba.json";
	        File archivo = new File(ruta);
	        BufferedWriter bw;
	            bw = new BufferedWriter(new FileWriter(archivo));
	            bw.write(ListaJSON.toString());     
	        bw.close();
	}
}

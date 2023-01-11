package org.kalbinvv.purgomalumspigot.requests;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.kalbinvv.purgomalumspigot.utils.StringUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class PurgoMalumRequest {

	
	public static String filterStringFromSwearWords(String unfilteredString) {
		try {
			URL url = new URL(String.format(
					"https://www.purgomalum.com/service/json?text=%s",
					StringUtils.filterSpecialSymbolsInString(unfilteredString)));
			
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);

			BufferedReader inputReader = new BufferedReader(
	                new InputStreamReader(connection.getInputStream()));
	        StringBuffer response = new StringBuffer();

	        String inputLine;
	        while ((inputLine = inputReader.readLine()) != null) {
	            response.append(inputLine);
	        }
	        inputReader.close();

	        JsonObject jsonObject = new Gson().fromJson(
	        		response.toString(),
	        		JsonObject.class);
	        
	        return jsonObject.get("result").getAsString();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return unfilteredString;
	}
	
}

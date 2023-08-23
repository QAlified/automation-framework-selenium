package util;

import java.io.File;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONHandler {
	public static String getJSONContent(String filename, String endpoint){
		String JSONParam = new String();
		String[] endpointArray = endpoint.split("\\.");
		try {
			String path = new File("files/"+filename).getAbsolutePath();
			Object o = new JSONParser().parse(new FileReader(path));
			JSONObject j = (JSONObject) o;
			if(endpointArray.length >= 2) {
				
				JSONObject tempNest = new JSONObject();
				JSONObject tempFullNest = new JSONObject();
					for(int i = 0; i < (endpointArray.length - 1); i++) {
						if(endpointArray[i] == null) {
							break;
						}
						
						if(i == 0) {
							tempFullNest = (JSONObject) j.get(endpointArray[i]);
							tempNest = (JSONObject) tempFullNest;

						}else if(i > 0 && i < (endpointArray.length - 1)){
							tempFullNest = (JSONObject) tempNest.get(endpointArray[i]);
							tempNest = (JSONObject) tempFullNest;

						}
						else if(i >= (endpointArray.length - 1)){
							tempNest = (JSONObject) tempFullNest;

						}

					}
					JSONParam = (String) tempNest.get(endpointArray[endpointArray.length - 1]);
			}else {
				JSONParam = j.get(endpoint).toString();
			}
			
		}catch(Exception e) {
			e.printStackTrace(System.out);
		    e.printStackTrace(System.err);
		}
		
		return JSONParam;
	}	

}

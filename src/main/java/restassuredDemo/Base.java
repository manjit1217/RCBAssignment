package restassuredDemo;
 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
public class Base 
{
	JSONArray jsonread() throws FileNotFoundException, IOException, ParseException {
		JSONParser jsonParser= new JSONParser();
		JSONObject jsonObject= (JSONObject) jsonParser.parse(new FileReader("src\\main\\resources\\RCB.json"));
		JSONArray jsonArray = (JSONArray) jsonObject.get("player");	
		return jsonArray;
	
	}
	ArrayList<Object> getAllCountryName() throws FileNotFoundException, IOException, ParseException {
		Base base= new Base();
		JSONArray jsonArray=base.jsonread();
		ArrayList<Object> playersCountry = new ArrayList<Object>();  
		for(int i=0;i<jsonArray.size();i++) {
			JSONObject jsonCountry=(JSONObject)jsonArray.get(i);
			String country= (String) jsonCountry.get("country");
			playersCountry.add(country);
			
		}
		System.out.println(playersCountry);
		return playersCountry;
	}
	
	ArrayList<Object> getRoleName() throws FileNotFoundException, IOException, ParseException {
		Base base= new Base();
		JSONArray jsonArray=base.jsonread();
		ArrayList<Object> roleName = new ArrayList<Object>();  
		for(int i=0;i<jsonArray.size();i++) {
			JSONObject jsonCountry=(JSONObject)jsonArray.get(i);
			String role= (String) jsonCountry.get("role");
			roleName.add(role);
			
		}
		System.out.println(roleName);
		return roleName;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		Base base= new Base();
		//base.jsonread();
		base.getAllCountryName();
	}
	
 
}
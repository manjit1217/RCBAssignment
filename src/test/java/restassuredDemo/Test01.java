package restassuredDemo;

import org.testng.Assert;
import restassuredDemo.Base;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.codehaus.groovy.transform.sc.StaticCompilationMetadataKeys;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import static io.restassured.matcher.ResponseAwareMatcher.*;
import static org.hamcrest.Matchers.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
public class Test01 extends Base {

	//Test that has only 4 foreign players without India
	@Test
	void test_01() throws FileNotFoundException, IOException, ParseException {
		
		ArrayList<Object> all= getAllCountryName();
		HashSet<Object> set = new HashSet<Object>(all);
		set.remove("India");
		System.out.println(set.size());
		Assert.assertEquals(set.size(),4);
	}
	
	//Test that has only 4 foreign players including India	
	@Test
	void test_03() throws FileNotFoundException, IOException, ParseException {
		
		ArrayList<Object> all= getAllCountryName();
		HashSet<Object> set = new HashSet<Object>(all);
		Assert.assertEquals(set.size(),4);
	}
		

	//Test to validate that team has one wicket keeper.
	@Test
	void test_02() throws FileNotFoundException, IOException, ParseException {
		ArrayList<Object> all= getRoleName();
		
		Assert.assertEquals(all.contains("Wicket-keeper"), true);
		
	}

}

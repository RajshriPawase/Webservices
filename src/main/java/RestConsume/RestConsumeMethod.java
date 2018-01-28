package RestConsume;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class RestConsumeMethod {

	public static void main(String[] args) throws Exception {
		System.out.println("RestFul client****RestAssured***** ");
		getResponse();
		System.out.println("\n\nRestFul client****HttpClient***** ");
		getHttpClient();
		System.out.println("\n\nRestFul client****java.net.URL***** ");
		getNetURL();
		System.out.println("\n\nRestFul client****RESTEasy***** ");
		getRESTEasy();
		

	}


	private static void getRESTEasy() throws Exception {
		
		ClientRequest request=new ClientRequest("http://jsonplaceholder.typicode.com/users");
		request.accept("application/json");
		ClientResponse<String> resp=request.get(String.class);
		JSONArray jsonArray=new JSONArray(resp.getEntity());
		formatData(jsonArray);
		
	}


	private static void getNetURL() throws IOException {
		// TODO Auto-generated method stub
		URL url=new URL("http://jsonplaceholder.typicode.com/users");
		HttpURLConnection conn=(HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		/*
		 * JsonArray accepts only string or collection 
		 * to convert an InputStream to a String:
		 * add apache-commons-io jar ans use tostring() method of IOUtils class
		 */
		JSONArray jsonArray=new JSONArray(IOUtils.toString(conn.getInputStream()));
		formatData(jsonArray);
	}


	private static void getHttpClient() throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		DefaultHttpClient httpClient=new DefaultHttpClient();
		HttpGet getrequest=new HttpGet("http://jsonplaceholder.typicode.com/users");
		HttpResponse resp=httpClient.execute(getrequest);
		//getrequest.addHeader("accept", "application/json");
		JSONArray jsonArray=new JSONArray(EntityUtils.toString(resp.getEntity()));
		formatData(jsonArray);
	}



	private static void getResponse() {
		Response resp=RestAssured.get("http://jsonplaceholder.typicode.com/users");
		JSONArray jsonArray=new JSONArray(resp.asString());
		formatData(jsonArray);
		}
		
		private static void formatData(JSONArray jsonArray) {
		UserDetails uDetails=null;
		Address address=null;
		Geo geo=null;
		Company comp=null;
	
		
		
		
		for (Object object : jsonArray) {
			
			JSONObject jsonUserObj=(JSONObject)object;
			
			uDetails=new UserDetails();
			address=new Address();
			geo=new Geo();
			comp=new Company();
			
		uDetails.setId(jsonUserObj.getInt("id"));
		uDetails.setName(jsonUserObj.getString("name"));
		uDetails.setUserName(jsonUserObj.getString("username"));
		uDetails.setEmail(jsonUserObj.getString("email"));
		
		
		JSONObject jsonAddressObj=jsonUserObj.getJSONObject("address");
		
		address.setCity(jsonAddressObj.getString("city"));
		address.setStreet(jsonAddressObj.getString("street"));
		address.setSuite(jsonAddressObj.getString("suite"));
		address.setZipcode(jsonAddressObj.getString("zipcode"));
		
		JSONObject jsonGeoObj=jsonAddressObj.getJSONObject("geo");
		geo.setLattitude(jsonGeoObj.getString("lat"));
		geo.setLongitude(jsonGeoObj.getString("lng"));
		
		JSONObject jsonCompanyObj=jsonUserObj.getJSONObject("company");
		comp.setName(jsonCompanyObj.getString("name"));
		comp.setBs(jsonCompanyObj.getString("bs"));
		
		address.setGeo(geo);
		uDetails.setAdd(address);
		
		uDetails.setPhone(jsonUserObj.getString("phone"));
		uDetails.setWebSite(jsonUserObj.getString("website"));
		uDetails.setCompany(comp);
		
		List l=new ArrayList();
		l.add(uDetails);
		Iterator itr=l.iterator();
		while (itr.hasNext()) {
			UserDetails ud = (UserDetails) itr.next();
			System.out.println("**Basic Info**\n"+"Id:"+ud.getId()+"\tName:"+ud.getName()+"\tUser Name:"+ud.getUserName()+"\tEmail:"+ud.getEmail()+
					"\n\t\t**Address Details**"+"\tStreet:"+ud.getAdd().getStreet()+"\tSuite:"+ud.getAdd().getSuite()+"\tCity:"+ud.getAdd().getCity()+"\tZipcode:"+ud.getAdd().getZipcode()+
					"\tLattitude:"+ud.getAdd().getGeo().getLattitude()+"\tLongitude:"+ud.getAdd().getGeo().getLongitude()+
					"\n"+"\tPhone:"+ud.getPhone()+"\tWebsite:"+ud.getWebSite()+
					"\n\t\t**Company Details**"+"\tCompany Name:"+ud.getCompany().getName()+"\tCompany BS:"+ud.getCompany().getBs());
			
		}
		
	}

}

}
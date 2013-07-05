package com.urieljuliatti.foursquare;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.urieljuliatti.foursquare.models.VenuesResult;
import com.urieljuliatti.foursquare.query.NearbySearchQuery;
import com.urieljuliatti.foursquare.query.Query;
import com.urieljuliatti.foursquare.query.SearchQuery;


public class Foursquare {

	private String clientId = "";
	private String clientSecret = "";
	
	public Foursquare(String clientId, String clientSecret) {
		this.clientId = clientId;
		this.clientSecret = clientSecret;
	}
	
	public VenuesResult getVenues(Query query) 
			throws JSONException, ClientProtocolException, IOException {
		JSONObject response = executeRequest(query.toString());
		VenuesResult result = new VenuesResult(response);
		return result;
	}
	
	public VenuesResult getVenues(String keyword, int radius, double lat, double lon) 
			throws JSONException, ClientProtocolException, IOException {
		NearbySearchQuery query = new NearbySearchQuery(keyword, lat, lon);
		query.setKeyword(keyword);
		query.setIntent("browse");
		query.setRadius(radius);
		VenuesResult result = getVenues(query);

		return result;
	}
	private JSONObject executeRequest(String query) 
			throws ClientProtocolException, IOException, JSONException {
		query += "client_id=" + clientId + "&client_secret=" + clientSecret;
		
		HttpClient client = new DefaultHttpClient();
		Log.i("query", query);
		HttpGet request = new HttpGet(query);

		ResponseHandler<String> handler = new BasicResponseHandler();
		String response = client.execute(request, handler);
		JSONObject jsonResponse = new JSONObject(response);
		return jsonResponse;
	} 
	

}

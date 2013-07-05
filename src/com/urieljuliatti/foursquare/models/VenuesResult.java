package com.urieljuliatti.foursquare.models;


import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class VenuesResult extends Result {

	private List<Venue> mVenues = new ArrayList<Venue>();
	
	public VenuesResult(JSONObject jsonResponse) throws JSONException {
		super(jsonResponse);
		if (jsonResponse.has("response")) {
			JSONArray results = jsonResponse.getJSONObject("response").getJSONArray("venues");
			for(int i = 0; i < results.length(); i++) {
				Venue venue = new Venue(results.getJSONObject(i));
				mVenues.add(venue);
			}		
		}
	}

	public List<Venue> getVenues() {
		return mVenues;
	}
}


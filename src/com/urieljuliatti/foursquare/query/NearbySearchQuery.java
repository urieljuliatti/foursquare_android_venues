package com.urieljuliatti.foursquare.query;

import android.location.Location;

public class NearbySearchQuery extends SearchQuery {
	
	public NearbySearchQuery(String keyword, Location location) {
		this(keyword, location.getLatitude(), location.getLongitude());
	}

	public NearbySearchQuery(String keyword, double lat, double lon) {
		setLocation(lat, lon);
	}
	
	// Meters
	public void setRadius(double radius){
		mQueryBuilder.addParameter("radius", String.valueOf(radius));
	}
	
	public void setIntent(String intent)
	{
		mQueryBuilder.addParameter("intent", intent);
	}
	
	public void setLimit(int limit){
		mQueryBuilder.addParameter("limit", String.valueOf(limit));
	}
	
	public void setKeyword(String keyword) {
		mQueryBuilder.addParameter("query", keyword);
	}
	
	@Override
	public String getUrl() {
		return "https://api.foursquare.com/v2/venues/search";
	}
}

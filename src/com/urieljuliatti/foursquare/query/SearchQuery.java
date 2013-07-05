package com.urieljuliatti.foursquare.query;

import android.location.Location;

public abstract class SearchQuery extends Query {
	
	public void setLocation(double latitude, double longitude) {
		String location = Double.toString(latitude) + "," + Double.toString(longitude);
		mQueryBuilder.addParameter("ll", location);
	}
	
	public void setLocation(Location location) {
		setLocation(location.getLatitude(), location.getLongitude());
	}
	
	public void setClientId(String client_id) {
		mQueryBuilder.addParameter("client_id", client_id);
	}

	
	@Override
	public String toString() {
		return (getUrl() + mQueryBuilder.toString());
	}
}

package com.urieljuliatti.foursquare.models;

import org.json.JSONException;
import org.json.JSONObject;

public class VenueLocation {
	
	private String address = "";
	private double lat = 0;
	private double lng = 0;
	private double distance = 0;
	private String city = "";
	private String state = "";
	private String country = "";
	private String cc = "";
	private String crossStreet = "";
	public VenueLocation(JSONObject jsonVenue){
		try {
			if(jsonVenue.has("address") && !jsonVenue.isNull("address"))
				setAddress(jsonVenue.getString("address"));
			if(jsonVenue.has("crossStreet") && !jsonVenue.isNull("crossStreet"))
				setCrossStreet(jsonVenue.getString("crossStreet"));
			if(jsonVenue.has("lat") && !jsonVenue.isNull("lat"))
				setLat(jsonVenue.getDouble("lat"));
			if(jsonVenue.has("lng") && !jsonVenue.isNull("lng"))
				setLng(jsonVenue.getDouble("lng"));
			if(jsonVenue.has("distance") && !jsonVenue.isNull("distance"))
				setDistance(jsonVenue.getDouble("distance"));
			if(jsonVenue.has("city") && !jsonVenue.isNull("city"))
				setCity(jsonVenue.getString("city"));
			if(jsonVenue.has("state") && !jsonVenue.isNull("state"))
				setState(jsonVenue.getString("state"));
			if(jsonVenue.has("country") && !jsonVenue.isNull("country"))
				setCountry(jsonVenue.getString("country"));
			if(jsonVenue.has("cc") && !jsonVenue.isNull("c"))
				setCc(jsonVenue.getString("cc"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getCrossStreet() {
		return crossStreet;
	}

	public void setCrossStreet(String crossStreet) {
		this.crossStreet = crossStreet;
	}
}

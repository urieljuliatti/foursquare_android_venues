package com.urieljuliatti.foursquare.models;

import org.json.JSONException;
import org.json.JSONObject;

public class VenueContact {
	private String twitter = "";
	private String formattedPhone = "";
	private String phone = "";

	public VenueContact(JSONObject jsonVenue){

		try {
			if(jsonVenue.has("twitter") && !jsonVenue.isNull("twitter"))
				setTwitter(jsonVenue.getString("twitter"));
			if(jsonVenue.has("formatted_phone") && !jsonVenue.isNull("formatted_phone"))
				setFormattedPhone(jsonVenue.getString("formatted_phone"));
			if(jsonVenue.has("phone") && !jsonVenue.isNull("phone"))
				setPhone(jsonVenue.getString("phone"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getFormattedPhone() {
		return formattedPhone;
	}

	public void setFormattedPhone(String formattedPhone) {
		this.formattedPhone = formattedPhone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}

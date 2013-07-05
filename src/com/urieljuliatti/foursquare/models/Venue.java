package com.urieljuliatti.foursquare.models;


import org.json.JSONException;
import org.json.JSONObject;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class Venue implements Parcelable {

	private String name = "";
	private String address = "";
	private VenueContact contact;
	private VenueLocation location;
	private String id = "";
	private String checkinsCount ="";
	private String usersCheckinsCount = "";
	private String usersTipCount = "";
	private String hereNow = "";
	public Venue(Parcel in){

	}

	public Venue(JSONObject jsonVenue) {

		try {
			setName(jsonVenue.getString("name"));

			//mLatitude = jsonPlace.getJSONObject("geometry").getJSONObject("location").getDouble("lat");
			//mLongitude = jsonPlace.getJSONObject("geometry").getJSONObject("location").getDouble("lng");
			//mRating = jsonPlace.getDouble("rating");
			setId(jsonVenue.getString("id"));
			if (jsonVenue.has("hereNow")){
				setHereNow(jsonVenue.getJSONObject("hereNow").getString("count"));
			}
			if (jsonVenue.has("stats")){
				setCheckinsCount(jsonVenue.getJSONObject("stats").getString("checkinsCount"));
				setUsersCheckinsCount(jsonVenue.getJSONObject("stats").getString("usersCount"));
				setUsersTipCount(jsonVenue.getJSONObject("stats").getString("tipCount"));
			}

			if (jsonVenue.has("contact")){
				JSONObject contactArray = jsonVenue.getJSONObject("contact");
				if(contactArray.length() > 0){
					setContact(new VenueContact(jsonVenue.getJSONObject("contact")));
				}
			}
			if (jsonVenue.has("location")){
				JSONObject locationArray = jsonVenue.getJSONObject("location");
				if(locationArray.length() > 0){
					setLocation(new VenueLocation(jsonVenue.getJSONObject("location")));
				}
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		/*
		out.writeString(mName);
		out.writeString(mAddress);
		out.writeDouble(mLatitude);
		out.writeDouble(mLongitude);
		//out.writeDouble(mRating);
		out.writeString(mReference);
		out.writeParcelable(mDetails, flags);
		 */

	}

	public VenueContact getContact(){
		return this.contact;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	public String getCheckinsCount() {
		return checkinsCount;
	}

	public void setCheckinsCount(String checkinsCount) {
		this.checkinsCount = checkinsCount;
	}

	public void setContact(VenueContact contact){
		this.contact = contact;
	}

	public String getHereNow() {
		return hereNow;
	}

	public void setHereNow(String hereNow) {
		this.hereNow = hereNow;
	}



	public String getUsersCheckinsCount() {
		return usersCheckinsCount;
	}

	public void setUsersCheckinsCount(String usersCheckinsCount) {
		this.usersCheckinsCount = usersCheckinsCount;
	}



	public String getUsersTipCount() {
		return usersTipCount;
	}

	public void setUsersTipCount(String usersTipCount) {
		this.usersTipCount = usersTipCount;
	}



	public VenueLocation getLocation() {
		return location;
	}

	public void setLocation(VenueLocation location) {
		this.location = location;
	}



	public static final Parcelable.Creator<Venue> CREATOR = new Parcelable.Creator<Venue>() {

		public Venue createFromParcel(Parcel in) {
			return new Venue(in);
		}

		public Venue[] newArray(int size) {
			return new Venue[size];
		}
	};
}

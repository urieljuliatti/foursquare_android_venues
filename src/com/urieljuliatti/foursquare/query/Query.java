package com.urieljuliatti.foursquare.query;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.text.format.DateFormat;

import com.urieljuliatti.foursquare.query.QueryBuilder;


public abstract class Query {

	protected QueryBuilder mQueryBuilder = new QueryBuilder();
	
	public Query() {
		setDate(getFormattedDate());
	}
	
	public void setDate(String date) {
		mQueryBuilder.addParameter("v", date);
	}
	
	
	public abstract String getUrl();
	
	@Override
	public String toString() {
		return (getUrl() + mQueryBuilder.toString());
	}
	
	public String getFormattedDate()
	{
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		return dateFormat.format(date);
	}
	
}

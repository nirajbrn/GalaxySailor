package com.merchant.guide.model;

import java.util.ArrayList;

/**
 * Query class to represent reply of Query
 *
 */
public class Query {
	
	public String query;
	public ArrayList<String> elements;
	public float price;
	public boolean isCredit;
	
	public Query(String query, ArrayList<String> elements, float price, boolean credit) {
		this.query = query;
		this.elements = elements;
		this.price = price;
		this.isCredit = credit;
	}

}

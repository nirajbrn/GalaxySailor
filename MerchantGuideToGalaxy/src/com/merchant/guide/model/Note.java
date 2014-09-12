package com.merchant.guide.model;

/**
 * 
 * Note class to represent Element price Object
 *
 */
public class Note {

	public String element;
	public float price;
	public String romanValue;
	public boolean isMetal;
	public Note(String element, float price, String romanValue, boolean isMetal) {
		this.element = element;
		this.price = price;
		this.isMetal = isMetal;
		this.romanValue = romanValue;
	}
}

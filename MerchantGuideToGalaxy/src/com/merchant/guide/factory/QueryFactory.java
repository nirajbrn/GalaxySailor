package com.merchant.guide.factory;


import java.util.ArrayList;

import com.merchant.guide.logic.RomanToPriceConvertor;
import com.merchant.guide.model.Note;
import com.merchant.guide.model.Query;
import com.merchant.guide.util.GalaxyUtil;

/**
 * QueryFactory() class will create appropriate query object depending on input query string structure.
 * 
 */
public class QueryFactory {

	/**
	 * GalacticToRomanQuery() processes those queries seeking the decimal equivalent of any RomanNumeral and return the Query Object.
	 * @param query
	 */
	public static Query GalacticToRomanQuery(String query){
		
		Query galacticToRomanQuery = null;
		if (GalaxyUtil.isValidinput(query)== true){
			ArrayList<String> tokenValueToRoman = new ArrayList<String>();
			ArrayList<String> tokenValue = GalaxyUtil.splitQuery(query);
			for (int i = 0; i < tokenValue.size(); i++) {
				
				Note note = (Note)GalaxyUtil.elementNoteValue.get(tokenValue.get(i));
				if(note == null){
					galacticToRomanQuery = new Query(query, null, 0, false);
					return galacticToRomanQuery;
				}
				tokenValueToRoman.add(note.romanValue);
			}
			float priceValue = new RomanToPriceConvertor().romanToDecimal(tokenValueToRoman.toString());
			galacticToRomanQuery = new Query(query, tokenValue, priceValue, false);
			
		}else{
			galacticToRomanQuery = new Query(query, null, 0, false);
		}
		
		return galacticToRomanQuery;
	}
	
	/**
	 * MetalPriceQuery() processes those queries seeking the Credit value of any quantity of elements and return the Query Object.
	 * @param query
	 */
	public static Query MetalPriceQuery(String query){
		
		Query metalPriceQuery = null;
		if (GalaxyUtil.isValidinput(query) == true){
			ArrayList<String> tokenValue = GalaxyUtil.splitQuery(query);
			ArrayList<String> tokenValueToRoman = new ArrayList<String>();
			float metalPrice = 0;
			for (int i = 0; i < tokenValue.size(); i++) {
				Note note = (Note)GalaxyUtil.elementNoteValue.get(tokenValue.get(i));
				if(note != null){
					
					if(note.isMetal){
						metalPrice = note.price;
					}else{
						tokenValueToRoman.add(note.romanValue);
					}
					
				}else{
					metalPriceQuery = new Query(query, null, 0, true);
				}
			}
			float elementValue = (new RomanToPriceConvertor().romanToDecimal(tokenValueToRoman.toString()) * metalPrice);
			metalPriceQuery = new Query(query, tokenValue, elementValue, true);
			
		}else{
			metalPriceQuery = new Query(query, null, 0, true);
		}
		return metalPriceQuery;
	}
}

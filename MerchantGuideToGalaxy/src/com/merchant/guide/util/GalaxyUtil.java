package com.merchant.guide.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.merchant.guide.model.Note;

public class GalaxyUtil {

	/**
	 * elementNoteValue : {pish=Note(String element, float price, String romanValue, boolean isMetal),..}
	 */
	public static Map<String, Note> elementNoteValue = new HashMap<String, Note>();
	/**
	 * Applies regex on each input in the file to figure out the valid ones.
	 * @param query
	 * @return
	 */
	public static boolean isValidinput(String query){
		Pattern regex = Pattern.compile("[$&+,:;=@#|]");
		Matcher matcher = regex.matcher(query);
		if (matcher.find()){
			return false;
		}
		else{
			return true;
		}

	}

	/**
	 * Splits the query and returns an ArrayList containing only Roman numerals and elements
	 * @param query
	 * @return
	 */
	public static ArrayList<String> splitQuery(String query){
		ArrayList<String> queryArray = new ArrayList<String>(Arrays.asList(query.split("((?<=:)|(?=:))|( )")));
		int startIndex = 0, endIndex = 0;
		for (int i = 0; i < queryArray.size(); i++) {
			if(queryArray.get(i).toLowerCase().equals("is")){
				startIndex = i+1;
			}
			else if(queryArray.get(i).toLowerCase().equals("?")){
				endIndex = i;

			}
		}
		String[] array = queryArray.toArray(new String[queryArray.size()]);
		return new ArrayList<String>(Arrays.asList(java.util.Arrays.copyOfRange(array, startIndex, endIndex)));

	}
	
	/**
	 * Formats the response to a query and displays it in readable format
	 * @param output
	 * @return
	 */
	public static String outputFormatter(ArrayList<String> output){
		return output.toString().replace(",", "").replace("[", "").replace("]", "");
	}
}

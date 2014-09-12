package com.merchant.guide.factory;

import com.merchant.guide.logic.RomanToPriceConvertor;
import com.merchant.guide.model.Note;
import com.merchant.guide.util.GalaxyUtil;

/**
 * 
 * NoteFactory() class should create appropriate note object depending on input note string structure.
 *
 */
public class NoteFactory {

	/**
	 * GalacticToRomanNote() will return Note object of dirt element having romanValue
	 * @param query
	 * @return
	 */
	public static Note GalacticToRomanNote(String[] query){

		String element = query[0];
		String romanValue = query[query.length - 1];
		float priceValue = new RomanToPriceConvertor().romanToDecimal(romanValue);
		Note note = new Note(element, priceValue, romanValue, false);

		return note;
	}

	/**
	 * MetalPriceNote() will return Note object of Metal
	 * @param noteQuery
	 * @return
	 */
	public static Note MetalPriceNote(String[] noteQuery){

		int splitIndex = 0;
		int creditValue = 0; String element= null; String[] valueofElement = null;
		for (int i = 0; i < noteQuery.length; i++) {
			if(noteQuery[i].toLowerCase().equals("credits")){
				creditValue = Integer.parseInt(noteQuery[i-1]);
			}
			if(noteQuery[i].toLowerCase().equals("is")){
				splitIndex = i-1;
				element = noteQuery[i-1];
			}
			valueofElement = java.util.Arrays.copyOfRange(noteQuery, 0, splitIndex);
		}

		StringBuilder romanGroupPrice = new StringBuilder();
		for (int j = 0; j < valueofElement.length; j++) {
			Note dirtElementNote = (Note)GalaxyUtil.elementNoteValue.get(valueofElement[j]);
			if(dirtElementNote != null){
				romanGroupPrice.append(dirtElementNote.romanValue);
			}
		}
		float valueOfElementInDecimal = new RomanToPriceConvertor().romanToDecimal(romanGroupPrice.toString());
		float priceValue = creditValue/valueOfElementInDecimal;
		Note note = new Note(element, priceValue, null, true);

		return note;
	}
}

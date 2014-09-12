package com.merchant.guide.logic;

import java.util.ArrayList;

import com.merchant.guide.Constant;
import com.merchant.guide.factory.NoteFactory;
import com.merchant.guide.factory.QueryFactory;
import com.merchant.guide.model.Note;
import com.merchant.guide.model.Query;
import com.merchant.guide.util.GalaxyUtil;

public class KnowledgeBase implements Constant{

	/**
	 * addNotes() will parse the given priceQuery using Note factory class which returns 
	 * the Note Object 
	 * @param priceQueryLines
	 */
	public void addNotes(String[] priceQueryLines){
	
		for (String priceQuery : priceQueryLines) {
			String noteQuery[] = priceQuery.split(regex);
			
			if(noteQuery.length == 3 && noteQuery[1].equalsIgnoreCase(is)){
				Note galacticRomanNote = NoteFactory.GalacticToRomanNote(noteQuery);
				GalaxyUtil.elementNoteValue.put(galacticRomanNote.element, galacticRomanNote);
			}else{
				Note metalPriceNote = NoteFactory.MetalPriceNote(noteQuery);
				GalaxyUtil.elementNoteValue.put(metalPriceNote.element, metalPriceNote);
			}
		}
		
	}
	
	/**
	 * processQuery() is processing the query by using Query Factory class and return the reply Query Object.
	 * @param questionQueryLines
	 */
	public ArrayList<Query> processQuery(String[] questionQueryLines){
		
		ArrayList<Query> queryReplyList = new ArrayList<Query>();
		for (String query : questionQueryLines) {
			
			if (query.toLowerCase().startsWith(galacticToRomanQry)){
				Query galacticToRomanQuery = QueryFactory.GalacticToRomanQuery(query);
				queryReplyList.add(galacticToRomanQuery);
			}
			else if (query.toLowerCase().startsWith(metalPriceQry)){
				Query metalPriceQuery = QueryFactory.MetalPriceQuery(query);
				queryReplyList.add(metalPriceQuery);
			}
		}
		return queryReplyList;
	}
	
	/**
	 * answerQuery() display the result of corresponding query.
	 * @param query
	 */
	public String answerQuery(Query query) {
		String reply = null;
		if(query != null){
			if(query.elements != null){
				ArrayList<String> queryReply = query.elements;
				queryReply.add(is);
				queryReply.add(Float.toString(query.price));
				
				if(query.isCredit){
					queryReply.add(credit);
				}
				
				reply = GalaxyUtil.outputFormatter(queryReply);
			}else{
				reply = badQuery;
			}
			reply = query.query+" "+reply;
			
			//System.out.println(query.query+" "+reply);
		}
		return reply;
	}
}

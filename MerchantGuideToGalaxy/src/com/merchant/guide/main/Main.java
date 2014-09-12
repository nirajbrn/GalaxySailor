package com.merchant.guide.main;

import java.util.ArrayList;

import com.merchant.guide.logic.KnowledgeBase;
import com.merchant.guide.model.Query;

public class Main {

	/**
	 * Process the hard coded value of Notes and after parsing show the result of query
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> results = new ArrayList<String>();
		KnowledgeBase kb = new KnowledgeBase();
		String priceQueryLines[] = {"glob is I","prok is V","pish is X","tegj is L",
				"glob glob Silver is 34 Credits","glob prok Gold is 57800 Credits","pish pish Iron is 3910 Credits"};
		
		kb.addNotes(priceQueryLines);
		
		String questionQueryLines[] = {"how much is pish tegj glob glob ?",
										"how many Credits is glob prok Silver ?",
										"how many Credits is glob prok Gold ?",
										"how many Credits is glob prok Iron ?",
										"how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"};
		
		ArrayList<Query> queryReplyObj = kb.processQuery(questionQueryLines);
		for (Query query : queryReplyObj) {
			results.add(kb.answerQuery(query));
		}
		
		for (String result : results) {
			System.out.println(result);
		}
	}

}

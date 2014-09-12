package com.test.merchant.main;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.merchant.guide.logic.KnowledgeBase;
import com.merchant.guide.model.Query;

public class ProgramTest {

	private ArrayList<Query> queryReplyObj = null;
	private KnowledgeBase kb = new KnowledgeBase();
	
	@Before
	public void processQuery(){
		
		String priceQueryLines[] = {"glob is I","prok is V","pish is X","tegj is L",
				"glob glob Silver is 34 Credits","glob prok Gold is 57800 Credits","pish pish Iron is 3910 Credits"};
		
		kb.addNotes(priceQueryLines);
		
		String questionQueryLines[] = {"how much is pish tegj glob glob ?",
				"how many Credits is glob prok Silver ?",
				"how many Credits is glob prok Gold ?",
				"how many Credits is glob prok Iron ?"};

		queryReplyObj = kb.processQuery(questionQueryLines);
		
	}
	
	@Test
	/**
	 * Method test a positive scenario of the application.
	 */
	public void testProgram() {
		
		ArrayList<String> results = new ArrayList<String>();
		String output = "";
		
		for (Query query : queryReplyObj) {
			results.add(kb.answerQuery(query));
		}
		
		for (String result : results) {
			output = output + result+"\n";
		}
		Assert.assertEquals("how much is pish tegj glob glob ? pish tegj glob glob is 42.0\n"+
				"how many Credits is glob prok Silver ? glob prok Silver is 68.0 Credits\n"+
				"how many Credits is glob prok Gold ? glob prok Gold is 57800.0 Credits\n"+
				"how many Credits is glob prok Iron ? glob prok Iron is 782.0 Credits\n"
				, output);
		

	}
}

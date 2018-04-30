package com.ubs.opsit.helper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.ubs.opsit.enums.OutputLine;

public class TimeConverterHelperTest {
	
	@Test
	public void testHoursTimeDecoder() {
		StringBuilder output=new StringBuilder();
		output=TimeConverterHelper.hoursTimeDecoder(output, 4);
		assertEquals("RRRR", output.toString());
	}

	@Test
	public void  testMinutsFirstLineDecoder() {
		StringBuilder output=new StringBuilder();
		output=TimeConverterHelper.minutsFirstLineDecoder(output, 3);
		assertEquals("YYROOOOOOOO", output.toString());
	}

	@Test
	public void testMinutsSecondLineDecoder() {
		StringBuilder output=new StringBuilder();
		output=TimeConverterHelper.minutsSecondLineDecoder(output, 2);
		assertEquals("YYOO", output.toString());
	}
	
	
	@Test
	public void negativeTestHoursTimeDecoder() {
		StringBuilder output=new StringBuilder();
		output=TimeConverterHelper.hoursTimeDecoder(output, 4);
		assertNotEquals("RRRRR", output.toString());
	}

	@Test
	public void  negativeTestMinutsFirstLineDecoder() {
		StringBuilder output=new StringBuilder();
		output=TimeConverterHelper.minutsFirstLineDecoder(output, 3);
		assertNotEquals("YYROOOOOO", output.toString());
	}

	@Test
	public void negativeTestMinutsSecondLineDecoder() {
		StringBuilder output=new StringBuilder();
		output=TimeConverterHelper.minutsSecondLineDecoder(output, 2);
		assertNotEquals("YYOOO", output.toString());
	}

	@Test
	public void testLogicSwicherForFirstLine()
	{
		StringBuilder output=new StringBuilder();
		TimeConverterHelper.logicSwicher(output, 3, OutputLine.FIRST_LINE);
		assertEquals("RRRO", output.toString());
	}
	
	@Test
	public void testLogicSwicherForSecondLine()
	{
		StringBuilder output=new StringBuilder();
		TimeConverterHelper.logicSwicher(output, 2, OutputLine.SECOND_LINE);
		assertEquals("RROO", output.toString());
	}
	
	@Test
	public void testLogicSwicherForThirdLine()
	{
		StringBuilder output=new StringBuilder();
		TimeConverterHelper.logicSwicher(output, 3, OutputLine.THIRD_LINE);
		assertEquals("YYROOOOOOOO", output.toString());
	}
	
	@Test
	public void testLogicSwicherForFourthLine()
	{
		StringBuilder output=new StringBuilder();
		TimeConverterHelper.logicSwicher(output, 2, OutputLine.FOURTH_LINE);
		assertEquals("YYOO", output.toString());
	}
}

package com.ubs.opsit.interviews;

import com.ubs.opsit.enums.OutputLine;
import com.ubs.opsit.helper.TimeConverterHelper;

public class TimeConverterImpl implements TimeConverter {

	@Override
	public String convertTime(String aTime) {
		String[] time = aTime.split(":");
		StringBuilder output = new StringBuilder();
		int secondSwitch = Integer.parseInt(time[2]) % 2;
		if (secondSwitch == 0) {
			output.append("Y");
		} else {
			output.append("O");
		}
		output.append("\r\n");
		int hoursFirstLine = Integer.parseInt(time[0]) / 5;
		int hoursSecondLine = Integer.parseInt(time[0]) % 5;

		TimeConverterHelper.logicSwicher(output, hoursFirstLine, OutputLine.FIRST_LINE);
		output.append("\r\n");
		TimeConverterHelper.logicSwicher(output, hoursSecondLine, OutputLine.SECOND_LINE);
		output.append("\r\n");

		int minuteFirstLine = Integer.parseInt(time[1]) / 5;
		int minuteSecondLine = Integer.parseInt(time[1]) % 5;
		TimeConverterHelper.logicSwicher(output, minuteFirstLine, OutputLine.THIRD_LINE);
		output.append("\r\n");
		TimeConverterHelper.logicSwicher(output, minuteSecondLine, OutputLine.FOURTH_LINE);
		return output.toString();
	}

	public static void main(String args[]) {
		TimeConverterImpl timeConverterImpl = new TimeConverterImpl();
		System.out.println(timeConverterImpl.convertTime("24:00:00"));
	}
}

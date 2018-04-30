package com.ubs.opsit.helper;

import com.ubs.opsit.enums.OutputLine;

public class TimeConverterHelper {

	public static StringBuilder hoursTimeDecoder(StringBuilder output, int hours) {
		for (int i = 0; i < 4; i++) {
			if (i < hours) {
				output.append("R");
			} else if (i >= hours) {
				output.append("O");
			}
		}
		return output;
	}

	public static StringBuilder minutsFirstLineDecoder(StringBuilder output, int minutes) {
		for (int i = 1; i <= 11; i++) {
			if (i % 3 == 0 && i <= minutes) {
				output.append("R");
			} else if (i <= minutes) {
				output.append("Y");
			} else if (i > minutes) {
				output.append("O");
			}
		}
		return output;
	}

	public static StringBuilder minutsSecondLineDecoder(StringBuilder output, int minutes) {
		for (int i = 0; i < 4; i++) {
			if (i < minutes) {
				output.append("Y");
			} else if (i >= minutes) {
				output.append("O");
			}
		}
		return output;
	}

	public static StringBuilder logicSwicher(StringBuilder output, int time, OutputLine outputLine) {
		switch (outputLine) {
		case FIRST_LINE:
			hoursTimeDecoder(output, time);
			break;
		case SECOND_LINE:
			hoursTimeDecoder(output, time);
			break;
		case THIRD_LINE:
			minutsFirstLineDecoder(output, time);
			break;
		case FOURTH_LINE:
			minutsSecondLineDecoder(output, time);
			break;
		default:
			break;
		}
		return output;
	}
}

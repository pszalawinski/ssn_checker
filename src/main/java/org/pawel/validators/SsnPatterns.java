package org.pawel.validators;
public enum SsnPatterns {
	PATTERN1("YYYYMMDDXXXX"),
	PATTERN2("YYYYMMDD-XXXX"),
	PATTERN3("YYMMDDXXXX"),
	PATTERN4("YYMMDD-XXXX"),
	PATTERN5("YYYYMMDDXXX+"),
	PATTERN6("YYMMDDXXX+"),
	PATTERN7("YYMMDD-XXX+"),
	PATTERN8("YYYYMMDD-XXX+");

	public final String pattern;

	private SsnPatterns(String pattern) {
		this.pattern = pattern;
	}
}

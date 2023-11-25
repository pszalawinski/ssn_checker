package org.pawel.utils;

public class SsnUtils {


	public String removeCentury(String ssn){
		return ssn.substring(2);
	};

	public String prepareSsn(String rawSsn){
		return removeDashes(rawSsn.replaceAll(" ", ""));
	}
	private String removeDashes(String ssn){
		String removedDashes = ssn.replace("-","");
		System.out.println("Trimmed ssn: "+ ssn.replace("-",""));
		return removedDashes;
	};

}

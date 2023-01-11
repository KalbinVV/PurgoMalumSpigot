package org.kalbinvv.purgomalumspigot.utils;

public class StringUtils {

	public static String filterSpecialSymbolsInString(String unfilteredString) {
		String filteredString = unfilteredString
				.replaceAll("%", "%25")   
				.replaceAll(" ", "%20")   
				.replaceAll("\t", "%20")  
				.replaceAll("\n", "%20")  
				.replaceAll("\r", "%20") 
				.replaceAll("!", "%21")  
				.replaceAll("\"", "%22")
				.replaceAll("#", "%23")
				.replaceAll("\\$", "%24")
				.replaceAll("&", "%26")
				.replaceAll("'", "%27")
				.replaceAll("\\(", "%28")
				.replaceAll("\\)", "%29")
				.replaceAll("\\*", "%2a")
				.replaceAll("\\+", "%2b")
				.replaceAll(",", "%2c")
				.replaceAll("-", "%2d")
				.replaceAll("\\.", "%2e")
				.replaceAll("/", "%2f")
				.replaceAll(":", "%3a")
				.replaceAll(";", "%3b")
				.replaceAll("<", "%3c")
				.replaceAll("=", "%3d")
				.replaceAll(">", "%3e")
				.replaceAll("\\?", "%3f")
				.replaceAll("@", "%40")
				.replaceAll("\\[", "%5b") 
				.replaceAll("\\\\", "%5c")
				.replaceAll("\\]", "%5d")
				.replaceAll("\\^", "%5e")
				.replaceAll("_", "%5f")
				.replaceAll("`", "%60")
				.replaceAll("\\{", "%7b")
				.replaceAll("\\|", "%7c")
				.replaceAll("\\}", "%7d")
				.replaceAll("~", "%7e");
		
		return filteredString;
	}

}

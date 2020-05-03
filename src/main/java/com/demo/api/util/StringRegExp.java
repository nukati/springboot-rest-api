package com.demo.api.util;

import org.junit.platform.commons.util.StringUtils;

public class StringRegExp {

	public static boolean isAlpha(String str) {

		if (str == null || str.isEmpty() || StringUtils.isBlank(str)) {
			return false;
		}

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (!((ch >= 'A' && ch <= 'Z') || ch == ' ')) {
				return false;
			}
		}
		return true;
	}

	public static String convertAlpha(String str) {
		String cntSpace = "";
		String convert = "";

		if (str == null || str.isEmpty() || StringUtils.isBlank(str)) {
			return str;
		}
		int j = 0;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == ' ') {
				j = j + 1;
			} else {
				if (j > 0) {
					cntSpace = cntSpace + String.valueOf(j) + cntSpace.valueOf(ch);
				} else {
					cntSpace = cntSpace + cntSpace.valueOf(ch);

				}
				j = 0;
			}
		}

		for (int i = cntSpace.length() - 1; i > -1; i--) {
			char ch = cntSpace.charAt(i);
			convert = convert + convert.valueOf(ch);
		}

		return convert.toLowerCase();
	}

	/*public static void main(String[] args) {
		String s = "The World";
		System.out.println("String: " + s);
		System.out.println("IsAlpha: " + isAlpha(s));
		//if (isAlpha(s)) {
			System.out.println("ConvertAlpha: " + convertAlpha("The World"));
			System.out.println("ConvertAlpha: " + convertAlpha(" the world"));
			System.out.println("ConvertAlpha: " + convertAlpha("THE WORLD"));
			System.out.println("ConvertAlpha: " + convertAlpha(" THE WORLD"));
			System.out.println("ConvertAlpha: " + convertAlpha("THE1 WORLD1"));
			System.out.println("ConvertAlpha: " + convertAlpha("The1 World 1"));
			System.out.println("ConvertAlpha: " + convertAlpha("A HEN  HAS  MANY   CHICKS"));
			System.out.println("ConvertAlpha: " + convertAlpha("THE WORLD."));
			System.out.println("ConvertAlpha: " + convertAlpha("THE WORLD #"));
		//} else {
			//System.out.println("Cann't convert.");
		//}
	}*/
}

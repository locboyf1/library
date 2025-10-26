package com.library.project.vinhuni.Utillities;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class Functions {

	public static String stringToAlias(String input) {
		if (input == null) {
			return "";
		}

		String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);

		Pattern pattern = Pattern.compile("\\p{M}");

		String noAccent = pattern.matcher(normalized).replaceAll("");

		String slug = noAccent.toLowerCase().replaceAll("đ", "d").replaceAll("\\s+", "-").replaceAll("[^a-z0-9-]", "")
				.replaceAll("-{2,}", "-").replaceAll("^-|-$", "");

		return slug;
	}
}

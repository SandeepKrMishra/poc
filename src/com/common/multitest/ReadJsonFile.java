package com.design;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadJsonFile {
	public static void main(String[] args) {
		String jsonData = readFile("/home/sandeep/us.json");
		System.out.println("HKHR" + jsonData);
	}

	public static String readFile(String filename) {
		String result = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			result = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}


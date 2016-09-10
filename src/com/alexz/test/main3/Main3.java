package com.alexz.test.main3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Main3 {
	public static void main(String[] args) {
		if (args.length != 2) throw new IllegalArgumentException("Check start argument");
		System.out.println(Duplicates.execute(new File(args[0]), new File(args[1])));
		//System.out.println(Duplicates.execute(new File("in.txt"), new File("out.txt")));
	}

	static class Duplicates {
		static HashMap<String, Integer> mMap;

		static boolean execute(File input, File output) {
			if (input == null || output == null || !input.isFile() || !output.isFile()) return false;
			mMap = new HashMap<>();
			try {
				Files.write(
						output.toPath(),
						Files.lines(input.toPath())
								.parallel()
								.peek(Duplicates::add)
								.distinct()
								.sorted()
								.map(s -> String.format("%s[%d]", s, mMap.get(s)))
								.sequential()
								.collect(Collectors.toList()),
						StandardOpenOption.APPEND,
						StandardOpenOption.CREATE,
						StandardOpenOption.WRITE
				);
			} catch (Exception e) {
				return false;
			}
			return true;
		}

		private synchronized static void add(String s) {
			if (!mMap.containsKey(s)) mMap.put(s, 0);
			mMap.replace(s, mMap.get(s) + 1);
		}
	}
}

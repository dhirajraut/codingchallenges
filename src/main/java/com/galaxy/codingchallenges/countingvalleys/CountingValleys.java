package com.galaxy.codingchallenges.countingvalleys;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CountingValleys {
	static int countingValleys(int n, String s) {

		int level = 0;
		boolean valley = false;
		int valleyCount = 0;
		for (int index = 0; index < n; index++) {
			if (Character.compare('U', s.charAt(index)) == 0) {
				level++;
			} else if (Character.compare('D', s.charAt(index)) == 0) {
				level--;
			}
			if (level < 0) {
				valley = true;
			} else if (level == 0 && valley) {
				valleyCount++;
				valley = false;
			}
		}
		return valleyCount;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String s = scanner.nextLine();

		int result = countingValleys(n, s);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}

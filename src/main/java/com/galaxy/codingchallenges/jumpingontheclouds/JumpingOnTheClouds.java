package com.galaxy.codingchallenges.jumpingontheclouds;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JumpingOnTheClouds {

	// Complete the jumpingOnClouds function below.
	static int jumpingOnClouds(int[] c) {
		int currentPosition = 0;
		int jumpCounter = 0;
		
		while (currentPosition < c.length - 1) {
			int jumpSteps = 2;
			
			/* Check if Jump is safe. */
			if ((currentPosition + jumpSteps < c.length - 1)
					&& c[currentPosition + jumpSteps] == 1) {
				/* Thunderhead on 2 steps. */
				jumpSteps = 1;
				if (c[currentPosition + jumpSteps] == 1) {
					/* Thunderhead on next step too. No safe jump. */
					return 0;
				}
			}
			
			/* Perform Jump */
			currentPosition += jumpSteps;
			jumpCounter++;
		}
		
		return jumpCounter;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] c = new int[n];

		String[] cItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int cItem = Integer.parseInt(cItems[i]);
			c[i] = cItem;
		}

		int result = jumpingOnClouds(c);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}

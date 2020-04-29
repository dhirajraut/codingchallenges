package com.galaxy.codingchallenges.sockmerchant;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class SockMerchantPairingSocks {
    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
    	
    	HashMap<Integer, Integer> sockHolder = new HashMap<Integer, Integer>();
    	int numberOfPairs = 0;
    	for (int sockColor: ar) {
    		if (sockHolder.get(sockColor) != null) {
    			/* Pair found. Count & discard the pair. */
    			sockHolder.remove(sockColor);
    			numberOfPairs ++;
    		}
    		else {
    			 /* Hold the sock till we get a pair. */
    			sockHolder.put(sockColor, 1);
    		}
    	}
    	return numberOfPairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

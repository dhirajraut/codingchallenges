package com.galaxy.codingchallenges.repeatedstring;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
    	s = "aba";
    	n = 10;
    	
    	long totalNumberOfA = 0;
    	long localCountOfA = 0, localCountOfAReminder = 0;
    	long sLength = s.length();
    	
    	long repeatations = n / sLength;
    	long reminder = n % sLength;
    	
    	/* Identify number of A's in full string and reminder string. */
    	for (int pointer = 0; pointer < sLength;) {
    		
    		int nextIndex = s.indexOf('a', pointer);
    		if (nextIndex >= 0) {
	    		localCountOfA++;
	    		if (nextIndex < reminder) {
	    			localCountOfAReminder++;
	    		}
	    		pointer = nextIndex + 1;
    		}
    		else break;
    	}
    	
    	/* Calculate total count. */
    	totalNumberOfA = (localCountOfA * repeatations) + localCountOfAReminder; 
    	return totalNumberOfA;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	repeatedString(null, 0);
    	
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

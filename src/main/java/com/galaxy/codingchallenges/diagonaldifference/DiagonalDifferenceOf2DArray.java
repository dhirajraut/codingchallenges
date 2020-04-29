package com.galaxy.codingchallenges.diagonaldifference;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DiagonalDifferenceOf2DArray {
	/*
	 * Complete the 'diagonalDifference' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * 2D_INTEGER_ARRAY arr as parameter.
	 */

	public static int diagonalDifference(List<List<Integer>> arr) {
		int matrixLength = arr.size();
		int rightToLeftDiagonal = 0, leftToRightDiagonal = 0; // Sum holders

		// For each List element in the array
		for (int arrayCounter = 0; arrayCounter < matrixLength; arrayCounter++) {
			List<Integer> internalArr = arr.get(arrayCounter);

			// Prepare for sum
			int leftToRightCounter = arrayCounter;
			int rightToLeftCounter = matrixLength - 1 - arrayCounter;
			for (; leftToRightCounter < matrixLength; leftToRightCounter++, rightToLeftCounter--) {
				leftToRightDiagonal += internalArr.get(leftToRightCounter);
				rightToLeftDiagonal += internalArr.get(rightToLeftCounter);
				break;
			}
		}
		return Math.abs(leftToRightDiagonal - rightToLeftDiagonal);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<Integer>> arr = new ArrayList<List<Integer>>();

		for (int i = 0; i < n; i++) {
			String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

			List<Integer> arrRowItems = new ArrayList<Integer>();

			for (int j = 0; j < n; j++) {
				int arrItem = Integer.parseInt(arrRowTempItems[j]);
				arrRowItems.add(arrItem);
			}

			arr.add(arrRowItems);
		}

		int result = DiagonalDifferenceOf2DArray.diagonalDifference(arr);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}

}

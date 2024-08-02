package com.email;

import java.util.Random;

public class RandomNumber {

	public static int[] getRandomNumber(int size, int range) {

		int[] arr = new int[size];
		Random ran = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ran.nextInt(range);
		}
		return arr;

	}

	public static String getOrderId() {

		String OTP = "";
		int[] randomNumbers = RandomNumber.getRandomNumber(8, 9);

		for (int randomNumber : randomNumbers) {

			OTP = OTP + "" + randomNumber;
		}

		return OTP;
	}

}

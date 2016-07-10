package com.jvs.test.threads.dateformat;

import java.util.Calendar;
import java.util.Date;

public class ThreadTestDateFormatter {

	private static final int MAX_NUM_THREADS = 30;
	private static Thread[] threads = new Thread[MAX_NUM_THREADS];

	public static void main(String[] args) {
		System.out.println("Testing date formatter with " + MAX_NUM_THREADS + " threads");

		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new Runnable() {
				@Override
				public void run() {
					//------------------------------------------------------------------------
					// You will get 30 rows with: "> enero 15, 1970" and 30 rows with: "> julio 10, 2016" 
					Date testDate = new Date(Calendar.getInstance().getTimeInMillis());
					String newDate = UtilDate.getFormattedDateMMMMdYYYY_ThreadSafe(testDate);
					System.out.println("> " + newDate);

					Date testDate2 = new Date(1245454545);
					String newDate2 = UtilDate.getFormattedDateMMMMdYYYY_ThreadSafe(testDate2);
					System.out.println("> " + newDate2);
					//------------------------------------------------------------------------
					// You will get unexpected results
					Date testDate11 = new Date(Calendar.getInstance().getTimeInMillis());
					String newDate11 = UtilDate.getFormattedDateMMMMdYYYY_NO_ThreadSafe(testDate11);
					System.out.println(">> " + newDate11);

					Date testDate22 = new Date(1256565656);
					String newDate22 = UtilDate.getFormattedDateMMMMdYYYY_NO_ThreadSafe(testDate22);
					System.out.println(">> " + newDate22);
					//------------------------------------------------------------------------
				}
			});
		}

		for (Thread thread : threads) {
			thread.start();
		}

	}

}

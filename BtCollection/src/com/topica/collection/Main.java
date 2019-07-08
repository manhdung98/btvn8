package com.topica.collection;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int numberInit;
		int rad;
		double radInit;
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		HashMap<Integer, Circle> hm = new HashMap<Integer, Circle>();
		for (int i = 0; i < 100; i++) {
			rad = 1 + rd.nextInt(100);
			Circle circle = new Circle(rad);
			hm.put(i, circle);
		}
		String index = 0 + " ";

		hm.forEach((key, value) -> System.out.println(key + " - " + value.getRadius()));
		numberInit = sc.nextInt();
		radInit = Math.sqrt(numberInit / Math.PI);
		double min = Math.abs(radInit - hm.get(0).getRadius());
		double area = 0;
		for (Entry<Integer, Circle> en : hm.entrySet()) {
			if (Math.abs(radInit - en.getValue().getRadius()) < min) {
				min = Math.abs(radInit - en.getValue().getRadius());
				index = en.getKey() + " ";
				area = en.getValue().getRadius() * en.getValue().getRadius() * Math.PI;
			} else if (Math.abs(radInit - en.getValue().getRadius()) == min) {
				index += en.getKey() + " ";
			}

		}
		System.out.println("index:" + index);
		System.out.println("area : " + area);
		System.out.println("Order: ");
		LinkedHashMap<Integer, Circle> sortedMap = new LinkedHashMap<>();
				hm.entrySet()
			        .stream()
			        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
			        .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
		sortedMap.forEach((key, value) -> System.out.println(value.getRadius()));
		System.out.println(System.currentTimeMillis() - startTime);

	}

	

}

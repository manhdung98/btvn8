package com.topica.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
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
		System.out.println(min);
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
		hm = sortHashMapByValues(hm);
		hm.forEach((key, value) -> System.out.println(value.getRadius()));

	}

	public static LinkedHashMap<Integer, Circle> sortHashMapByValues(HashMap<Integer, Circle> passedMap) {
		List<Integer> mapKeys = new ArrayList<>(passedMap.keySet());
		List<Circle> mapValues = new ArrayList<>(passedMap.values());
		Collections.sort(mapValues);
		Collections.sort(mapKeys);

		LinkedHashMap<Integer, Circle> sortedMap = new LinkedHashMap<>();

		Iterator<Circle> valueIt = mapValues.iterator();
		while (valueIt.hasNext()) {
			Circle val = valueIt.next();
			Iterator<Integer> keyIt = mapKeys.iterator();

			while (keyIt.hasNext()) {
				Integer key = keyIt.next();
				Circle comp1 = passedMap.get(key);
				Circle comp2 = val;

				if (comp1.equals(comp2)) {
					keyIt.remove();
					sortedMap.put(key, val);
					break;
				}
			}
		}
		return sortedMap;
	}

}

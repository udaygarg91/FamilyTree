package com.epam.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericTest<T> {
	T o;

	GenericTest() {
	}

	GenericTest(T o) {
		this.o = o;
	}

	T getob() {
		return o;
	}

	void add(T o) {
		System.out.println(o);
	}

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>();
		l.add(1);
		GenericTest<List<Integer>> obj = new GenericTest<>();
		obj.add(l);
	}
}

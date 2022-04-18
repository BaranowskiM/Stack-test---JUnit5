package pl.edu.pw.ii.pte.junit.tdd.step9exercise;

import java.nio.BufferOverflowException;
import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {

	public static int maximumCapacity = 10; //zmienna nie mog³a byæ "final" ze wzglêdu na niesta³¹ wartoœæ wielkoœci arraya
	private int size = 0;
	private int[] contents = new int[maximumCapacity];

	public boolean isEmpty() {
		return size == 0;
	}

	public void push(int i) {
		if (size == maximumCapacity) {       //configurable Stack capacity
			contents = Arrays.copyOf(contents, contents.length + 1);
			maximumCapacity++;
		}
		contents[size++] = i;
	}

	public int pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return contents[--size];
	}

	public int getSize(){
		return size;
	}
	
	public int clear() {
		return size = 0;
	}
	
	
}

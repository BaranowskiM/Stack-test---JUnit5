package pl.edu.pw.ii.pte.junit.tdd.step9exercise;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.BufferOverflowException;
import java.util.EmptyStackException;

import pl.edu.pw.ii.pte.junit.tdd.step9exercise.Stack;

public class StackTests {

	@Test
	public void newlyCreatedStackIsEmpty() {
		Stack s = new Stack();

		assertTrue(s.isEmpty());
	}

	@Test
	public void afterPushStackIsNoLongerEmpty() {
		Stack s = new Stack();

		s.push(1);

		assertFalse(s.isEmpty());
	}

	@Test
	public void afterPushAndPopStackIsEmptyAgain() {
		Stack s = new Stack();

		s.push(1);
		s.pop();

		assertTrue(s.isEmpty());
	}

	@Test
	public void emptyStackThrowsOnPop() {
		assertThrows(
		EmptyStackException.class,
		()->{
			Stack s = new Stack();
			s.pop();
			}
		);
	}

	@Test
	public void popReturnsWhatWasPushed() {
		Stack s = new Stack();

		s.push(1234);

		assertEquals(1234, s.pop());
	}

	@Test
	public void stackDoesNotBecomeEmptyWhenThereWasLessPopThanPush() {
		Stack s = new Stack();

		s.push(1);
		s.push(2);
		s.pop();

		assertFalse(s.isEmpty());
	}

	@Test
	public void lastPopReturnsFirstPushedValue() {
		Stack s = new Stack();

		s.push(1);
		s.push(2);
		s.pop();

		assertEquals(1, s.pop());
	}
/*
	@Test @Disabled //Ze wzglêdu na p³ynne ustawienie wielkoœci Stosu,
					//ten test jest zbêdny - brak maksymalnej wartoœci
					
	public void stackThrowsWhenTryingToPushMoreThanMaximumCapacity() {
		assertThrows(
			BufferOverflowException.class,
		()->{
			Stack s = new Stack();

			for (int i = 0; i < Stack.maximumCapacity + 1; ++i)
				s.push(i);
			}
		);
	}
*/	
	// TODO Stack.getSize()
	@Test
	public void sizeOfStack() {
		Stack s = new Stack();
		
		s.push(1);
		assertTrue(s.getSize() == 1);
		s.push(2);
		s.push(3);
		
		s.pop();
		assertEquals(s.pop(), 2);
		
		assertTrue(s.getSize() == 1);
		s.push(4);
		
		assertTrue(s.getSize() == 2);
		assertEquals(s.pop(), 4);
		
	}
	
	
	// TODO Stack.clear()
	@Test
	public void clearTheStack() {
		Stack s = new Stack();
		s.push(1);
		s.push(1);
		assertTrue(s.getSize() == 2);
		s.push(1);
		s.push(1);
		assertTrue(s.getSize() == 4);
		s.clear();
		
		assertTrue(s.getSize() == 0);
	}
	
	// TODO configurable Stack capacity
	@Test
	public void configurableCapacity() {
		Stack s = new Stack();
		
		for(int i = 1; i <= Stack.maximumCapacity; i++) {
			s.push(i);
		}
		
		
		s.push(11);
		assertEquals(s.getSize(), 11);
		s.pop();
		assertEquals(s.pop(), 10);
		s.push(10);
		s.push(11);
		s.push(12);
		s.push(20);
		assertEquals(s.getSize(), 13);
		assertEquals(s.pop(), 20);
		
		for(int i = 0; i < 5; i++) {
			s.pop();
		}
		
		assertEquals(s.pop(), 7);
		assertEquals(s.getSize(), 6);
		assertFalse(s.isEmpty());
	}
	
	
	
	
}




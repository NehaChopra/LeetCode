package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

class Node {
	char data;
	Node next;

	Node(char data) {
		this.data = data;
		this.next = null;
	}

}

class LinkedList {
	Node head;
	int len = 0;

	public Node add(char data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
			len++;
			return head;
		}
		Node last = head;
		while (last.next != null) {
			last = last.next;
		}
		last.next = node;
		len++;
		return head;
	}

	public boolean findPalidrome() {
		boolean isPalidrome = true;
		int middle = len / 2;
		int pos = 0;

		Stack<Character> st = new Stack<Character>();
		while (head.next != null && pos < middle) {
			pos++;
			st.push(head.data);
			head = head.next;
		}
		head = head.next;///// 'a'
		while (head != null && !st.isEmpty()) {
			isPalidrome = isPalidrome && (head.data == st.pop());
		}
		return isPalidrome;
	}
}

class DS {
	Stack<Integer> st = new Stack<Integer>();
	List<Integer> arr = new ArrayList<>();

///5 3 7 1
	/// 5 3 3 1
	public void push(int data) {
		int index = 0;
		if (st.isEmpty()) {
			st.push(data);
			arr.add(data);
		} else {
			st.push(data);
			int min = minEl(arr);
			arr.add(min);
		}
	}

	public static int minEl(List<Integer> arr) {
		// o n
		int min = Integer.MAX_VALUE;
		for (Integer e : arr) {
			if (min > e) {
				min = e;
			}
		}
		return min;
	}
}

class Station {
	String name;
	Station next;
	
	public Station add(String name) {
		Station st = new Station(name);
	}
	
	Station(String name) {
		this.name = name;
		this.next = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Station other = (Station) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}

class MetroLine{
	Station source;//A1
	Station dest;//A10
	
	MetroLine(Station source , Station dest){
		
	}
	
	public Station add(String name) {
		Station st = new Station(name);
	}
	
}
class Card {
	UUID id;
	double balance = 50;

	}

	SwipeState----------------------state SwipeIN-SwipeOut

	SwipeState.SwipeIN.getValue=

	enum SwipeState {
		SwipeIN, SwipeOut;

	}

	Facotry Patter - 
	inteface fairCal{
		double weekday = 0;
		double weekend = 0;
	}

	class Weekday implemets fairCal{
		double weekday = 7;
		public void weekdayDed(int noStation) {
			return weekday * noStation;
		}
		
	}
	

	class Weekday implemets fairCal{
		double weekend = 5.5;
		Weekday(){}
		Weekday(double weekend){
			this.weekend = weekend;
		}
		public void weekendDed(int noStation) {
			return weekend * noStation;
		}
		
	}
	
	class yealyday implemets fairCal{
		double weekend = 5.5;
		Weekday(){}
		Weekday(double weekend){
			this.weekend = weekend;
		}
		public void weekendDed(int noStation) {
			return weekend * noStation;
		}
		
	}
	
	class facirCallObject{
		public static fairCal build(String type) {
			if("Weekday".equalsIgnoreCase(type)) {
				new Weekday(6.5);
			}
		}
	}
	class fairCal {
		
		public void fairCal(int noStation) {
			Stragedy st = 
		}
	}
	interface Stragedy{
		
	}
	class StandardStragedy implements Stragedy{
		
		public void calFair(Card card) {
			
		}
	}

	
public class Test {
	public static void main(String[] args) {
	}

}


read
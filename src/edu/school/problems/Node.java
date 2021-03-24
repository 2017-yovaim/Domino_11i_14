package edu.school.problems;

public class Node<T> {
	T data;
	Node<T> next;
	Node(T dataValue, Node<T> nextValue)
	{
		this.data = dataValue;
		this.next = nextValue;
	}
	Node(T dataValue)
	{
		this(dataValue, null);
	}
	Node()
	{
		this(null, null);
	}
	
	Node<T> getNext()
	{
		return this.next;
	}
	
	T getData()
	{
		return this.data;
	}
	
	void setData(T dataValue)
	{
		this.data = dataValue;
	}
	
	void setNext(Node<T> nextValue)
	{
		this.next = nextValue;
	}
}

package edu.school.problems;

public class Hand<T>
{
	//idk what I'm supposed to do about this
	//it sounds pretty much like a linked list
	
	private Node<T> start;
	private int size;
	
	public Hand()
	{
		start = null;
		size = 0;
	}
	
	public boolean isEmpty()
	{
		return start == null;
	}
	
	public T getStart()
	{
		return start.data;
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public void add(T item)
	{
		Node<T> newItem = new Node<>(item);
		if(this.isEmpty())
		{
			this.start = newItem;
		}
		else
		{
			Node<T> temp = start;
			while(temp.getNext() != null)
			{
				temp = temp.getNext();
			}
			temp.setNext(newItem);
		}
		this.size++;
	}
	
	public void removeFrom(int index) 
	{
		validateIndex(index);
		if (index == 0) 
		{
			this.start = start.getNext();
		} else 
		{
			Node<T> temp = start;
			int counter = 0;
			while (counter < (index - 1)) 
			{
				temp = temp.getNext();
				counter++;
			}
			Node<T> toBeRemoved = temp.getNext();
			temp.setNext(toBeRemoved.getNext());
		}
		this.size--;
	}

	public void remove(T item) 
	{
		if(getIndex(item) == -1)
			return;
		removeFrom(getIndex(item));
	}
	
	public int getIndex(T item) 
	{
		int counter = 0;
		Node<T> temp = start;
		while (temp != null) 
		{
			if(temp.getData().equals(item)) 
			{
				return counter;
			}
			counter++;
			temp = temp.getNext();
		}
		return -1;
	}

	public T get(int index) 
	{
		validateIndex(index);
		int counter = 0;
		Node<T> temp = start;
		while(counter < index)
		{
			temp = temp.getNext();
			counter++;
		}
		return temp.getData();
	}

	public void clear() {
		this.size = 0;
	}

	private void validateIndex(int index) 
	{
		if (index < 0 || index >= this.size) 
		{
			throw new IllegalArgumentException("Index is not valid.");
		}
	}
	
	public Iterator<T> getHandIterator()
	{
		return new HandIterator();
	}
	
	private class HandIterator implements Iterator<T>
	{
		Node<T> current;
		HandIterator()
		{
			current = (Node<T>) start;
		}
		@Override
		public T next() 
		{
			//note - returns the current value, not the next one
			//turns current into next value
			T toReturn = current.data;
			current = current.next;
			return toReturn;
		}

		@Override
		public boolean hasNext() 
		{
			if(current == null)
				return false;
			return current.next != null;
		}
	}
	
}

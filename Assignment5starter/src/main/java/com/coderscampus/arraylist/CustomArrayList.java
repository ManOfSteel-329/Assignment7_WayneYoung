package com.coderscampus.arraylist;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10];
	private int size = 0;

	@Override
	public boolean add(T item) {
		if (size == items.length) {
			resizeArray();
		}
		items[size] = item;
		size++;
		return true;
	}

	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds for size: " + size);
		}
		if (size == items.length) {
			resizeArray();
		}
		// in total there are size that many items, we only need to shift elements that come after index
		// So size - index is the number of elements that we need to shift or copy
		// size: total
		// index: num we do not shift
		// size - index: num we do shift
		System.arraycopy(items, index, items, index+1, size - index);
		items[index] = item;
		size++;
		return true;
	}

	private void resizeArray() {
		int newLength = 2 * items.length;
		Object[] newArray = new Object[newLength];
		System.arraycopy(items, 0, newArray, 0, size);
		items = newArray;
		// the old items array will be garbage collected, since nothing refers to it.

	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= size) {
			// what's being thrown out of this method is an object
			// of type IndexOutOfBoundsException, which is created with the new ClassName(params)
			throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds for size: " + size);
		}
		return (T) items[index];
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		return null;
	}

	public void removeAtIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds for size: " + size);
		}

		// Shift elements to the left starting from the index
		for (int i = index; i < size - 1; i++) {
			items[i] = items[i + 1];
		}

		// Set the last element to null and decrement size
		items[size - 1] = null;
		size--;
	}


}

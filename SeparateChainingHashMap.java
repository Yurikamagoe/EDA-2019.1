package br.ufc.crateus.eda.hash;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unchecked")
public class SeparateChainingHashMap<K, V> implements Map<K, V> {
	private static class Node {
		Object key;
		Object value;
		Node next;

		Node(Object key, Object value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	private Node[] table;

	private int size = 0;

	public SeparateChainingHashMap(double d) {
		this.table = new Node[(int) d];
	}

	public SeparateChainingHashMap() {
		this(97);
	}

	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % table.length;
	}

	private Node getNode(K key) {
		int i = hash(key);
		for (Node n = table[i]; n != null; n = n.next)
			if (key.equals(n.key))
				return n;
		return null;
	}

	@Override
	public void put(K key, V value) {
		Node n = getNode(key);
		if (n == null) {
			int i = hash(key);
			table[i] = new Node(key, value, table[i]);
			size++;
		} else {
			n.value = value;
		}
	}

	private void resize(int newLength) {
		SeparateChainingHashMap<K, V> tmp = new SeparateChainingHashMap<K, V>(newLength);
		for (int i = 0; i < table.length; i++) {
			for (Node n = table[i]; n != null; n = n.next)
				tmp.put((K) n.key, (V) n.value);
		}
		table = tmp.table;
	}

	@Override
	public V get(K key) {
		Node n = getNode(key);
		return n == null ? null : (V) n.value;
	}

	@Override
	public void remove(K key) {
		int i = hash(key);
		Node head = new Node(null, null, table[i]);
		for (Node n = head; n.next != null; n = n.next) {
			if (key.equals(n.next.key)) {
				n.next = n.next.next;
				size--;
				if (this.size / table.length == 4)
					resize(table.length / 2);
				break;
			}
		}
		table[i] = head.next;

	}

	@Override
	public Iterable<K> keys() {
		Queue<K> queue = new LinkedList<K>();
		for (int i = 0; i < table.length; i++) {
			Node tmp = table[i];
			while (tmp != null) {
				queue.add((K) tmp.key);
				tmp = tmp.next;
			}
		}
		return queue;
	}

	@Override
	public boolean contains(K key) {
		return get(key) == key;
	}

	public int[] getLength() {
		int lower = 1000000000; //valor muito grande
		int bigger = 0;
		int count = 0;
		for (int i = 0; i < table.length; i++) {
			Node temporary = table[i];
			count = 0;
			while (temporary != null) {
				temporary = temporary.next;
				count++;
			}
			if(count<= lower) {
				lower = count;
			}
			if(count>=bigger)
				bigger = count;
		}

		 int[] vector = new int[2];
		 vector[0] = bigger;
		 vector[1] = lower;
		 return vector;
	}
}
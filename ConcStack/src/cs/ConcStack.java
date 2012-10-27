package cs;

import java.util.concurrent.atomic.AtomicReference;

public class ConcStack<T> {
	Node<T> top;
	Node<T> head;
	
	public ConcStack(){
		head = new Node<T>(null);
		top = head;
	}
	
	public void push(T item){
		Node<T> node = new Node<T>(item);
		node.next.compareAndSet(null, top.next.get());
		top.next.compareAndSet(top.next, node.next);
	}
}

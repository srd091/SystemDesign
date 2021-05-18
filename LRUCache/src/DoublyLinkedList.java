public class DoublyLinkedList {
	private Node head;
	private Node lastNode = null;
	private int size;

	DoublyLinkedList(int size) {
		this.size = size;
	}

	Node addNode(String key, int value){

		Node node = new Node(key, value);

		node.next = head;
		node.prev = null;

		if(head != null){
			head.prev = node;
		}

		head = node;

		this.size++;

		if(lastNode == null){
			lastNode = head;
		}

		return node;
	}

	void deleteNode(Node node){
		if(node == null || head == null){
			return;
		}

		if(head == node) {
			head = node.next;
		}

		if(node.prev != null){
			node.prev.next = node.next;
		}

		if(node.next != null){
			node.next.prev = node.prev;
		}

		this.size--;
	}

	Node deleteLastNode(){

		Node node = lastNode;

		if(head == lastNode) {
			head = lastNode = null;
		}

		if(node.prev != null){
			node.prev.next = node.next;
		}

		lastNode = node.prev;

		return node;
	}

	int getSize() {
		return size;
	}

	void printList() {
		Node node = head;
		while (node != null) {
			System.out.print(node.key + "-" + node.value + " ");
			node = node.next;
		}
		System.out.println();
	}
}

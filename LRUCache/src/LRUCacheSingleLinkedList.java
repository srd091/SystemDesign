import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

public class LRUCacheSingleLinkedList {

	private HashMap<String, Node> cacheKeysMap;
	private LinkedList<Node> cache;
	private int capacity;

	public LRUCacheSingleLinkedList(int capacity){
		this.capacity = capacity;
		cacheKeysMap = new HashMap<>(capacity);
		cache = new LinkedList<>();
	}

	double getValue(String key){
		double value = -1d;
		if(cacheKeysMap.containsKey(key)){
			Node node = cacheKeysMap.get(key);
			value = node.value;
			cache.remove(node);
			cache.add(node);
		}
		return value;
	}

	void updateValue(String key, int value){
		if(cacheKeysMap.containsKey(key)){
			cacheKeysMap.get(key).value = value;
		}
	}

	void addValue(String key, int value){
		Node node = new Node(key, value);

		//	evict last value
		if(cache.size()==capacity) {
			Node lastNode = cache.removeLast();
			cacheKeysMap.remove(lastNode.key);
		}
		cache.addFirst(node);
		cacheKeysMap.put(key, node);
	}

	void displayCache(){
		ListIterator<Node> iterator = cache.listIterator();
		while(iterator.hasNext()){
			Node node = iterator.next();
			System.out.println(node.key+": "+node.value);
		}
		System.out.println();
	}

	public static void main(String[] args){
		LRUCacheSingleLinkedList lruCache = new LRUCacheSingleLinkedList(5);

		lruCache.addValue("Apple", 11);
		lruCache.displayCache();

		lruCache.addValue("Banana", 6);
		lruCache.displayCache();

		lruCache.addValue("Sushi", 9);
		lruCache.displayCache();

		lruCache.addValue("Cabbage", 13);
		lruCache.displayCache();

		lruCache.addValue("Salad", 12);
		lruCache.displayCache();

		lruCache.updateValue("Sushi", 18);
		lruCache.displayCache();

		lruCache.addValue("Apple", 25);
		lruCache.displayCache();

		System.out.println(lruCache.getValue("Apple"));
	}
}
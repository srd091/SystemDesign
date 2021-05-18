import java.util.HashMap;

public class LRUCache {
	private HashMap<String, Node> cacheKeysMap;
	private DoublyLinkedList cache;
	private int capacity;

	private LRUCache(int capacity){
		this.capacity = capacity;
		cacheKeysMap = new HashMap<>(capacity);
		cache = new DoublyLinkedList(0);
	}

	private LRUCache(){

	}

	private static LRUCache lruCache = null;
	public static synchronized LRUCache getInstance(int capacity){
		if(lruCache == null){
			lruCache = new LRUCache(capacity);
		}
		return lruCache;
	}

	void addValue(String key, int value){

		// if value is already present in the cache
		if(cacheKeysMap.containsKey(key)){
			updateValue(key, value);
			getValue(key);
		}else {
			//	evict last value
			if (cache.getSize() == capacity) {
				Node lastNode = cache.deleteLastNode();
				cacheKeysMap.remove(lastNode.key);
			}

			Node node = cache.addNode(key, value);
			cacheKeysMap.put(key, node);
		}
	}

	int getValue(String key){
		int value = -1;
		if(cacheKeysMap.containsKey(key)){
			Node node = cacheKeysMap.get(key);
			value = node.value;
			cache.deleteNode(node);
			cache.addNode(key, value);
		}
		return value;
	}

	void updateValue(String key, int value){
		if(cacheKeysMap.containsKey(key)){
			cacheKeysMap.get(key).value = value;
		}
	}

	void displayCache(){
		cache.printList();
	}
}

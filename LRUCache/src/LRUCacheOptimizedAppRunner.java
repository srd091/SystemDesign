public class LRUCacheOptimizedAppRunner {

	public static void main(String[] args){
		LRUCache lruCache = LRUCache.getInstance(5);

		lruCache.addValue("Apple", 4);
		lruCache.displayCache();

		lruCache.addValue("Banana", 6);
		lruCache.displayCache();

		lruCache.addValue("Watermelon", 1);
		lruCache.displayCache();

		lruCache.addValue("Mango", 4);
		lruCache.displayCache();

		lruCache.addValue("Papaya", 2);
		lruCache.displayCache();

		lruCache.updateValue("Apple", 8);
		lruCache.displayCache();

		lruCache.addValue("Banana", 12);
		lruCache.displayCache();

		System.out.println("Value of Mango: " + lruCache.getValue("Mango"));
		lruCache.displayCache();
	}

}

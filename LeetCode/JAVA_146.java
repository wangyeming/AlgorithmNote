import java.util.HashMap;
import java.util.LinkedList;

public class JAVA_146 {

    //["LRUCache","put","put","get","put","get","put","get","get","get"]
    //[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
    public static void main(String[] argv) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }


    static class LRUCache {

        private int capacity;
        private HashMap<Integer, Integer> map = new HashMap<>();
        private LinkedList<Integer> linkedList = new LinkedList<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                linkedList.remove(Integer.valueOf(key));
                linkedList.addFirst(key);
                return map.get(key);

            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                linkedList.remove(Integer.valueOf(key));
            } else {
                if (map.size() >= capacity) {
                    Integer deleteKey = linkedList.removeLast();
                    map.remove(deleteKey);
                }
            }
            map.put(key, value);
            linkedList.addFirst(key);
        }
    }

}

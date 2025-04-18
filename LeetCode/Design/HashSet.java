/**

Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
 

Example 1:

Input
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
Output
[null, null, null, true, false, null, true, null, false]

Explanation
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1);      // set = [1]
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(1); // return True
myHashSet.contains(3); // return False, (not found)
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(2); // return True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2); // return False, (already removed)

*/

class MyHashSet {

    List<Integer> arr[];
    int BUCKETS = 10000;

    public MyHashSet() {
        arr = new ArrayList[BUCKETS];
        for (int i = 0; i < BUCKETS; i++) {
            arr[i] = new ArrayList();
        }
    }
    
    public void add(int key) {
        int hash = key % BUCKETS;
        if (!arr[hash].contains(key)) {
            arr[hash].add(key);
        }
    }
    
    public void remove(int key) {
        int hash = key % BUCKETS;
        List<Integer> list = arr[hash];
        if (list.contains(key)) {
            list.remove(Integer.valueOf(key));
        }
    }
    
    public boolean contains(int key) {
        int hash = key % BUCKETS;
        List<Integer> list = arr[hash];
        return list.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

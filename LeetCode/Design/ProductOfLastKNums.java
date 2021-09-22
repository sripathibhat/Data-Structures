/*


    Design an algorithm that accepts a stream of integers and retrieves the product of the last k integers of the stream.

    Implement the ProductOfNumbers class:

    ProductOfNumbers() Initializes the object with an empty stream.

    void add(int num) Appends the integer num to the stream.

    int getProduct(int k) Returns the product of the last k numbers in the current list. You can assume that always the current list has
    at least k numbers.

    The test cases are generated so that, at any time, the product of any contiguous sequence of numbers will fit into a single 32-bit integer
    without overflowing.

*/

// Similar to prefixSum, maintain prefixProduct array. If number to be added is 0, then reinitialize array to empty as product of last k numbers will
// always be 0 if last number in the array is 0

class ProductOfNumbers {

    List<Integer> list;
    public ProductOfNumbers() {
        list = new ArrayList<>();
        list.add(1);
    }
    
    public void add(int num) {
        if(num == 0) {
            list = new ArrayList<>();
            list.add(1);
        }
        else {
            list.add(list.get(list.size() - 1) * num);
        }
    }
    
    public int getProduct(int k) {
        if(k >= list.size()) {
            return 0;
        }
        return list.get(list.size() - 1) / list.get(list.size() - k - 1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
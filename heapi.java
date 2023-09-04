
/**
 * The general description is explained in main
 *
 * @author (Leah Kronengold,214087173)
 * @author (Ester Gotliv,213497878)
 * @version (24/06/2023)
 */
public class heapi
{       
     /**
     * The size of the heap.
     */
    public static int size = 0;
    
    /**
     * Builds a heap from the given array.
     *
     * @param a The array to build the heap from
     * @return The heap array
     */
    public static double[] BUILDHEAP(double[] a) {
        for (int i = (size) / 2 - 1; i > -1; i--) {
            heapi(a, i);
        }
        return a;
    }
    
    /**
     * Performs the heapify operation on the array starting from the given index.
     *
     * @param a The array
     * @param i The index to start heapify from
     */
    public static void heapi(double[] a, int i) {
        int result = (int) ((Math.log(i + 1)) / (Math.log(2)));//Depth calculation
        if (result % 2 == 0) {
            pushDownMax(a, i);
        } else {
            pushDownMin(a, i);
        }
    }
    
    /**
     * Performs the push down operation on the max heap starting from the given index.
     *
     * @param a The array
     * @param i The index to start push down from
     */
    public static void pushDownMax(double[] a, int i) {
        int m;//The index of the largest value
        double temp;//Substitution auxiliary variable
        if (kids(a, i) == true) {
            m = largestIndex(a, i);
            if (m != left(i) && m != right(i) && m != i) {
                // If not a child
                if (a[m] > a[i]) {
                    temp = a[m];
                    a[m] = a[i];
                    a[i] = temp;
                    if (a[m] < a[perent(m)]) {
                        temp = a[m];
                        a[m] = a[perent(m)];
                        a[perent(m)] = temp;
                    }
                    heapi(a, m);
                }
            } else if (a[m] > a[i]) {
                temp = a[m];
                a[m] = a[i];
                a[i] = temp;
            }
        }
    }
    
    /**
     * Performs the push down operation on the min heap starting from the given index.
     *
     * @param a The array
     * @param i The index to start push down from
     */
    public static void pushDownMin(double[] a, int i) {
        int m;//The index of the smallest value
        double temp = 0;//Substitution auxiliary variable
        if (kids(a, i) == true) {
            m = smallestIndex(a, i);
            if (m != left(i) && m != right(i)) {
                // If not a child
                if (a[m] < a[i]) {
                    temp = a[m];
                    a[m] = a[i];
                    a[i] = temp;
                    if (a[m] > a[perent(m)]) {
                        temp = a[m];
                        a[m] = a[perent(m)];
                        a[perent(m)] = temp;
                    }
                    heapi(a, m);
                }
            } else if (a[m] < a[i]) {
                temp = a[m];
                a[m] = a[i];
                a[i] = temp;
            }
        }
    }
    
    /**
     * Returns the index of the parent node for the given index.
     *
     * @param i The index
     * @return The index of the parent node
     */
    public static int perent(int i) {
        return ((i - 1) / 2);
    }
    
    /**
     * Returns the index of the left child of a given index i in a heap data structure.
     *
     * @param i The index
     * @return The index of the left node
     */
    public static int left(int i) {
        return 2*i+1;
    }
    
    /**
     * Returns the index of the right child of a given index i in a heap data structure.
     *
     * @param i The index
     * @return The index of the right node
     */
    public static int right(int i) {
        return 2*i+2;
    }
    
    
    /**
     *checks if a given index i in a heap data structure has any children.
     *It returns true if the index has at least one child, and false otherwise
     * @param i The index
     * @param a the array
     */
    public static boolean kids(double[] a,int i) {
        if((left(i)<= size-1 && left(i)>=0) || (right(i)<= size-1 && right(i)>=0)){
            return true;
        }
        return false;
    }
    
    /**
     *checks if a given index i in a heap data structure has any grandchildren. 
     *It returns true if the index has at least one grandchild, and false otherwise
     * @param i The index
     * @param a the array
     */
    public static boolean grandchildren(double[] a,int i) {
         if(4*i+3<size && 4*i+3>-1){
                return true;
            }
            return false;
    }

    /**
     * returns the index of the maximum element among a given index i and its children in a heap data structure.
     * @param i The index
     * @param a the array
     */
    public static int subArrayMax(double [] a,int i){
        int x=i;//An auxiliary variable that receives the index
        if(kids(a,i)==true){
            if(a[left(i)]>a[x]){
                x=left(i);
                if(right(i)<size && right(i)>-1){
                    if(a[right(i)]>a[x]){
                        x=right(i);
                    }   
                }
            }
            else{
                if(right(i)<size && right(i)>-1){
                    if(a[right(i)]>a[x]){
                        x=right(i);
                    }   
                }
            }
        }
        return x;
    }

    /**
     *returns the index of the largest element among a given index i, its left child, and its right child in a heap data structure.
     * @param i The index
     * @param a the array
     */
    public static int largestIndex(double[] a, int i) {
        double x;//An auxiliary variable for comparing two sizes
        double y;//An auxiliary variable for comparing two sizes
        if((left(i)<size && left(i)>-1)&&(right(i)<size && right(i)>-1)){
            x=a[subArrayMax(a,left(i))];
            y=a[subArrayMax(a,right(i))];
            if(x>y){
                return subArrayMax(a,left(i));
            }
            return subArrayMax(a,right(i));
        }

        if(left(i)<size && left(i)>-1){
            return left(i);
        }
        return -1;
    }

    /**
     * returns the index of the minimum element among a given index i and its children in a heap data structure.
     * @param i The index
     * @param a the array
     */
    public static int subArrayMin(double[] a, int i) {
        int x=i;//An auxiliary variable that receives the index
        if(kids(a,i)==true){
            if(a[left(i)]<a[x]){
                x=left(i);
                if(right(i)<size && right(i)>-1){
                    if(a[right(i)]<a[x]){
                        x=right(i);
                    }   
                }
            }
            else{
                if(right(i)<size && right(i)>-1){
                    if(a[right(i)]<a[x]){
                        x=right(i);
                    }   
                }
            }
        }
        return x;
    }
    
    /**
     * returns the index of the smallest element among a given index i, its left child, and its right child in a heap data structure.
     * @param i The index
     * @param a the array
     */
    public static int smallestIndex(double[] a, int i) {
        double x;//An auxiliary variable for comparing two sizes
        double y;//An auxiliary variable for comparing two sizes
        if((left(i)<size && left(i)>-1)&&(right(i)<size && right(i)>-1)){
            x=a[subArrayMin(a,left(i))];
            y=a[subArrayMin(a,right(i))];
            if(x<y){
                return subArrayMin(a,left(i));
            }
            return subArrayMin(a,right(i));
        }

        if(left(i)<size && left(i)>-1){
            x=a[subArrayMin(a,left(i))];
            if(x<a[i]){
                return subArrayMin(a,left(i));
            }
            else{
                return i;
            }
        }
        return -1;
    }

    /**
     * extracts the maximum element from a heap data structure, removes it from the heap, and returns the updated heap.
     * @param a the array
     */
    public static double [] HEAPEXTRACTMAX(double[] a){
        if(size==0)
            return a;
        double temp = a[0];//Substitution auxiliary variable
        a[0] = a[size-1];
        a[size-1] = temp;
        size=size-1;//Reducing stack length
        heapi(a,0);
        return a;
    }

    /**
     *  extracts the minimum element from a heap data structure, removes it from the heap, and returns the updated heap.
     * @param i The index
     * @param a the array
     */
    public static double[] HEAPEXTRACTMIN(double[] a){
        if(size==0)
            return a;
        int min;//Auxiliary variable for finding the minimum length
        if(a[1]>a[2])
            min=2;
        else
            min=1;
        double temp=a[min];//Substitution auxiliary variable
        a[min] = a[size-1];
        a[size-1] = temp;
        size=size-1;//Decrease stack size by one
        heapi(a,min);
        return a;
    }

    /**
     * deletes an element at index i from a heap data structure represented by the array A.
     * It first marks the element at index i as a sentinel value (A[0]+1), then adjusts the heap by swapping the element with its parent if necessary, 
     * and finally performs HEAPEXTRACTMAX(A) to remove the sentinel element and restore the heap property. 
     * The updated heap array A is returned. If the given index i is out of bounds, an error message is printed, and the original array A is returned.
     * @param i The index
     * @param a the array
     */
    public static double[] HEAPDELETE(double[] A, int i){
        if(i>=size || i<0){
            System.out.println("Error: The index does not exist"); 
            return A;
        }
        A[i] = (A[0]+1);//Placing the place in place of the index to be the largest number in the stack to push it up
        for(int j = i; j >0 && j<size-1;){
            if(A[j]>A[perent(j)]){
                double temp = A[j];
                A[j] = A[perent(j)];
                A[perent(j)] = temp;
                heapi(A,j);
            }
            j = (j-1)/2;
            if(j==0){
                break;
            }
        }
        HEAPEXTRACTMAX(A);//Sending to spend the maximum
        return A;
    }

        /**
     * Inserts a value into the heap and maintains the heap property.
     *
     * @param A     The array representing the heap
     * @param value The value to be inserted
     * @return The modified heap array
     */
    public static double[] HEAPINSERT(double[] A, double value) {
        size++; // Increase the size of the heap
        int i = (size) - 1;
        A[size - 1] = value + A[0] + 1; // Insert the value into the last position
    
        // Maintain the heap property by comparing with parent nodes and swapping if necessary
        for (int j = i; j > 0 && j < size;) {
            if (A[j] > A[perent(j)]) {
                double temp = A[j];
                A[j] = A[perent(j)];
                A[perent(j)] = temp;
                heapi(A, j);
            }
            j = (j - 1) / 2;
            if (j == 0) {
                break;
            }
        }
    
        A[0] = value; // Update the root with the inserted value
        heapi(A, 0); 
        return A;
    }
    
    /**
     * Prints the elements of the heap array.
     *
     * @param A The array representing the heap
     */
    public static void PrintHeap(double A[]) {
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                System.out.print("[");
            }
            System.out.print(A[i]);
            if (i != size - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
    
    /**
     * Sorts the heap array in ascending order.
     *
     * @param arr The array representing the heap
     * @return The sorted heap array
     */
    public static double[] heapSort(double[] arr) {
        int n = size;//por the print
        for (int i = n - 1; i > 0; i--) {
            // Move the maximum to the end
            double temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            size--;//Reducing the length of the array
            heapi(arr, 0);
        }
        size = n;
        System.out.print("The sorted heap: (heap does not exist anymore)\t");
        PrintHeap(arr);
        size = 0; // Reset the size to 0
        return arr;
    }
}

package Day01;

public class BasicOperation {

    public static void main(String[] args) {

        //*********  Time Complexity    ************ */
        int n=10;
        //Sequential operations
        for (int i = 0; i < n; i++) {
        // O(n)
        }
        //Nested loops
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // n × n = O(n²)
            }
        }       
        //Loop that doubles

        for (int i = 1; i < n; i *= 2) {
            // O(log n)
        }

        //Nested different sizes
        int m=15;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // O(n × m) Don't automatically write O(n²) unless n and m represent the same input size.
            }
        }

        //**************  Space Complexity   ************** */


            // Input space
            // Memory occupied by the input itself.
            // Auxiliary space
            // Extra memory used by your algorithm.

            int sum = 0;
            int arr[]={1,2,3,4,5,6};

            for (int x : arr) {
                sum += x;
            }

            //Time = O(n)
            //Space = O(1)

            int[] result = new int[n];

            for (int i = 0; i < n; i++) {
                result[i] = arr[i] * 2;
            }

            //Time: O(n)
            //Extra Space: O(n)

    }
    //Recursion & Complexity
    void print(int n) {
    if (n == 0) return;

    System.out.println(n);
    print(n - 1);
     //Time: O(n)
    //Call-stack space: O(n)
}

//Big-O Rules You Must Memorize
   
// Rule 1 — Drop constants

// O(2n) → O(n)
// O(100n) → O(n)

// Rule 2 — Keep the dominant term

// O(n² + n) → O(n²)
// O(n³ + n² + n) → O(n³

    
}

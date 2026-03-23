package Questions.AMQ;

// Question: Set Matrix Zero
// Problem Statement: Given a matrix if an element in the matrix is 0 then you will have to set
// its entire column and row to 0 and then return the matrix.

public class AMQ10 {
    public static void main(String[] args) {
        int[][]arr={
                {1, 1, 1, 1},
                {1, 0, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1}};
        AMQ10 obj= new AMQ10();
//        obj.BruteForce(arr);
        obj.Better(arr);
        for(int []i:arr){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    public void Optimal(int[][]arr){
        int m = arr.length;
        int n = arr[0].length;

        // Flag to track if first row should be zeroed
        boolean firstRowZero = false;
        // Flag to track if first column should be zeroed
        boolean firstColZero = false;

        // Check if first row has any zero
        for (int j = 0; j < n; j++) { // O(n)
            if (arr[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Check if first column has any zero
        for (int i = 0; i < m; i++) { // O(m)
            if (arr[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Use first row/column as markers
        for (int i = 1; i < m; i++) { // O(n)
            for (int j = 1; j < n; j++) { // O(n * m)
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }

        // Set cells to zero based on markers
        for (int i = 1; i < m; i++) { // O(n)
            for (int j = 1; j < n; j++) { // O(n * m)
                if (arr[i][0] == 0 || arr[0][j] == 0) {
                    arr[i][j] = 0;
                }
            }
        }

        // Zero the first row if needed
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {   // O(n)
                arr[0][j] = 0;
            }
        }

        // Zero the first column if needed
        if (firstColZero) {
            for (int i = 0; i < m; i++) { // O(m)
                arr[i][0] = 0;
            }
        }
        // Time Complexity: O(m * n) + O(m * n) +2*O(n) + 2*O(m)  => O(n^2)
        // Space Complexity: O(1)

    }
    public void Better(int[][] arr){
        int m = arr.length;
        int n = arr[0].length;
        int[] col=new int[m]; // o(m)
        int[] row=new int[n]; // o(n)
        for (int i = 0; i < arr.length; i++) { // o(m)
            for (int j = 0; j < arr[i].length; j++) { // o(m * n)
                if(arr[i][j]==0){
                    col[j]=1;
                    row[i]=1;
                }
            }
        }
        for (int i = 0; i <n; i++) { // o(m)
            for (int j = 0; j < m; j++) {  // o(m * n)
                if(row[i]==1||col[j]==1){
                    arr[i][j]=0;
                }
            }
        }
        // Time Complexity: O(m * n) => 2*O(n^2)
        // Space Complexity: O(m)+O(n) => 2*O(n)
    }
    public void BruteForce(int[][] arr){
        for(int i=0;i<arr.length;i++){  // o(m)
            for(int j=0;j<arr[i].length;j++){ // o(m * n)
                if(arr[i][j]==0){
                    for (int col = 0; col < arr.length; col++) { //  O(m * n * (m))
                        if (arr[i][col] != 0)
                            arr[i][col] = -1;
                    }
                    for(int row = 0; row < arr.length; row++){ // O(m * n * (m + n))
                        if (arr[row][i] != 0)
                            arr[row][i] = -1;
                    }
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]==-1){
                    arr[i][j]=0;
                }
            }
        }
        // Time Complexity: O(m * n * (m + n)) => o(n^3)
        // Space Complexity: O(1)
    }

}

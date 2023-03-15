

public class Main {

    // Exercise 0:
    // Write a method that receives an int array as input
    // and returns an array with only even elements
    //           7: i=0..6          3: 0..2
    //  { 5,3,6,43,7,4,2 }   ==> { 6,4,2 }
    //    Res[i] = Arr[i]
    static int[] evenArr( int []Arr ) {

        // Count even elements
        int count = 0;
        for(int i=0; i<Arr.length; i++)
            if ( Arr[i]%2==0 )
                count++;

        // Create result array
        int []Res = new int[ count ];

        //Copy elements into Result array
        // i : 0,1,2,3,...6
        int loc=0;
        for(int i=0; i<Arr.length; i++)
            if (Arr[i]%2==0)
                Res[loc++] = Arr[i];

        return Res;
    }


    // Exercise 1:
    //  Write a method that receives 2 int arrays and returns the concatenation
    //  Assume the arrays are non empty
    //              4          3                   7
    //  concat( {1,2,3,4}, {6,7,8} ) =>  { 1,2,3,4,  6,7,8 }
    //     copy A1 to start of Res
    //          {6,7,8,4    0,0,0 }
    //
    static int[] concat( int []A1, int []A2 ) {
        int [] Res = new int[ A1.length + A2.length ];

        //copy A1 to start of Res
        int loc=0;
        for( int i=0; i < A1.length ; i++ ){
            Res[loc++] = A1[i];
        }
        //copy A2 into end of Res

        for( int i=0; i< A2.length ; i++ ) {
            Res[ loc++ ] = A2[i];
        }
        return Res;

    }

    // Exercise 2:
    //  Write a method that receives 2 int arrays and returns the concatenation
    //    only of even elements
    //
    //  Assume the arrays are non empty
    //              4          3                   7
    //  concat( {1,2,3,4}, {6,7,8} ) =>  { 2,4,6,8 }
    //
    // solution 1:
    //  A1 -> only even elements   A2->only even elements
    // concat
    //
    // solution 2:
    //   concat A1 and A2 => take only even elements

    static int[] concatOnlyEven( int []A1, int []A2 ) {
        //Take only even from A1
        int []Even1 = evenArr( A1 );
        //Take only even from A2
        int []Even2 = evenArr( A2 );
        //concat
        return concat(Even1, Even2);
    }

    // Matrix Exercises:
    //Exercise 1: print the minimal element of double matrix

    //  { {1.0, 2.0, -30.0}, {4,5}, {6,8,1,24}, {10,20,30} };
    static void printMinOfMat( double [][]M ) {

        double min = M[0][0];

        for(int r=0; r<M.length; r++) {
            double[] Row = M[r];
            for (int c = 0; c < Row.length; c++) {
                if (M[r][c] < min) {
                    min = M[r][c];
                }
            }
        }
        System.out.println( min );
    }

    static void printArr( int []A ) {
        for(int i=0; i<A.length; i++)
            System.out.print(A[i] + " ");
        System.out.println();
    }
    //  r=  0         1        2           3
    // { {1,2,3}, {4,5,5}, {6,8,1}, {10,-20,30} } ==>
    //  { 0,0,0  ,0,0,0  ,0,0,0  ,0,0,0 }
    //             r=2, c=1
    static int[] matToArray( int [][]M ) {
        // rect matrix =>
        int numOfElements = M.length * M[0].length;

        int []Res = new int[ numOfElements ];

        int loc = 0;

        for(int r=0; r<M.length; r++) {

            for (int c = 0; c < M[r].length; c++) {

                Res[ loc++ ] = M[r][c];

            }
        }
        return Res;
    }

    public static void main(String[] args) {

        //int []MyArr = { 10,20,5,3,6,43,7,4,2,20 };
        int []MyArr = {1,2,6,3,2,1,10};
        int []Res = evenArr( MyArr );

        //printArr(Res);

        int []A1 = {1,2,3,4};
        int []A2 = {6,7,8};
       // printArr( concatOnlyEven(A1,A2) );

        //              0         1        2          3
        int [][]M = { {1,2,3}, {4,5}, {6,8,1,-2400}, {10,-20,30} };

        printArr( matToArray(M) );
    }
}

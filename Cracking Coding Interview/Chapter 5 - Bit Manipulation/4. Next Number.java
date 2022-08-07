Next Number: Given a positive integer, print the next smallest and the next largest number that
have the same number of 1 bits in their binary representation.

//Soultion

    private static int[] nextNumber(int n){
        int smallestInteger = getSmallestInteger(n);
        int largestInteger = getLargestInteger(n);
        return new int[] {smallestInteger, largestInteger};
    }

    private static int getSmallestInteger(int n) {
        for(int i=1;i<32;i++){
             //  10111
            //  3216421
           // check if bit = 1
           if(isOneBit(n, i) && !isOneBit(n, i-1)){
               // clear the current to zero, and convert i-1 to 1
               n = updateBit(n, i, 0);
               n = updateBit(n, i-1, 1);
               return n;
           }else if( !isOneBit(n, i) && isOneBit(n, i-1) &&(i+1 < 32 &&  !isOneBit(n, i+1)) ){
               n = updateBit(n, i-1, 0);
               n = updateBit(n, i, 1);
           }
       }
        return -1;
    }

    private static boolean isOneBit(int n, int i) {
        return (( n & (1 << i)) != 0);
    }

    private static int updateBit(int n, int i, int value) {
        int mask = ~(1 << i);
        return (n & mask) | (value << i);
    }

    private static int getLargestInteger(int n) {
        boolean foundZero = false;
        for(int i=0;i<31;i++) {
            // check if bit = 1
            // 010010
            if (isOneBit(n, i) && isOneBit(n, i + 1) && foundZero) {
                // clear the current to zero, and convert i-1 to 1
                n = updateBit(n, i - 1, 1);
                n = updateBit(n, i, 0);
            } else if (isOneBit(n, i) && !isOneBit(n, i + 1)) {
                n = updateBit(n, i, 0);
                n = updateBit(n, i + 1, 1);
                return n;
            } else if ((n & (1 << i)) == 0)
                foundZero = true;
        }
        return -1;
    }

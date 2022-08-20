/*
5.6 Conversion: Write a function to determine the number of bits you would need to flip to convert
integer A to integer B.
EXAMPLE
Input: 29 (or: 11101), 15 (or: 01111)
Output: 2
Input: 100 (or: 11000100), 51 (or: 0110011)
Output: 5
*/

// Solution O(1) max 32 bit 
public static int Conversion(int num1, int num2){
        int result = num1 ^ num2;  // Xor
        return countNumberOfOnes(result);
    }

    private static int countNumberOfOnes(int num){
        int ones =0;
        while (num != 0){
            int leastBit = num & 1;
            num = num >>1;
            if(leastBit ==1) ones ++;
        }
        return ones;
    }

// in less number of operation 
private static int countNumberOfOnes2(int num){
        int ones =0;
        while (num != 0){
            num &= num - 1;
            ones ++;
        }
        return ones;
    }

class Solution {
   public int[] threeEqualParts(int[] A) {
    int numOne = 0;
    for (int i: A) if (i == 1) numOne++;

    int[] res = {-1, -1};
    if (numOne == 0) return new int[]{0,2}; // special case
    if (numOne % 3 != 0) return res;

    int thirdPartStartingIndex = 0;
    int count = 0;
    for (int i = A.length - 1; i >= 0; --i){
        if (A[i] == 1){
            if (++count == numOne / 3){
                thirdPartStartingIndex = i;
                break;
            }
        }
    }

    int firstPartEndIndex = findNextEndIndexAndCompare(A, 0, thirdPartStartingIndex);
    if (firstPartEndIndex < 0) return res;

    int secondPartEndIndex = findNextEndIndexAndCompare(A, firstPartEndIndex + 1, thirdPartStartingIndex);
    if (secondPartEndIndex < 0) return res;

    return new int[]{firstPartEndIndex, secondPartEndIndex+1};
}


/** the implementation idea is similar to find last k node in a list
 *  in the sense that pacer is a pacer
 *  when the pacer reaches the end, the end for the current part has been anchored
 *  Note: we also do the comparing for the two parts of interest
 *
 * @param A
 * @param start
 * @param pacer
 * @return
 */
private int findNextEndIndexAndCompare(int[] A, int start, int pacer){
    while (A[start] == 0) start++;
    while (pacer < A.length){
        if (A[start] != A[pacer]) return -1;
        start++;
        pacer++;
    }
    return start - 1;
}
}

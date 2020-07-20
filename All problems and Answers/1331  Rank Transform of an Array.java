class Solution {
   public int[] arrayRankTransform(int[] arr) {
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        HashMap<Integer, Integer> rank = new HashMap<>();
        for (int x : sortedArr) rank.putIfAbsent(x, rank.size() + 1);
        for (int i = 0; i < arr.length; ++i) sortedArr[i] = rank.get(arr[i]);
        return sortedArr;
   }
}

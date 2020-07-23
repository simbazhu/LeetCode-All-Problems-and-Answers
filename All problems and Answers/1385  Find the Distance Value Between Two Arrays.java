class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        TreeSet<Integer> tree = new TreeSet<>();
        for(int num: arr2){
            tree.add(num);
        }
        int distance = 0;
        for(int i = 0; i < arr1.length; i++){
           int left = arr1[i] - d;
           int right = arr1[i] + d;
           Set<Integer> set = tree.subSet(left, right+1);
           if(set.isEmpty()){
             distance++;
           }
        }
        return distance;
    }
}

class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {

    // Sort using rating. If ratings are same then sort by Id.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] == a[1]? b[0] - a[0]: b[1]-a[1]);
        List<Integer> result = new ArrayList<Integer>();
        
        for(int i=0;i<restaurants.length;i++){
            if(veganFriendly == 1)  {
                if(veganFriendly != restaurants[i][2]) continue;
            }
            if(maxPrice >= restaurants[i][3] && maxDistance >= restaurants[i][4]) {
                pq.offer(restaurants[i]);
            }
        }
       // Poll and add id's to the result.
        while(!pq.isEmpty()){
            result.add(pq.poll()[0]);
        }
        return result;
    }
}

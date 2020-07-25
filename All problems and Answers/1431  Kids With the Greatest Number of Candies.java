class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int maxCandies = 0;
        for (int i = 0; i < candies.length; ++i) {
            maxCandies = Math.max(maxCandies, candies[i]);
        }
        for (int i = 0; i < candies.length; ++i) {
            result.add(candies[i] + extraCandies >= maxCandies);
        }
        return result;
    }
}

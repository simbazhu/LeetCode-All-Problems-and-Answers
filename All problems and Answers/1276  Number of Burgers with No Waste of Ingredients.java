class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        int twoX = tomatoSlices - 2 * cheeseSlices, x = twoX / 2, y = cheeseSlices - x;
        return twoX >= 0 && twoX % 2 == 0 && y >= 0 ? Arrays.asList(x, y) : Arrays.asList();        
    }
}

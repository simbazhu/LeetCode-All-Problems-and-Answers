class ParkingSystem {

    private int[] count;
    public ParkingSystem(int big, int medium, int small) {
        count = new int[]{0, big, medium, small};
    }
    
    public boolean addCar(int carType) {
        return count[carType]-- > 0;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */

class Solution {
    public int dayOfYear(String S) {
        String[] s = S.split("-");
        int year = Integer.parseInt(s[0]);
        int month = Integer.parseInt(s[1]);
        int date = Integer.parseInt(s[2]);
        int leap = isLeapYear(year) ? 1 : 0;
        int feb = 28 + leap;
        int noOfDays = 0;
        int[] days = {31, feb, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < month - 1; i++) {
            noOfDays += days[i];
        }
        return noOfDays + date;
    }
    
    boolean isLeapYear(int year) {
        if (year % 400 == 0)
            return true;
        if (year % 100 == 0)
            return false;
        if (year % 4 == 0)
            return true;
        return false;
    }
}

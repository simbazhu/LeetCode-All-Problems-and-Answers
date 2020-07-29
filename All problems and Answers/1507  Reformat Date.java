class Solution {
	  private static final Map<String, String> months = getMonths();
    public String reformatDate(String date) {
        String[] ss = date.split("\\s+");
        StringBuilder sb = new StringBuilder();
       
        sb.append(ss[2]).append("-");
        sb.append(months.get(ss[1])).append("-");
        sb.append(ss[0].length() == 3 ? ("0" + ss[0].substring(0, 1)) : ss[0].substring(0, 2));
        return sb.toString();
    }
    
    private static Map<String, String> getMonths(){
        Map<String, String> months = new HashMap<>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");
        return months;
    }
}

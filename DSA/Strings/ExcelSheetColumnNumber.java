/**
 * https://leetcode.com/problems/excel-sheet-column-number/
 * Time Complexity:O(n)
 * Space Complexity:O(1)
 */
class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if(s.length()==0)
            return 0;
        int result=0;
        int unit=1;
        for(int i=s.length()-1;i>=0;i--){
            result=result+((s.charAt(i)-'A')+1)*unit;
            unit=unit*26;
        }
        return result;
    }
}
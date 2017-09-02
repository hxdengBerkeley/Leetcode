class Solution {
    public int compareVersion(String version1, String version2) {
        int first1=0,first2=0;
        int i=0;
        while(i<version1.length()&&Character.isDigit(version1.charAt(i))){
            first1 = first1*10+ Character.getNumericValue(version1.charAt(i));
            i++;
        }
        int j=0;
        while(j<version2.length()&&Character.isDigit(version2.charAt(j))){
            first2 = first2*10+ Character.getNumericValue(version2.charAt(j));
            j++;
        }
        if (first1>first2) return 1;
        else if (first1<first2) return -1;
        else{
            if (i==version1.length()&&j==version2.length()) return 0;
            if (i==version1.length()) return compareVersion("",version2.substring(j+1));
            if (j==version2.length()) return compareVersion(version1.substring(i+1),"");
            return compareVersion(version1.substring(i+1),version2.substring(j+1));
        }
    }
}
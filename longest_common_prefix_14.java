class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1=strs[0];
        String s2=strs[strs.length-1];//not () because its an array
        int idx=0;
        while(idx<s1.length() && idx<s2.length()){ //idx should be less than the length
            if(s1.charAt(idx)!=s2.charAt(idx)){
                break;
            }
            idx++;
        }
        return new String(s1.substring(0, idx));//s1 is smaller so prefix depends on it only 

        
    }
}
/*
String[] words = {"banana", "apple", "cherry"};
        Arrays.sort(words);

        return new int[]{1, 2};
        return new String(str.substring(0, idx));


*/        
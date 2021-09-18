package hm21;

class Solution2 {
    public int firstUniqChar(String s) {
        int counter[] = new int[26];

        for(char temp_char: s.toCharArray())
            counter[(int)temp_char - (int)'a']++;

        for(int i = 0; i < s.length(); i++){
            if(counter[(int)s.charAt(i) - (int)'a'] == 1) return i;
        }
        return -1;
    }
}
// https://leetcode.com/problems/greatest-english-letter-in-upper-and-lower-case

class Solution {
    public String greatestLetter(String s) {
        // 대문자와 소문자의 ascii code 차이
        Integer DIFF = 'a' - 'A';
        
        Integer asciiCode = 0;
        Set<Integer> codeSet = new HashSet<>();
        for (Character c : s.toCharArray()) {
            Integer value = Integer.valueOf(c);
            // 소문자 변환한 코드 값을 갖고 있는 경우
            if (codeSet.contains(value + DIFF)) {
                if (asciiCode < value) asciiCode = value;
            } else if (codeSet.contains(value - DIFF)) {
                // 대문자 변환한 코드 값을 갖고 있는 경우
                if (asciiCode < value - DIFF) asciiCode = value - DIFF;
            } else {
                codeSet.add(value);
            }
        }
        return asciiCode == 0 ? "" : String.valueOf((char)asciiCode.intValue());
    }
}

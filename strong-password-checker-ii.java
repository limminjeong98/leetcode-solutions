// https://leetcode.com/problems/strong-password-checker-ii

class Solution {
    public boolean strongPasswordCheckerII(String password) {
        int n = password.length();
        if (n < 8) return false;
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasDigit = false;
        boolean hasSpecialCharacter = false;
        Set<Character> specialCharacters = Set.of('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+');

        for (int i = 0; i < n; i++) {
            if (i > 0) {
                if (password.charAt(i) == password.charAt(i - 1)) return false;
            }
            if (specialCharacters.contains(password.charAt(i))) {
                hasSpecialCharacter = true;
                continue;
            } 
            if (!hasLowerCase && Character.isLowerCase(password.charAt(i))) {
                hasLowerCase = true;
                continue;
            }
            if (!hasUpperCase && Character.isUpperCase(password.charAt(i))) {
                hasUpperCase = true;
                continue;
            }
            if (!hasDigit && Character.isDigit(password.charAt(i))) {
                hasDigit = true;
                continue;
            }
        }

        return hasSpecialCharacter && hasLowerCase && hasUpperCase && hasDigit;
    }
}

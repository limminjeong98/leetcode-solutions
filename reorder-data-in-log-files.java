// import java.util.regex.Pattern;
import java.util.*;

// https://leetcode.com/problems/reorder-data-in-log-files

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> digitLogs = new ArrayList<>();
        
        PriorityQueue<String[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1].equals(o2[1])) return o1[0].compareTo(o2[0]);
            else return o1[1].compareTo(o2[1]);
        });
        for (String log : logs) {
            String identifier = log.substring(0, log.indexOf(" "));
            String body = log.substring(log.indexOf(" ") + 1);
            // 로그가 숫자만으로 이루어진 경우
            // if (Pattern.matches("^[0-9]*$", body.replaceAll(" ", ""))) {
            if (Character.isDigit(body.charAt(0))) {
                digitLogs.add(log);
            } else {
                pq.add(new String[] { identifier, body });
            }
        }

        List<String> answer = new ArrayList<>();
        while (pq.size() > 0) {
            String[] letterLog = pq.poll();
            answer.add(letterLog[0] + " " + letterLog[1]);
        }
        answer.addAll(digitLogs);
        return answer.toArray(new String[0]);
    }
}

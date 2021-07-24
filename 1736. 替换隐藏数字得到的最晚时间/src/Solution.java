class Solution {
    public String maximumTime(String time) {
        char[] times = time.toCharArray();
        if(times[0] == '?' && times[1] == '?'){
            times[0] = '2';
            times[1] = '3';
        } else {
            if(times[0] == '?'){
                if(times[1] > '3'){
                    times[0] = '1';
                } else {
                    times[0] = '2';
                }
            }
            if(times[1] == '?'){
                if(times[0] < '2'){
                    times[1] = '9';
                } else {
                    times[1] = '3';
                }
            }
        }
        if(times[3] == '?' && times[4] == '?'){
            times[3] = '5';
            times[4] = '9';
        } else {
            if(times[3] == '?'){
                times[3] = '5';
            }
            if(times[4] == '?'){
                times[4] = '9';
            }
        }

        return new String(times);
    }
}

public class Time {
    private int hour = 0;
    private int minute = 0;
    private int second = 0;

public Time(int h, int m, int s) {
    setTime(h,m,s);
}

public int getHour(){
    return hour;
}

public int getMinute(){
    return minute;
}

public int getSecond(){
    return second;
}

public void setHour(int h){
    if (h>=0 && h<24) {
        this.hour=h;
    }
    else {
        System.out.println("Invalid hour! Setting to 0.");
        this.hour=0;
    }
}

public void setMinute(int m){
    if (m>=0 && m<60){
        this.minute=m;
    }
    else {
        System.out.println("Invalid minute! Setting to 0.");
        this.hour=0;
    }
}

public void setSecond(int s){
    if (s>=0 && s<60){
        this.second=s;
    }
    else {
        System.out.println("Invalid second! Setting to 0.");
        this.second=0;
    }
}

public void setTime(int h,int m,int s){
    setHour(h);
    setMinute(m);
    setSecond(s);
}

public void print(){
    System.out.printf("%02d:%02d:%02d%n", hour, minute, second);
}

public void nextSecond() {
        second++;
        if (second >= 60) {
            second = 0;
            minute++;
            if (minute >= 60) {
                minute = 0;
                hour++;
                if (hour >= 24) {
                    hour = 0;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Time t1 = new Time(23, 59, 58);
        t1.print(); // 23:59:58
        t1.nextSecond();
        t1.print(); // 23:59:59
        t1.nextSecond();
        t1.print(); // 00:00:00
    }
}
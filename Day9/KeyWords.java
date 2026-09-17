package assessmentday9;

public class KeyWords {
    public static void main(String[] args) throws InterruptedException {
        KeywordExecutors k=new KeywordExecutors();
        k.executers("LAUNCH_BROWSER");
        k.executers("Open_URL");
        k.executers("USERNAME");
        k.executers("PASSWORD");
        Thread.sleep(2000);
        k.executers("LOGIN_BTN");
        Thread.sleep(2000);
        k.executers("CLOSE_BROWSER");
    }
}
package assessmentday9;
public class KeywordExecutors {
    KeyWordImplementation k=new KeyWordImplementation();
    public void executers(String keyword){
        if(keyword.equals("LAUNCH_BROWSER")){
            k.launchBrowser();
        } else if (keyword.equals("Open_URL")) {
            k.openurl();
        } else if (keyword.equals("USERNAME")) {
            k.userName();
        }else if (keyword.equals("PASSWORD")) {
            k.password();
        }else if (keyword.equals("LOGIN_BTN")) {
            k.login_Btn();
        }else if (keyword.equals("CLOSE_BROWSER")) {
            k.closBrowser();
        }
    }
}
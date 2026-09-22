package LastAssessmentTask2;
import org.testng.annotations.Test;

import java.io.IOException;

public class OrangeHrmBuzzTest extends BaseClass{
    @Test
    public void buzzTest() throws IOException, InterruptedException {
        String mindText= ExcelUtility.getData(1,0);
        buzzPage.getBuzz();
        Thread.sleep(2000);

        buzzPage.getMindText(mindText);
        buzzPage.getPost();
        Thread.sleep(2000);

        if(buzzPage.verifyRecentPost(mindText))
            System.out.println("Post is displayed in Recent Posts");
        else
            System.out.println("Post is NOT displayed in Recent Posts");
    }
}
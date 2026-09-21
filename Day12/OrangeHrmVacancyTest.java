package Assessment12;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrangeHrmVacancyTest {
    WebDriver driver;
    LoginPage loginPage;
    RecruitmentPage recruitmentPage;
    VacancyPage vacancyPage;
    MyInfoPage myInfoPage;

    @BeforeClass
    public void beforeClass() {
        System.out.println("Test Execution Started");
    }

    @BeforeMethod
    public void setUp() throws IOException {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(PropertyUtility.getData("url"));
        loginPage=new LoginPage(driver);
        recruitmentPage=new RecruitmentPage(driver);
        vacancyPage=new VacancyPage(driver);
        myInfoPage=new MyInfoPage(driver);
        System.out.println("Browser Launched");
    }

    @Test(priority = 1)
    public void vacancyCreationTest() throws IOException, InterruptedException {
        loginPage.getUserName(PropertyUtility.getData("username"));
        loginPage.getPwd(PropertyUtility.getData("password"));
        loginPage.getLoginBtn();
        System.out.println("Login Successful");
        Thread.sleep(2000);
        recruitmentPage.getRecruitment();
        Thread.sleep(2000);
        recruitmentPage.getVacancy();
        recruitmentPage.getAdd();
        Thread.sleep(2000);
        vacancyPage.getVacName(ExcelUtility.getData(1,0));
        vacancyPage.getJobTitle();
        vacancyPage.selectJobTitle();
        vacancyPage.getDesc(ExcelUtility.getData(1,2));
        vacancyPage.getHiringMgr(ExcelUtility.getData(1,3));
        vacancyPage.selectHiringManager();
        vacancyPage.getNoOfPos(ExcelUtility.getData(1,4));
        Thread.sleep(2000);
        vacancyPage.getSave();
        Thread.sleep(2000);
        System.out.println("Vacancy is Added");
    }

    @Test(priority = 2)
    public void myInfoTest() throws IOException, InterruptedException {
        loginPage.getUserName(PropertyUtility.getData("username"));
        loginPage.getPwd(PropertyUtility.getData("password"));
        loginPage.getLoginBtn();
        System.out.println("Login Successful");
        Thread.sleep(2000);
        myInfoPage.getMyInfo();
        Thread.sleep(2000);
        String firstName=ExcelUtility.getMyInfoData(1,0);
        String lastName=ExcelUtility.getMyInfoData(1,1);
        String employeeId=ExcelUtility.getMyInfoData(1,2);
        myInfoPage.getFirstName(firstName);
        myInfoPage.getLastName(lastName);
        myInfoPage.getEmpId(employeeId);
        myInfoPage.getSave();
        Thread.sleep(2000);
        loginPage.getLogOut();
        Thread.sleep(2000);
        loginPage.getUserName(PropertyUtility.getData("username"));
        loginPage.getPwd(PropertyUtility.getData("password"));
        loginPage.getLoginBtn();
        Thread.sleep(2000);
        System.out.println("Login again Successful");
        myInfoPage.getMyInfo();
        Thread.sleep(2000);
        if(myInfoPage.verifyFirstName().equals(firstName))
            System.out.println("First Name is updated");
        else
            System.out.println("First Name is NOT updated");
        if(myInfoPage.verifyLastName().equals(lastName))
            System.out.println("Last Name is updated");
        else
            System.out.println("Last Name is NOT updated");
        if(myInfoPage.verifyEmployeeId().equals(employeeId))
            System.out.println("Employee ID is updated");
        else
            System.out.println("Employee ID is NOT updated");
        loginPage.getLogOut();
        System.out.println("Logout Successfully");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        System.out.println("Browser Closed");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Test Execution Completed");
    }

}

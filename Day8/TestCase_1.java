package assessmentsday8;

/*
 * 
		//Testcase 

Login to orangeHrm application ->click on Recruitment link -> click on + Add button -> enter firstname , middlename , lastname ,
select any option for vacancy ,enter email, mobile number , upload file ,select date of application ->click on save button -> click on candidates ->
select job title , select vacancy , select hiring manager ,select status , enter candidate name,select application date and click on search button -> 
verify whether the employee is added from the records found section and logout.

*/

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase_1 {
	public static void main(String[] args) throws IOException, InterruptedException, AWTException  {
		
		FileInputStream fis = new FileInputStream("./src/test/java/assessmentsday8/Day8.properties");
		Properties p = new Properties();
		p.load(fis);
		
		//properties file
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		//excelfile
		FileInputStream fis1 = new FileInputStream("./src/test/java/assessmentsday8/OrangeHrmRecruitmentpageData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String FirstName = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		String MiddleName = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		String Lastname = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		String Email = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
		//double PhoneNumber = wb.getSheet("Sheet1").getRow(1).getCell(4).getNumericCellValue();
		String CName = wb.getSheet("Sheet1").getRow(1).getCell(5).getStringCellValue();
		
		WebDriver driver = null;
		if(BROWSER.equals("chrome")) {
			driver= new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		//login
		PomLogin p1 =new PomLogin(driver);
		p1.getUn(USERNAME);
		p1.getPwd(PASSWORD);
		p1.getLgbutton();
		
		Pom_Recruiter p2 = new Pom_Recruiter(driver);
		//click on recruiter
		p2.getRecruitmrnt();
		//click on add
		p2.getAddbutton();
		//firstname
		p2.getFname(FirstName);
		//middlename
		p2.getMname(MiddleName);
		//lastname
		p2.getLname(Lastname);
		//email
		p2.getEmail(Email);
		//phno
		//p2.getPhno(PhoneNumber);
		
		//vacancy
		p2.getVacancy().click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		//resume
		Thread.sleep(5000);
		p2.getResume("C:\\Users\\Lenovo\\Downloads\\Sugali's Resume.pdf");
		p2.getSave();
		
		Pom_Candidates p3 = new Pom_Candidates(driver);
		p3.getCandidate();
		
		Thread.sleep(3000);
		p3.getJobDrop();
		Thread.sleep(3000);
		p3.getJobT();
		Thread.sleep(3000);
		p3.getCvacancyDrop();
		Thread.sleep(3000);
		p3.getCvacancy();
		Thread.sleep(3000);
		p3.getHMDrop();
		Thread.sleep(3000);
		p3.gethM();
		Thread.sleep(3000);
		p3.getStatusDrop();
		Thread.sleep(3000);
		p3.getStatus();
		p3.getCName(FirstName);
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		p3.getdate();
		p3.getSearch();
		p3.getApplicant();
	
		
		
		Thread.sleep(10000);
		driver.quit();
		
		
	}

}
package com.company;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import javax.annotation.Generated;

import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.condition.ReachedVertex;
import org.graphwalker.core.condition.TimeDuration;
import org.graphwalker.core.generator.AStarPath;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.core.machine.Context;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Generated(value = "src/main/resources/com/company/WikiWD.json")
@GraphWalker(value = "random(edge_coverage(100))", start = "Start", groups = { "default" })
public class WikiWDImpl extends ExecutionContext implements WikiWD {

	public final static Path MODEL_PATH = Paths.get("com/company/WikiWD.json");

	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sheetal_Singh\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Override
	public void e_goToLoginPage() {
		System.out.println("E =------------------------>1     e_goToLoginPage");
		driver.get("https://en.wikipedia.org/w/index.php?title=Special:UserLogin&returnto=Main+Page");
	}

	@Override
	public void VerifyLoginPageWD() {
		System.out.println("V ####################1  LoginPage");
		int userNameFieldSize = driver.findElements(By.id("wpName1")).size();
		System.out.println("is username present : " + userNameFieldSize);
		Assert.assertTrue("", userNameFieldSize > 0);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void e_goToHomePageForCustomer() {
		System.out.println("E =------------------------>2     e_goToHomePageForCustomer");
		driver.findElement(By.id("wpName1")).clear();
		driver.findElement(By.id("wpName1")).sendKeys("Sheetal2301");
		driver.findElement(By.id("wpPassword1")).sendKeys("Master@123");
		driver.findElement(By.id("wpLoginAttempt")).click();
	}

	@Override
	public void VerifyHomePageForCustomerWD() {
		System.out.println("V ####################2  HomePageForCustomer");
		String cUrl = driver.getCurrentUrl();
		System.out.println("Current URL: " + cUrl);
		Assert.assertTrue("", cUrl.endsWith("Main_Page"));

		String userName = driver.findElement(By.xpath("//*[@id=\"pt-userpage\"]/a")).getText();
		System.out.println("After Login UserName: " + userName);
		Assert.assertTrue(userName.equalsIgnoreCase("Sheetal2301"));
	}

	@Override
	public void e_goToLogoutPage() {
		System.out.println("V ####################3  LogoutPage");
		driver.findElement(By.xpath("//*[@id=\"pt-logout\"]/a")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void VerifyLogoutPageWD() {
		System.out.println("V ####################3  LogoutPage");
		Assert.assertTrue(driver.getCurrentUrl().contains("Special:UserLogout"));
	}

	@Override
	public void e_goToLoginPageFromLogoutPage() {
		System.out.println("E =------------------------>4     e_goToLoginPageFromLogoutPage");
		driver.findElement(By.xpath("//*[@id=\"pt-login\"]/a")).click();
	}

	//@Test
	public void runSmokeTest() throws IOException {
		Context context = new WikiWDImpl();
		TestBuilder builder = new TestBuilder().addContext(context, MODEL_PATH,
				new AStarPath(new ReachedVertex("VerifyLoginPageWD")));
		context.setNextElement(context.getModel().findElements("Start").get(0));
		Result result = builder.execute();
		Assert.assertFalse(result.hasErrors());
	}

	//@Test
	public void runFunctionalTest() throws IOException {
		Context context = new WikiWDImpl();
		TestBuilder builder = new TestBuilder().addContext(context, MODEL_PATH, 
				new RandomPath(new EdgeCoverage(50)));
		context.setNextElement(context.getModel().findElements("Start").get(0));
		Result result = builder.execute();
		Assert.assertFalse(result.hasErrors());
	}

	@Test
	public void runStabilityTest() throws IOException {
		Context context = new WikiWDImpl();
		TestBuilder builder = new TestBuilder().addContext(context, MODEL_PATH,
				new RandomPath(new TimeDuration(120, TimeUnit.SECONDS)));
		context.setNextElement(context.getModel().findElements("Start").get(0));
		Result result = builder.execute();
		Assert.assertFalse(result.hasErrors());
	}

}
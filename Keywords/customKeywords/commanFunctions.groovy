package customKeywords
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

class commanFunctions {


	TestData excelTestData = findTestData('Data Files/TestData/InspectTestData')
	TestData excelTestData_AR = findTestData('Data Files/TestData/InspectTestData_AR')

	TestObject LoginBtn = findTestObject('Object Repository/LoginAndRigisterUser/LoginBtn')
	TestObject otpSubmitBtn = findTestObject('Object Repository/LoginAndRigisterUser/otpSubmitBtn')
	TestObject Reg_otpSubmitBtn = findTestObject('Object Repository/LoginAndRigisterUser/Reg_otpSubmitBtn')
	TestObject adminDD = findTestObject('Object Repository/LoginAndRigisterUser/AdminDD')
	TestObject logOut = findTestObject('Object Repository/LoginAndRigisterUser/Logout')

	By objColOne = By.xpath("//table/tbody/tr[1]/td[2]")
	TestObject LoginLink = findTestObject('LoginAndRigisterUser/LoginLink')
	TestObject analysisBtn_Enabled = findTestObject('Object Repository/PublicUserHomePage/enabledAnalysisBtn')


	//Arabic web Site
	TestObject AR_logOut = findTestObject('Object Repository/AR_LoginAndRigisterUser/Logout')


	@Keyword
	public void openBrowser(){
		WebUI.openBrowser(GlobalVariable.Site_Inspect_URL)
		WebUI.maximizeWindow()
		WebUI.waitForPageLoad(GlobalVariable.waitForPageLoad)
		//WebUI.deleteAllCookies()
	}

	// Admin log into Browser
	@Keyword
	public void logIntoBrowser(){

		WebUI.sendKeys(findTestObject('Object Repository/LoginAndRigisterUser/UserName_Email_Input'), GlobalVariable.AdminUserName)
		WebUI.sendKeys(findTestObject('Object Repository/LoginAndRigisterUser/Password_Input'), GlobalVariable.AdminPassWord)
		WebUI.delay(1)
		WebUI.waitForElementClickable(LoginBtn, GlobalVariable.TimeOut)
		clickElementWithJS(LoginBtn)
	}


	//Customised user log into Browser
	@Keyword
	public void logIntoBrowserWithReqCredentials(String username,String password){

		WebUI.sendKeys(findTestObject('Object Repository/LoginAndRigisterUser/UserName_Email_Input'), username)
		WebUI.sendKeys(findTestObject('Object Repository/LoginAndRigisterUser/Password_Input'), password)
		WebUI.delay(1)
		WebUI.waitForElementClickable(LoginBtn, GlobalVariable.TimeOut)
		clickElementWithJS(LoginBtn)
	}

	@Keyword
	public void otpLogin(){

		int i = 0
		String num = i.toString()

		WebUI.sendKeys(findTestObject('Object Repository/LoginAndRigisterUser/otpOne'), num)
		WebUI.sendKeys(findTestObject('Object Repository/LoginAndRigisterUser/otpTwo'), num)
		WebUI.sendKeys(findTestObject('Object Repository/LoginAndRigisterUser/otpThree'), num)
		WebUI.sendKeys(findTestObject('Object Repository/LoginAndRigisterUser/otpFour'), num)
		WebUI.sendKeys(findTestObject('Object Repository/LoginAndRigisterUser/otpFive'), num)

		clickElementWithJS(otpSubmitBtn)

		//WebUI.click(findTestObject('Object Repository/LoginAndRigisterUser/otpSubmitBtn'))
	}



	@Keyword
	public void otpRigistration(){

		int i = 0
		String num = i.toString()

		WebUI.sendKeys(findTestObject('Object Repository/LoginAndRigisterUser/otpOne'), num)
		WebUI.sendKeys(findTestObject('Object Repository/LoginAndRigisterUser/otpTwo'), num)
		WebUI.sendKeys(findTestObject('Object Repository/LoginAndRigisterUser/otpThree'), num)
		WebUI.sendKeys(findTestObject('Object Repository/LoginAndRigisterUser/otpFour'), num)
		WebUI.sendKeys(findTestObject('Object Repository/LoginAndRigisterUser/otpFive'), num)

		clickElementWithJS(Reg_otpSubmitBtn)

		//WebUI.click(findTestObject('Object Repository/LoginAndRigisterUser/otpSubmitBtn'))
	}

	@Keyword
	public void passWordFieldAndClickOnLogin(String password){

		WebUI.sendKeys(findTestObject('Object Repository/LoginECM/PasswordField'), password)
		WebUI.scrollToElement(findTestObject('Object Repository/LoginECM/LogInBtn'), GlobalVariable.TimeOut)
		WebUI.click(findTestObject('Object Repository/LoginECM/LogInBtn'))
	}

	@Keyword
	public void homeLogOutBrowser(){
		WebUI.switchToDefaultContent()
		//WebUI.switchToWindowIndex(0)
		WebUI.click(findTestObject('Object Repository/LoginAndRigisterUser/Logout'))
	}

	@Keyword
	public void homeLogOutAndcloseBrowser(){
		WebUI.switchToDefaultContent()
		//WebUI.switchToWindowIndex(0)
		WebUI.click(findTestObject('Object Repository/LoginECM/LogOutBtn'))
		WebUI.closeBrowser()
	}

	@Keyword
	public void logOutBrowser(){
		WebUI.switchToDefaultContent()
		//WebUI.switchToWindowIndex(0)
		WebUI.waitForElementClickable(findTestObject('Object Repository/LoginAndRigisterUser/AdminDD'), GlobalVariable.TimeOut)
		clickElementWithJS(adminDD)
		clickElementWithJS(logOut)
	}

	@Keyword
	public void logOutBrowser_AR(){
		WebUI.switchToDefaultContent()
		//WebUI.switchToWindowIndex(0)
		WebUI.waitForElementClickable(findTestObject('Object Repository/LoginAndRigisterUser/AdminDD'), GlobalVariable.TimeOut)
		clickElementWithJS(adminDD)
		clickElementWithJS(AR_logOut)
	}


	@Keyword
	public void logOutAndcloseBrowser(){
		WebUI.switchToDefaultContent()
		//WebUI.switchToWindowIndex(0)
		WebUI.waitForElementClickable(findTestObject('Object Repository/LoginAndRigisterUser/AdminDD'), GlobalVariable.TimeOut)
		clickElementWithJS(adminDD)
		clickElementWithJS(logOut)
		WebUI.delay(1)
		WebUI.closeBrowser()
	}


	@Keyword
	public void logOutAndcloseBrowser_AR(){
		WebUI.switchToDefaultContent()
		//WebUI.switchToWindowIndex(0)
		WebUI.waitForElementClickable(findTestObject('Object Repository/LoginAndRigisterUser/AdminDD'), GlobalVariable.TimeOut)
		clickElementWithJS(adminDD)
		clickElementWithJS(AR_logOut)
		WebUI.delay(1)
		WebUI.closeBrowser()
	}

	@Keyword
	public void onlyCloseBrowser(){

		WebUI.closeBrowser()
	}





	/**
	 * Refresh browser
	 */
	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def clickElement(TestObject to) {
		try {
			WebElement element = WebUI.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	@Keyword
	public void clickElementWithJS(TestObject element) {
		try {

			WebDriver webDriver = DriverFactory.getWebDriver()
			WebElement elementObject = WebUI.findWebElement(element)

			//((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementObject)
			((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", elementObject)

			KeywordUtil.logInfo("Clicked on element with JS")
		} catch (Exception e) {
			KeywordUtil.logInfo("Exception while clicking on element with JS" + e.getMessage())
		}
	}



	/**
	 * To Upload Image using Robot class
	 *
	 * @param obj
	 * @param objName
	 * @param key
	 */
	@Keyword
	public void uploadImage(String key) {
		try {

			// put path to your image in a clipboard
			StringSelection ss = new StringSelection(key);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

			// imitate mouse events like ENTER, CTRL+C, CTRL+V
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			KeywordUtil.logInfo("Image Uploaded Sucsessfully")
		} catch (Exception e) {
			KeywordUtil.markFailed("Exception while Uploading Image")
		}
	}

	@Keyword
	public void UploadReqFile(String fileNameExte, String existedFileName) {

		WebUI.click(findTestObject('Object Repository/HomePage/ChooseAFile'))

		WebUI.delay(2)

		File content = new File(System.getProperty("user.dir")+"\\Project_ReqFiles\\Test_Files\\"+fileNameExte);
		String avatar = content.toString()
		System.out.println(content)

		uploadImage(avatar)

		WebUI.delay(2)

		//Verify the attached file is exist in the application
		WebUI.verifyTextPresent(existedFileName, false)

	}



	@Keyword
	public String getParticularCellText(By obj) {

		WebDriver webDriver = DriverFactory.getWebDriver()
		List<WebElement> cellData = webDriver.findElements(obj)

		for (WebElement textData : cellData) {

			//System.out.println("------>"+textData.getText())
			String cellText = textData.getText()
			//WebUI.verifyTextPresent(firstRowFirstColData, false)

			return cellText
		}


	}




	@Keyword
	public void PastRequiredStr(String key) {

		// put path to your image in a clipboard
		StringSelection ss = new StringSelection(key);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// imitate mouse events like ENTER, CTRL+C, CTRL+V
		Robot robot = new Robot();

		//Past
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}





	/**
	 * To validate element is Enabled
	 * Element enabled
	 * @param to Katalon test object
	 */
	@Keyword
	def elementIsEnabled(TestObject to) {
		try {
			WebElement element = WebUI.findWebElement(to);
			KeywordUtil.logInfo("Finding element is enabled")


			if(element.isEnabled()){

				KeywordUtil.markPassed("Element is Enabled")

			}else{

				KeywordUtil.markFailed("Element has been disabled")
			}

		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to find an element enabled or not")
		}
	}

	/**
	 * To validate element is disabled
	 * 
	 * Element is disabled
	 * @param to Katalon test object
	 */
	@Keyword
	def elementIsDisabled(TestObject to) {
		try {
			WebElement element = WebUI.findWebElement(to);
			KeywordUtil.logInfo("Finding element is disabled")
			//element.enabled

			if(element.isEnabled()){

				KeywordUtil.markFailed("Element is Enabled")

			}else{

				KeywordUtil.markPassed("Element has been disabled")
			}

		} catch (WebElementNotFoundException e) {

			KeywordUtil.markFailed("Element not found")

		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to find an element disabled or not")
		}
	}

	/**
	 * To verify element is present on the page and return boolean
	 *
	 * @param obj
	 * @param elementName
	 * @return
	 */
	public boolean elementIsPresent(By obj) {

		int size = 0;
		try {

			WebDriver webDriver = DriverFactory.getWebDriver()
			size = webDriver.findElements(obj).size()

			System.out.print( size + "------------------------");

			KeywordUtil.logInfo("Element size " + size);

		} catch (Exception e) {

			KeywordUtil.markError("Exception while locating element" + e.getMessage());
		}

		return (size > 0) ? true : false;
	}

	@Keyword
	public boolean elementIsPresentOrNot(TestObject obj) {

		boolean result = false
		try {
			WebElement element = WebUI.findWebElement(obj)

			KeywordUtil.logInfo("Element is exist ")
			result = true
		} catch (Exception e) {

			result = false
			KeywordUtil.logInfo("Element is not exist ")

		}

		return result
	}



	/**
	 * Multiple windowHandle
	 *
	 * @param Index
	 */
	@Keyword
	public void windowHandle(int Index) {
		try {

			//Thread.sleep(15000);

			//WebElement element = WebUI.findWebElement(obj)
			WebDriver webDriver = DriverFactory.getWebDriver()
			Set<String> setOfWindows = webDriver.getWindowHandles();
			Object[] window = (setOfWindows.toArray());
			webDriver.switchTo().window((String) window[Index]);

			KeywordUtil.logInfo("Switched require window")
			//log(LogType.INFO, "Switched require window");
		} catch (Exception e) {

			KeywordUtil.markError("Exception while Switching to require window" + e.getMessage())

			//log(LogType.ERROR, "Exception while Switching to require window");
		}
	}

	//	WebDriver webDriver = DriverFactory.getWebDriver()



	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject  table , String outerTagName) {
		WebElement mailList = WebUI.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}


	@Keyword
	public boolean iterateTableAndValidateOrganization(By locator, String text) {


		WebDriver webDriver = DriverFactory.getWebDriver()
		List<WebElement> AllData = webDriver.findElements(locator)
		println(AllData.size())

		for (WebElement e : AllData) {
			System.out.println("------>"+e.getText())

			if(e.getText().equals(text)){

				KeywordUtil.logInfo("[-------- Created organization is exist in the list ------] ")

				//return true
				return true
				//break

			}
		}
	}

	@Keyword
	public boolean iterateTableAndValidate(By locator, String text) {

		WebDriver webDriver = DriverFactory.getWebDriver()
		List<WebElement> AllData = webDriver.findElements(locator)
		println(AllData.size())

		for (WebElement e : AllData) {
			System.out.println("------>"+e.getText())

			if(e.getText().equals(text)){

				KeywordUtil.logInfo("[-------- Created organization is exist in the list ------] ")

				break
			}

		}
	}

	@Keyword
	public void iterateTableRowAndgetTextAndValidate(By locator, String text) {

		try {

			WebDriver webDriver = DriverFactory.getWebDriver()
			List<WebElement> tablesize = webDriver.findElements(locator)

			for (WebElement webElement : tablesize) {

				String actual = webElement.findElement(By.xpath(".//td[1]")).getText();

				if (actual.equals(text)) {

					KeywordUtil.logInfo("Validated Created organization name is : " + actual + " is present in the Table")

					break;
				}
			}

		} catch (Exception e) {

			KeywordUtil.markError("Exception while validate crated organization")

		}
	}


	@Keyword
	public List<WebElement> getDropDownValues(TestObject  dd,TestObject  ddoptions ) {

		WebElement mailList = WebUI.findWebElement(dd)
		List<WebElement> tablerows = mailList.findElements(ddoptions)

		for (int i = 0; i < tablerows.size(); i++) {
			System.out.println(tablerows.size());

			WebElement row = tablerows.get(i);

			System.out.println(row.getText());

			return tablerows

		}
	}

	@Keyword
	public String getRandomAlphaString(int siz) {
		//String SALTCHARS = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
		String SALTCHARS = 'abcdefghijklmnopqrstuvwxyz';
		StringBuilder builder = new StringBuilder();
		Random ran = new Random();
		while (builder.length()< siz) {
			int index = (int)(ran.nextFloat()*SALTCHARS.length());
			builder.append(SALTCHARS.charAt(index));
		}
		String saltStr = builder.toString();

		return saltStr
	}


	@Keyword
	public int getRandomNumbers() {
		// create instance of Random class

		Random r = new Random();
		int low = 10000;
		int high = 99999;
		int rand_int = r.nextInt(high-low) + low;

		return rand_int;
	}


	@Keyword
	public String uppCaseString(String LowerString) {

		String S1 = new String(LowerString)
		//Convert to UpperCase
		System.out.println(S1.toUpperCase())
		String uppString = S1.toUpperCase()

		return uppString
	}

	@Keyword
	public boolean VerifyListIsPresent(String iterate) {

		//TestObject ADBListXpath = getADBListTestObject(iterate)

		TestObject ADBListXpath

		boolean string = elementIsPresentOrNot(ADBListXpath)

		return string
	}




	@Keyword
	public void uploadFileAndNavToSubmissionPage(int NumOne, int NumTwo) {

		String fileNameWithExten = excelTestData.getValue(2, NumOne)

		String existedFileName = excelTestData.getValue(3, NumTwo)

		UploadReqFile(fileNameWithExten, existedFileName)

		WebUI.click(findTestObject('Object Repository/HomePage/Window10RadioBtn'))

		WebUI.click(findTestObject('Object Repository/HomePage/startAnalysis_EnableBtn'))

		WebUI.waitForElementVisible(findTestObject('Object Repository/SubmissionPage/Submission_SearchIcon'), GlobalVariable.TimeOut)

		WebUI.verifyElementVisible(findTestObject('Object Repository/SubmissionPage/Submission_SearchIcon'))

	}



	@Keyword
	public void uploadFileOfPublicUser(int NumOne, String userEmail) {

		openBrowser()

		String fileNameWithExten = excelTestData.getValue(2, NumOne)

		String existedFileName = excelTestData.getValue(3, NumOne)

		UploadReqFile(fileNameWithExten, existedFileName)

		WebUI.sendKeys(findTestObject('Object Repository/PublicUserHomePage/email_Input'), userEmail)

		WebUI.click(findTestObject('Object Repository/PublicUserHomePage/SiteInspectTermsOfUse_CheckBox'))

		WebUI.click(findTestObject('Object Repository/HomePage/startAnalysis_EnableBtn'))

		//Take latest data because privious did not taken because of bug for uploading file

		String SubmissionValidationMessage  = excelTestData.getValue(3, 87)

		WebUI.verifyTextPresent(SubmissionValidationMessage, false)

		//WebUI.click(findTestObject('Object Repository/PublicUserHomePage/OKPopUpBtn'))

	}




	@Keyword
	public void enterURLOfPublicUser(String sampleURL, String userEmail) {

		openBrowser()

		WebUI.click(findTestObject('Object Repository/PublicUserHomePage/UrlTab'))

		WebUI.sendKeys(findTestObject('Object Repository/HomePage/PleaseEnterURL_Input'), sampleURL)

		WebUI.sendKeys(findTestObject('Object Repository/PublicUserHomePage/email_Input'), userEmail)

		WebUI.click(findTestObject('Object Repository/PublicUserHomePage/SiteInspectTermsOfUse_CheckBox'))

		elementIsEnabled(analysisBtn_Enabled)

		WebUI.click(findTestObject('Object Repository/HomePage/startAnalysis_EnableBtn'))

		String SubmissionValidationMessage   = excelTestData.getValue(3, 156)

		WebUI.waitForElementPresent(findTestObject('Object Repository/PublicUserHomePage/OKPopUpBtn'), GlobalVariable.TimeOut)

		WebUI.verifyTextPresent(SubmissionValidationMessage, false)

		WebUI.click(findTestObject('Object Repository/PublicUserHomePage/OKPopUpBtn'))

	}


	
	@Keyword
	public void enterURLOfRegisterUser(String sampleURL, String rigisterUN, String rigisterPW) {

		openBrowser()

		WebUI.waitForElementClickable(findTestObject('LoginAndRigisterUser/LoginLink'), GlobalVariable.TimeOut)
		
		clickElementWithJS(LoginLink)
		
		logIntoBrowserWithReqCredentials(rigisterUN, rigisterPW)
		
		otpLogin()
		
		WebUI.click(findTestObject('Object Repository/HomePage/URL_Tab'))
		
		WebUI.sendKeys(findTestObject('Object Repository/HomePage/PleaseEnterURL_Input'), sampleURL)
		
		WebUI.click(findTestObject('Object Repository/HomePage/Window10RadioBtn'))
		
		WebUI.click(findTestObject('Object Repository/HomePage/startAnalysis_EnableBtn'))
		
		String SubmissionValidationMessage = excelTestData.getValue(5, 23)
		
		WebUI.verifyTextPresent(SubmissionValidationMessage, false)
		
		WebUI.waitForElementVisible(findTestObject('Object Repository/SubmissionPage/Submission_SearchIcon'), GlobalVariable.TimeOut)
		
		WebUI.verifyElementVisible(findTestObject('Object Repository/SubmissionPage/Submission_SearchIcon'))
		
				String partCellText = getParticularCellText(objColOne)
				System.out.println("Given URL cell text from Submission page ------>"+partCellText)
		
				WebUI.verifyEqual(sampleURL, partCellText)
		
	}
	
	

	@Keyword
	public void uploadFileOfRegisterUser(int NumOne, String rigisterUN, String rigisterPW) {

		openBrowser()

		WebUI.waitForElementClickable(findTestObject('LoginAndRigisterUser/LoginLink'), GlobalVariable.TimeOut)

		clickElementWithJS(LoginLink)

		logIntoBrowserWithReqCredentials(rigisterUN, rigisterPW)

		otpLogin()

		String fileNameWithExten = excelTestData.getValue(2, NumOne)

		String existedFileName = excelTestData.getValue(3, NumOne)

		UploadReqFile(fileNameWithExten, existedFileName)

		WebUI.click(findTestObject('Object Repository/HomePage/Window7RadioBtn'))

		WebUI.scrollToElement(findTestObject('Object Repository/HomePage/startAnalysis_EnableBtn'), GlobalVariable.TimeOut)

		WebUI.click(findTestObject('Object Repository/HomePage/startAnalysis_EnableBtn'))

		WebUI.waitForElementVisible(findTestObject('Object Repository/SubmissionPage/Submission_SearchIcon'), GlobalVariable.TimeOut)

		WebUI.verifyElementVisible(findTestObject('Object Repository/SubmissionPage/Submission_SearchIcon'))

		String partCellText = getParticularCellText(objColOne)
		System.out.println("Uploaded file cell text from Submission page ------>"+partCellText)

		WebUI.verifyEqual(fileNameWithExten, partCellText)

	}


	private String getOtpXpath(String num) {

		return "//input[@id='otp"+ num +"']"

	}

	private TestObject getOtpTestObject(String listNo) {

		TestObject ADBListXpath = new TestObject(listNo);
		ADBListXpath.addProperty("xpath", ConditionType.EQUALS, getOtpXpath(listNo), true);
		return ADBListXpath

	}


	private String getIterateCellXpath(String iterate) {

		return "	//table/tbody/tr[" + iterate +"]/td[1]"

	}

	private TestObject getIterateCellXpathTestObject(String iterate) {

		TestObject IterateCellXpath = new TestObject(iterate);
		IterateCellXpath.addProperty("xpath", ConditionType.EQUALS, getIterateCellXpath(iterate), true);
		return IterateCellXpath

	}

}

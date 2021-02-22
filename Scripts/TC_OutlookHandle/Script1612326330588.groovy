import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable



WebUI.callTestCase(findTestCase('TC_Login_RegisterUserAndForgotYourPassword/CommanTCs/TC_LoginToBrowserAsAdmin'), null)


WebUI.navigateToUrl('https://mail.projects.site.sa/')

//WebUI.openBrowser('https://mail.projects.site.sa/')
WebUI.maximizeWindow()
WebUI.click(findTestObject("Object Repository/OutLook/AdvancedBtn"))
WebUI.click(findTestObject("Object Repository/OutLook/ProceedLink"))

WebUI.sendKeys(findTestObject('Object Repository/OutLook/UserName_Input'), 'SiteODC/os-arahman')
WebUI.sendKeys(findTestObject('Object Repository/OutLook/Password_Input'), 'Soudi@2020')

WebUI.click(findTestObject("Object Repository/OutLook/signInBtn"))

WebUI.waitForElementVisible(findTestObject("Object Repository/OutLook/InboxTab"), GlobalVariable.TimeOut)

WebUI.click(findTestObject("Object Repository/OutLook/InboxTab"))

WebUI.click(findTestObject("Object Repository/OutLook/firstEmail"))

WebUI.delay(10)

WebUI.verifyTextPresent('Verification Code', false)

WebUI.verifyTextPresent('Hello Ashok Abdul', false)

WebUI.verifyTextPresent('Please use the following code to verify your identity:00000', false)
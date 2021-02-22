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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

TestData excelTestData = findTestData('Data Files/TestData/InspectTestData_AR')

TestObject obj = findTestObject('Object Repository/AR_LoginAndRigisterUser/LoginLink')

TestObject RigisterBtn = findTestObject('Object Repository/LoginAndRigisterUser/RegisterBtn')

TestObject CheckBoxTermsAndCondition = findTestObject('Object Repository/LoginAndRigisterUser/Reg_SiteInspectTermsOfUse_CheckBox')

TestObject rigisterHereLink = findTestObject('Object Repository/LoginAndRigisterUser/RigisterHere')

CustomKeywords.'customKeywords.commanFunctions.openBrowser'()

WebUI.click(findTestObject('Object Repository/HomePage/Arabic_Tab'))

WebUI.waitForElementClickable(findTestObject('Object Repository/AR_LoginAndRigisterUser/LoginLink'), GlobalVariable.TimeOut)

CustomKeywords.'customKeywords.commanFunctions.clickElementWithJS'(obj)

CustomKeywords.'customKeywords.commanFunctions.clickElementWithJS'(rigisterHereLink)

String firstName = excelTestData.getValue(2, 16)
String lastName  = excelTestData.getValue(3, 16)
String mobileNum = excelTestData.getValue(4, 16)
String email = excelTestData.getValue(5, 16)

String validationMessage = excelTestData.getValue(6, 16)
String ClickHereToResendLink = excelTestData.getValue(7, 16)

WebUI.sendKeys(findTestObject('Object Repository/LoginAndRigisterUser/FirstName_Input'), firstName)

WebUI.sendKeys(findTestObject('Object Repository/LoginAndRigisterUser/LastName_Input'), lastName)

int RandomNum = CustomKeywords.'customKeywords.commanFunctions.getRandomNumbers'()

String mobileNumber = '0' + mobileNum + RandomNum

WebUI.sendKeys(findTestObject('Object Repository/LoginAndRigisterUser/MobileNumber_Input'), mobileNumber)

String str = CustomKeywords.'customKeywords.commanFunctions.getRandomAlphaString'(4)
  
String emailID = 'test_'+ str + '@email.com'

WebUI.sendKeys(findTestObject('Object Repository/LoginAndRigisterUser/Reg_Email_Input'), emailID)

WebUI.sendKeys(findTestObject('Object Repository/LoginAndRigisterUser/ReEnter_Email_Input'), emailID)

CustomKeywords.'customKeywords.commanFunctions.clickElementWithJS'(CheckBoxTermsAndCondition)

CustomKeywords.'customKeywords.commanFunctions.clickElementWithJS'(RigisterBtn)

CustomKeywords.'customKeywords.commanFunctions.otpRigistration'()

WebUI.verifyTextPresent(validationMessage, false)

WebUI.verifyTextPresent(ClickHereToResendLink, false)

WebUI.delay(2)



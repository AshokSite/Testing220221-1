import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.TearDownIfError
import com.kms.katalon.core.annotation.TearDownIfFailed
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

TestData excelTestData = findTestData('Data Files/TestData/InspectTestData_AR')

TestObject clickHereToResendEmai = findTestObject('Object Repository/LoginAndRigisterUser/clickHereToResendEmai')

String ClickHereToResendLinkValidationMessage = excelTestData.getValue(2, 19)

WebUI.callTestCase(findTestCase('TC_Login_RegisterUserAndForgotYourPassword_Arabic/CommanTCs/TC_RigisterUserWithValidTestDataAndVerify'), null)

CustomKeywords.'customKeywords.commanFunctions.clickElementWithJS'(clickHereToResendEmai)

WebUI.verifyTextPresent(ClickHereToResendLinkValidationMessage, false)

CustomKeywords.'customKeywords.commanFunctions.onlyCloseBrowser'()



@TearDownIfFailed
void tearDownMethodIfFailed(){
	
	CustomKeywords.'customKeywords.commanFunctions.onlyCloseBrowser'()
	KeywordUtil.logInfo("[--------This is tearDownIfFailed method------]")
}

@TearDownIfError
void tearDownMethodIfError(){
	
	CustomKeywords.'customKeywords.commanFunctions.onlyCloseBrowser'()
	KeywordUtil.logInfo("[--------This is tearDownIfError method------]")
}
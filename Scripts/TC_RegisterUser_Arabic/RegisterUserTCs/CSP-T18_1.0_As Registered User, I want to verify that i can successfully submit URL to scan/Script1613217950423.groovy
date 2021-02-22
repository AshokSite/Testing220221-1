import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.TearDownIfError
import com.kms.katalon.core.annotation.TearDownIfFailed
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

//WebUI.callTestCase(findTestCase('TC_Login_RegisterUserAndForgotYourPassword/CommanTCs/TC_LoginToBrowserAsAdmin'), null)

TestData excelTestData = findTestData('Data Files/TestData/InspectTestData')

TestObject obj = findTestObject('LoginAndRigisterUser/LoginLink')

CustomKeywords.'customKeywords.commanFunctions.openBrowser'()

WebUI.waitForElementClickable(findTestObject('LoginAndRigisterUser/LoginLink'), GlobalVariable.TimeOut)

CustomKeywords.'customKeywords.commanFunctions.clickElementWithJS'(obj)

String rigisterUN = excelTestData.getValue(2, 23)

String rigisterPW  = excelTestData.getValue(3, 23)

CustomKeywords.'customKeywords.commanFunctions.logIntoBrowserWithReqCredentials'(rigisterUN, rigisterPW)

CustomKeywords.'customKeywords.commanFunctions.otpLogin'()

WebUI.click(findTestObject('Object Repository/HomePage/URL_Tab'))

String sampleURL  = excelTestData.getValue(4, 23)

WebUI.sendKeys(findTestObject('Object Repository/HomePage/PleaseEnterURL_Input'), sampleURL)

WebUI.click(findTestObject('Object Repository/HomePage/Window10RadioBtn'))

WebUI.click(findTestObject('Object Repository/HomePage/startAnalysis_EnableBtn'))

//String SubmissionValidationMessage = excelTestData.getValue(5, 23)

//WebUI.verifyTextPresent(SubmissionValidationMessage, false)

WebUI.waitForElementVisible(findTestObject('Object Repository/SubmissionPage/Submission_SearchIcon'), GlobalVariable.TimeOut)

WebUI.verifyElementVisible(findTestObject('Object Repository/SubmissionPage/Submission_SearchIcon'))

CustomKeywords.'customKeywords.commanFunctions.logOutAndcloseBrowser'()


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

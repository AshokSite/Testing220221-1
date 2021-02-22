import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.TearDownIfError
import com.kms.katalon.core.annotation.TearDownIfFailed
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

TestData excelTestData = findTestData('Data Files/TestData/InspectTestData')

TestObject obj = findTestObject('LoginAndRigisterUser/LoginLink')

TestObject saveBtn = findTestObject('Object Repository/Admin_Settings/SaveBtn')

CustomKeywords.'customKeywords.commanFunctions.openBrowser'()

WebUI.waitForElementClickable(findTestObject('LoginAndRigisterUser/LoginLink'), GlobalVariable.TimeOut)

CustomKeywords.'customKeywords.commanFunctions.clickElementWithJS'(obj)

CustomKeywords.'customKeywords.commanFunctions.logIntoBrowser'()

CustomKeywords.'customKeywords.commanFunctions.otpLogin'()

WebUI.click(findTestObject('Object Repository/AdminHomePage/Setting_Tab'))

String MaxFileSize = excelTestData.getValue(4, 99)

WebUI.clearText(findTestObject('Object Repository/Admin_Settings/MaxFileSize_Input'))

WebUI.sendKeys(findTestObject('Object Repository/Admin_Settings/MaxFileSize_Input'), MaxFileSize)

CustomKeywords.'customKeywords.commanFunctions.clickElementWithJS'(saveBtn)

CustomKeywords.'customKeywords.commanFunctions.logOutBrowser'()





WebUI.waitForElementClickable(findTestObject('LoginAndRigisterUser/LoginLink'), GlobalVariable.TimeOut)


String fileNameWithExten = excelTestData.getValue(2, 99)

String existedFileName = excelTestData.getValue(3, 99)

CustomKeywords.'customKeywords.commanFunctions.UploadReqFile'(fileNameWithExten, existedFileName)

String userEmail  = excelTestData.getValue(6, 23)

WebUI.sendKeys(findTestObject('Object Repository/PublicUserHomePage/email_Input'), userEmail)

WebUI.click(findTestObject('Object Repository/PublicUserHomePage/SiteInspectTermsOfUse_CheckBox'))

WebUI.click(findTestObject('Object Repository/HomePage/startAnalysis_EnableBtn'))

String SubmissionValidationMessage  = excelTestData.getValue(5, 99)

WebUI.verifyTextPresent(SubmissionValidationMessage, false)

WebUI.click(findTestObject('Object Repository/PublicUserHomePage/OKPopUpBtn'))

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



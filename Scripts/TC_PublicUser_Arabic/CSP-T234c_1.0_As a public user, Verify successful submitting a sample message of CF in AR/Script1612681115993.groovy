import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.TearDownIfError
import com.kms.katalon.core.annotation.TearDownIfFailed
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

TestData excelTestData = findTestData('Data Files/TestData/InspectTestData_AR')

CustomKeywords.'customKeywords.commanFunctions.openBrowser'()

WebUI.click(findTestObject('Object Repository/HomePage/Arabic_Tab'))

String fileNameWithExten = excelTestData.getValue(2, 31)

String existedFileName = excelTestData.getValue(3, 31)

CustomKeywords.'customKeywords.commanFunctions.UploadReqFile'(fileNameWithExten, existedFileName)

//WebUI.click(findTestObject('Object Repository/HomePage/Window10RadioBtn'))

String userEmail  = excelTestData.getValue(4, 23)

WebUI.sendKeys(findTestObject('Object Repository/AR_PublicUserHomePage/email_Input'), userEmail)

WebUI.click(findTestObject('Object Repository/AR_PublicUserHomePage/SiteInspectTermsOfUse_CheckBox'))

WebUI.click(findTestObject('Object Repository/HomePage/startAnalysis_EnableBtn'))

// Take latest data because privious did not taken because of bug for uploading file

String SubmissionValidationMessage  = excelTestData.getValue(4, 31)

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
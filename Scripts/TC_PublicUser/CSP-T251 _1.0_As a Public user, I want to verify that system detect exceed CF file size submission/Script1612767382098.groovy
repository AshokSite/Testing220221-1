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

CustomKeywords.'customKeywords.commanFunctions.openBrowser'()


String fileNameWithExten = excelTestData.getValue(2, 119)

String existedFileName = excelTestData.getValue(3, 119)

CustomKeywords.'customKeywords.commanFunctions.UploadReqFile'(fileNameWithExten, existedFileName)

String userEmail  = excelTestData.getValue(6, 23)

WebUI.sendKeys(findTestObject('Object Repository/PublicUserHomePage/email_Input'), userEmail)

WebUI.click(findTestObject('Object Repository/PublicUserHomePage/SiteInspectTermsOfUse_CheckBox'))

WebUI.click(findTestObject('Object Repository/HomePage/startAnalysis_EnableBtn'))

String ErrorPopUp   = excelTestData.getValue(4, 119)

WebUI.verifyTextPresent(ErrorPopUp, false)

//WebUI.click(findTestObject('Object Repository/PublicUserHomePage/OKPopUpBtn'))

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



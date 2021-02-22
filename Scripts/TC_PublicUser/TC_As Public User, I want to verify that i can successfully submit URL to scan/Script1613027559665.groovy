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

TestObject analysisBtn_Enabled = findTestObject('Object Repository/PublicUserHomePage/enabledAnalysisBtn')

CustomKeywords.'customKeywords.commanFunctions.openBrowser'()

WebUI.click(findTestObject('Object Repository/PublicUserHomePage/UrlTab'))

String sampleURL  = excelTestData.getValue(2, 156)

WebUI.sendKeys(findTestObject('Object Repository/HomePage/PleaseEnterURL_Input'), sampleURL)

String userEmail  = excelTestData.getValue(6, 23)

WebUI.sendKeys(findTestObject('Object Repository/PublicUserHomePage/email_Input'), userEmail)

WebUI.click(findTestObject('Object Repository/PublicUserHomePage/SiteInspectTermsOfUse_CheckBox'))

CustomKeywords.'customKeywords.commanFunctions.elementIsEnabled'(analysisBtn_Enabled)

WebUI.click(findTestObject('Object Repository/HomePage/startAnalysis_EnableBtn'))

String SubmissionValidationMessage   = excelTestData.getValue(3, 156)

WebUI.waitForElementPresent(findTestObject('Object Repository/PublicUserHomePage/OKPopUpBtn'), GlobalVariable.TimeOut)

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

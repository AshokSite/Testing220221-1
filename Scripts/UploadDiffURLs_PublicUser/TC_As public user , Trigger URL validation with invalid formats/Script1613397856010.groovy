import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.TearDownIfError
import com.kms.katalon.core.annotation.TearDownIfFailed
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'customKeywords.commanFunctions.openBrowser'()

TestData excelTestData = findTestData('Data Files/TestData/InspectTestData')

WebUI.click(findTestObject('Object Repository/PublicUserHomePage/UrlTab'))

String ErrorValidationMessage  = excelTestData.getValue(3, 42)

for (int i = 42; i <= 46; i++) {

String IncorrectURLs  = excelTestData.getValue(2, i)

WebUI.sendKeys(findTestObject('Object Repository/HomePage/PleaseEnterURL_Input'), IncorrectURLs)

WebUI.verifyTextPresent(ErrorValidationMessage, false)

WebUI.clearText(findTestObject('Object Repository/HomePage/PleaseEnterURL_Input'))

}

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
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.TearDownIfError
import com.kms.katalon.core.annotation.TearDownIfFailed
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

TestData excelTestData = findTestData('Data Files/TestData/InspectTestData')

String sampleURL  = excelTestData.getValue(2, 370)

String userEmail  = excelTestData.getValue(6, 23)

CustomKeywords.'customKeywords.commanFunctions.enterURLOfPublicUser'(sampleURL, userEmail)

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
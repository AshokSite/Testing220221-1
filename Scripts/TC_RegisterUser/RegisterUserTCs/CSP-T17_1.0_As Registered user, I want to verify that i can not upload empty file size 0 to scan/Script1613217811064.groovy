import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By

import com.kms.katalon.core.annotation.TearDownIfError
import com.kms.katalon.core.annotation.TearDownIfFailed
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

TestData excelTestData = findTestData('Data Files/TestData/InspectTestData')

TestObject obj = findTestObject('LoginAndRigisterUser/LoginLink')

By analysisBtn_Disabled = By.xpath("//*[@class='mt-5 ant-btn ant-btn-primary ant-btn-block disabled22']")

By searchSubmissionBtn = By.xpath("//*[@class='img-search']")

CustomKeywords.'customKeywords.commanFunctions.openBrowser'()

WebUI.waitForElementClickable(findTestObject('LoginAndRigisterUser/LoginLink'), GlobalVariable.TimeOut)

CustomKeywords.'customKeywords.commanFunctions.clickElementWithJS'(obj)

String rigisterUN = excelTestData.getValue(2, 23)

String rigisterPW  = excelTestData.getValue(3, 23)

CustomKeywords.'customKeywords.commanFunctions.logIntoBrowserWithReqCredentials'(rigisterUN, rigisterPW)

CustomKeywords.'customKeywords.commanFunctions.otpLogin'()

String fileNameWithExten = excelTestData.getValue(2, 34)

String existedFileName = excelTestData.getValue(3, 34)

CustomKeywords.'customKeywords.commanFunctions.UploadReqFile'(fileNameWithExten, existedFileName)

String SystemErrorMsg  = excelTestData.getValue(4, 34)

WebUI.click(findTestObject('Object Repository/HomePage/Window10RadioBtn'))

WebUI.scrollToElement(findTestObject('Object Repository/HomePage/startAnalysis_EnableBtn'), GlobalVariable.TimeOut)

WebUI.click(findTestObject('Object Repository/HomePage/startAnalysis_EnableBtn'))

WebUI.verifyTextPresent(SystemErrorMsg, false)

WebUI.delay(4)

WebUI.verifyTextNotPresent(existedFileName, false)

boolean str = CustomKeywords.'customKeywords.commanFunctions.elementIsPresent'(searchSubmissionBtn)

KeywordUtil.logInfo("[-------- Element is present ? ------] "+ str)

WebUI.verifyEqual(str, false)

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
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

WebUI.click(findTestObject('Object Repository/Admin_Settings/RigisterUser'))

String MaxFileSize = excelTestData.getValue(4, 131)

WebUI.clearText(findTestObject('Object Repository/Admin_Settings/MaxFileSize_Input'))

WebUI.sendKeys(findTestObject('Object Repository/Admin_Settings/MaxFileSize_Input'), MaxFileSize)


String MaxNumDailySub  = excelTestData.getValue(5, 131)

WebUI.clearText(findTestObject('Object Repository/Admin_Settings/MaxNumOfDailySubms'))

WebUI.sendKeys(findTestObject('Object Repository/Admin_Settings/MaxNumOfDailySubms'), MaxNumDailySub)


String MaxNumOfFilesAllowedPer_CF   = excelTestData.getValue(6, 131)

WebUI.clearText(findTestObject('Object Repository/Admin_Settings/MaxNumOfFilesAllowedPer_CF'))

WebUI.sendKeys(findTestObject('Object Repository/Admin_Settings/MaxNumOfFilesAllowedPer_CF'), MaxNumOfFilesAllowedPer_CF)


String MaxSubDuringAnalysis = excelTestData.getValue(7, 131)

WebUI.clearText(findTestObject('Object Repository/Admin_Settings/MaxSubDuringAnalysis'))

WebUI.sendKeys(findTestObject('Object Repository/Admin_Settings/MaxSubDuringAnalysis'), MaxSubDuringAnalysis)

CustomKeywords.'customKeywords.commanFunctions.clickElementWithJS'(saveBtn)

String SettingSuccMsg = excelTestData.getValue(8, 131)
WebUI.verifyTextPresent(SettingSuccMsg, false)

CustomKeywords.'customKeywords.commanFunctions.logOutBrowser'()


WebUI.waitForElementClickable(findTestObject('LoginAndRigisterUser/LoginLink'), GlobalVariable.TimeOut)

CustomKeywords.'customKeywords.commanFunctions.clickElementWithJS'(obj)

String rigisterUN = excelTestData.getValue(2, 23)

String rigisterPW  = excelTestData.getValue(3, 23)

CustomKeywords.'customKeywords.commanFunctions.logIntoBrowserWithReqCredentials'(rigisterUN, rigisterPW)

CustomKeywords.'customKeywords.commanFunctions.otpLogin'()


CustomKeywords.'customKeywords.commanFunctions.uploadFileAndNavToSubmissionPage'(131, 131)

WebUI.click(findTestObject('Object Repository/HomePage/InspectImgTab'))

CustomKeywords.'customKeywords.commanFunctions.uploadFileAndNavToSubmissionPage'(132, 132)

WebUI.click(findTestObject('Object Repository/HomePage/InspectImgTab'))

CustomKeywords.'customKeywords.commanFunctions.uploadFileAndNavToSubmissionPage'(132, 132)



WebUI.click(findTestObject('Object Repository/HomePage/startAnalysis_EnableBtn'))

String ErrorPopUpMsg = excelTestData.getValue(7, 123)

WebUI.verifyTextPresent(ErrorPopUpMsg, false)

WebUI.click(findTestObject('Object Repository/LoginAndRigisterUser/OKPopUpBtn'))

CustomKeywords.'customKeywords.commanFunctions.logOutBrowser'()



WebUI.waitForElementClickable(findTestObject('LoginAndRigisterUser/LoginLink'), GlobalVariable.TimeOut)

WebUI.click(findTestObject('LoginAndRigisterUser/LoginLink'))

CustomKeywords.'customKeywords.commanFunctions.logIntoBrowser'()

CustomKeywords.'customKeywords.commanFunctions.otpLogin'()

WebUI.click(findTestObject('Object Repository/AdminHomePage/Setting_Tab'))

WebUI.click(findTestObject('Object Repository/Admin_Settings/RigisterUser'))

String MaxNumOfFilesAllowedPer_CFTwo   = excelTestData.getValue(5, 131)

WebUI.clearText(findTestObject('Object Repository/Admin_Settings/MaxNumOfFilesAllowedPer_CF'))

WebUI.sendKeys(findTestObject('Object Repository/Admin_Settings/MaxNumOfFilesAllowedPer_CF'), MaxNumOfFilesAllowedPer_CFTwo)

CustomKeywords.'customKeywords.commanFunctions.clickElementWithJS'(saveBtn)

WebUI.verifyTextPresent(SettingSuccMsg, false)

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


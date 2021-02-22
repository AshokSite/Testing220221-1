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

By objColOne = By.xpath("//table/tbody/tr[1]/td[2]")
By objColTwo = By.xpath("//table/tbody/tr[2]/td[2]")
By objColThree = By.xpath("//table/tbody/tr[3]/td[2]")


CustomKeywords.'customKeywords.commanFunctions.openBrowser'()

WebUI.waitForElementClickable(findTestObject('LoginAndRigisterUser/LoginLink'), GlobalVariable.TimeOut)

CustomKeywords.'customKeywords.commanFunctions.clickElementWithJS'(obj)

String rigisterUN = excelTestData.getValue(2, 23)

String rigisterPW  = excelTestData.getValue(3, 23)

CustomKeywords.'customKeywords.commanFunctions.logIntoBrowserWithReqCredentials'(rigisterUN, rigisterPW)

CustomKeywords.'customKeywords.commanFunctions.otpLogin'()



//first time start Analysis URL for exact validation of Fun (because URL concatinating as unique URL)


WebUI.click(findTestObject('Object Repository/HomePage/URL_Tab'))

String urlOne  = excelTestData.getValue(4, 38)

String randomStrOne = CustomKeywords.'customKeywords.commanFunctions.getRandomAlphaString'(4)

String sampleURLOne = urlOne + randomStrOne + ".com"

WebUI.sendKeys(findTestObject('Object Repository/HomePage/PleaseEnterURL_Input'), sampleURLOne)

WebUI.click(findTestObject('Object Repository/HomePage/Window10RadioBtn'))

WebUI.click(findTestObject('Object Repository/HomePage/startAnalysis_EnableBtn'))

WebUI.waitForElementVisible(findTestObject('Object Repository/SubmissionPage/Submission_SearchIcon'), GlobalVariable.TimeOut)

WebUI.verifyElementVisible(findTestObject('Object Repository/SubmissionPage/Submission_SearchIcon'))

WebUI.click(findTestObject('Object Repository/HomePage/InspectImgTab'))










String fileNameWithExten = excelTestData.getValue(2, 38)
String existedFileName = excelTestData.getValue(3, 38)

CustomKeywords.'customKeywords.commanFunctions.UploadReqFile'(fileNameWithExten, existedFileName)

WebUI.click(findTestObject('Object Repository/HomePage/Window10RadioBtn'))

WebUI.click(findTestObject('Object Repository/HomePage/URL_Tab'))

String url  = excelTestData.getValue(4, 38)

String randomStr = CustomKeywords.'customKeywords.commanFunctions.getRandomAlphaString'(4)

String sampleURL = url + randomStr + ".com"

WebUI.sendKeys(findTestObject('Object Repository/HomePage/PleaseEnterURL_Input'), sampleURL)

WebUI.click(findTestObject('Object Repository/HomePage/Window10RadioBtn'))

WebUI.click(findTestObject('Object Repository/HomePage/startAnalysis_EnableBtn'))

WebUI.waitForElementVisible(findTestObject('Object Repository/SubmissionPage/Submission_SearchIcon'), GlobalVariable.TimeOut)

WebUI.verifyElementVisible(findTestObject('Object Repository/SubmissionPage/Submission_SearchIcon'))


String partCellText = CustomKeywords.'customKeywords.commanFunctions.getParticularCellText'(objColOne)
System.out.println("----------------->"+partCellText)


String partCellTextTwo = CustomKeywords.'customKeywords.commanFunctions.getParticularCellText'(objColTwo)
System.out.println("----------------->"+partCellTextTwo)


//Validate analysis File and URL's 

WebUI.verifyEqual(sampleURL, partCellText)

WebUI.verifyEqual(sampleURLOne, partCellTextTwo)

WebUI.click(findTestObject('Object Repository/HomePage/InspectImgTab'))





WebUI.click(findTestObject('Object Repository/HomePage/File_Tab'))

CustomKeywords.'customKeywords.commanFunctions.UploadReqFile'(fileNameWithExten, existedFileName)

WebUI.click(findTestObject('Object Repository/HomePage/Window10RadioBtn'))

WebUI.click(findTestObject('Object Repository/HomePage/URL_Tab'))

//String urlTwo  = excelTestData.getValue(4, 38)

//String randomStrTwo = CustomKeywords.'customKeywords.commanFunctions.getRandomAlphaString'(4)

//String sampleURLTwo = urlTwo + randomStr + ".com"

WebUI.sendKeys(findTestObject('Object Repository/HomePage/PleaseEnterURL_Input'), sampleURL)

WebUI.click(findTestObject('Object Repository/HomePage/Window10RadioBtn'))

WebUI.click(findTestObject('Object Repository/HomePage/File_Tab'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/HomePage/startAnalysis_EnableBtn'))




WebUI.waitForElementVisible(findTestObject('Object Repository/SubmissionPage/Submission_SearchIcon'), GlobalVariable.TimeOut)

WebUI.verifyElementVisible(findTestObject('Object Repository/SubmissionPage/Submission_SearchIcon'))


String secondPartCellText = CustomKeywords.'customKeywords.commanFunctions.getParticularCellText'(objColOne)
System.out.println("----------------->"+secondPartCellText)


String secondPartCellTextTwo = CustomKeywords.'customKeywords.commanFunctions.getParticularCellText'(objColTwo)
System.out.println("----------------->"+secondPartCellTextTwo)



//Validate analysis File and URL's

WebUI.verifyEqual(fileNameWithExten, secondPartCellText)

WebUI.verifyEqual(sampleURL, secondPartCellTextTwo)


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


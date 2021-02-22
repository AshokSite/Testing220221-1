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

TestObject adminDD = findTestObject('Object Repository/LoginAndRigisterUser/AdminDD')

TestObject disabledSaveBtn = findTestObject('Object Repository/Reg_Account/SaveBtn')

By analysisBtn_Disabled = By.xpath("//*[@class='mt-5 ant-btn ant-btn-primary ant-btn-block disabled22']")

By searchSubmissionBtn = By.xpath("//*[@class='img-search']")

CustomKeywords.'customKeywords.commanFunctions.openBrowser'()

WebUI.waitForElementClickable(findTestObject('LoginAndRigisterUser/LoginLink'), GlobalVariable.TimeOut)

CustomKeywords.'customKeywords.commanFunctions.clickElementWithJS'(obj)

String rigisterUN = excelTestData.getValue(2, 23)

String rigisterPW  = excelTestData.getValue(3, 23)

CustomKeywords.'customKeywords.commanFunctions.logIntoBrowserWithReqCredentials'(rigisterUN, rigisterPW)

CustomKeywords.'customKeywords.commanFunctions.otpLogin'()

WebUI.waitForElementClickable(findTestObject('Object Repository/LoginAndRigisterUser/AdminDD'), GlobalVariable.TimeOut)

CustomKeywords.'customKeywords.commanFunctions.clickElementWithJS'(adminDD)

WebUI.click(findTestObject('Object Repository/HomePage/AccountInformationOption'))

WebUI.click(findTestObject('Object Repository/Reg_Account/changePwd'))

String CurrentPwd  = excelTestData.getValue(2, 75)

String NewPwd  = excelTestData.getValue(3, 75)

String ConfimPwd  = excelTestData.getValue(4, 75)

String PwdChangeErrorMsg  = excelTestData.getValue(5, 75)

WebUI.sendKeys(findTestObject('Object Repository/Reg_Account/CurrentPwd'), CurrentPwd)

WebUI.sendKeys(findTestObject('Object Repository/Reg_Account/NewPassword'), NewPwd)

WebUI.sendKeys(findTestObject('Object Repository/Reg_Account/ReEnterPwd'), ConfimPwd)

WebUI.verifyTextPresent(PwdChangeErrorMsg, false)

CustomKeywords.'customKeywords.commanFunctions.elementIsDisabled'(disabledSaveBtn)

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

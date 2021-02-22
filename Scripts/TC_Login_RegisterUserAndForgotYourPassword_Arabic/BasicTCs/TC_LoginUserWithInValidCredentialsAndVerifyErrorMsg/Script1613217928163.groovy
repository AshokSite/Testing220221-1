import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.TearDownIfError
import com.kms.katalon.core.annotation.TearDownIfFailed
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

TestData excelTestData = findTestData('Data Files/TestData/InspectTestData_AR')

String validationMessage = excelTestData.getValue(2, 4)

TestObject obj = findTestObject('Object Repository/AR_LoginAndRigisterUser/LoginLink')

TestObject LoginBtn = findTestObject('Object Repository/LoginAndRigisterUser/LoginBtn')

CustomKeywords.'customKeywords.commanFunctions.openBrowser'()

WebUI.click(findTestObject('Object Repository/HomePage/Arabic_Tab'))

WebUI.waitForElementClickable(findTestObject('Object Repository/AR_LoginAndRigisterUser/LoginLink'), GlobalVariable.TimeOut)

CustomKeywords.'customKeywords.commanFunctions.clickElementWithJS'(obj)

String strOne = CustomKeywords.'customKeywords.commanFunctions.getRandomAlphaString'(5)

String email = 'test_'+ strOne + '@email.com'

String str = CustomKeywords.'customKeywords.commanFunctions.getRandomAlphaString'(5)

String password = 'Test@'+ str

WebUI.sendKeys(findTestObject('Object Repository/LoginAndRigisterUser/UserName_Email_Input'), email)
WebUI.sendKeys(findTestObject('Object Repository/LoginAndRigisterUser/Password_Input'), password)

WebUI.waitForElementClickable(LoginBtn, GlobalVariable.TimeOut)

CustomKeywords.'customKeywords.commanFunctions.clickElementWithJS'(LoginBtn)

WebUI.verifyTextPresent(validationMessage, false)

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

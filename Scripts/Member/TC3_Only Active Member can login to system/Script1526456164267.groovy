import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Use custom keyword to random username, full name, email'
output_username = CustomKeywords.'newpackage.random_username.username'(random_username)

'Call Common TC to Login'
WebUI.callTestCase(findTestCase('Common TC/Common TC to Sign up'), [('fullname') : fullname, ('password') : password, ('input_username') : output_username], 
    FailureHandling.STOP_ON_FAILURE)

'Click on \'Log In\' menu ===> Brought to Log In page'
WebUI.click(findTestObject('Object_Login/a_Log in'))

'Log in with newly created user'
WebUI.setText(findTestObject('Object_Login/input_username'), output_username)

'Get Text to modify xpath for Edit button (in case Client wants to update Status of User by admin)'
return_username = WebUI.getText(findTestObject('Object_Login/input_username'))

'Enter password for new User'
WebUI.setText(findTestObject('Object_Login/input_password'), password)

'Click Login button to log Home Page'
WebUI.click(findTestObject('Object_Login/btn_Login'))

'Verify error message is displayed'
WebUI.verifyElementText(findTestObject('Object_Login/Object_Messeage_Login Failed'), 'Either login or password is invalid.')

'Call \'Common TC to Login\' to Login by Admin account ===> \t\r\nBrought to My Profile page'
WebUI.callTestCase(findTestCase('Common TC/Common TC to Login'), [('username') : 'admin', ('password') : 'Katalon@2018'], FailureHandling.STOP_ON_FAILURE)

'Navigate to Administration Panel page (http://13.250.134.32/subrion/panel/)'
WebUI.navigateToUrl(GlobalVariable.link_adminpage)

WebUI.waitForPageLoad(20)

WebUI.waitForElementNotVisible(findTestObject('Object_Active member/wait_loader'), 10)

'Click on \'Members\' menu of Main Menu'
WebUI.click(findTestObject('Object_Active member/main_member'))

'Click on \'Members\' menu of Sub Menu  ===> Brought to Members page'
WebUI.click(findTestObject('Object_Active member/sub_member'))

'Wait Page Load'
WebUI.waitForPageLoad(20)

'Click on Edit icon of created member'
xpath_string = WebUI.concatenate(((['//div[contains(text(),\'', return_username, '\')]/parent::td/following-sibling::td[9]/div/i[@title="Edit"]']) as String[]))

btn_edit = new TestObject('TheObjectName')

btn_edit.addProperty('xpath', ConditionType.EQUALS, xpath_string)

WebUI.click(btn_edit)

'Select \'Active\' status'
WebUI.selectOptionByValue(findTestObject('Object_Active member/cmb_Status'), 'active', true)

'Click on \'Save\' button'
WebUI.click(findTestObject('Object_Active member/btn_Save'))

'Log out of the system ===> \tNavigate to Home Page'
WebUI.click(findTestObject('Object_Active member/a_Logout'))

'Navigate to Home Page'
WebUI.navigateToUrl(GlobalVariable.link_homepage)

'Log in with activated user'
WebUI.callTestCase(findTestCase('Common TC/Common TC to Login'), [('username') : output_username, ('password') : password], FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()


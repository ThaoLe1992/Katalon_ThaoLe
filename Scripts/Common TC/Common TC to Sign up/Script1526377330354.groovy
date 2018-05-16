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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Open Browser'
WebUI.openBrowser('')

'Open window with full size'
WebUI.maximizeWindow()

'Navigate to link http://13.250.134.32/subrion/'
WebUI.navigateToUrl(GlobalVariable.link_homepage)

'Click on Sign up'
WebUI.click(findTestObject('Object_Sign up/a_Sign up'))

'Wait 20s'
WebUI.waitForPageLoad(20)

'Enter Username'
WebUI.sendKeys(findTestObject('Object_Sign up/input_username'), input_username)

'Enter Fullname'
WebUI.sendKeys(findTestObject('Object_Sign up/input_fullname'), fullname)

'Enter Email'
WebUI.sendKeys(findTestObject('Object_Sign up/input_email'), input_username + '@gmail.com')

'Create random email base on username'
email = (input_username + '@gmail.com')

'Enter Gender'
WebUI.selectOptionByValue(findTestObject('Object_Sign up/cmb_gender'), '2', false)

'Enter Password'
WebUI.sendKeys(findTestObject('Object_Sign up/input_password'), password)

'Re-enter Password'
WebUI.sendKeys(findTestObject('Object_Sign up/input_password2'), password)

'Click on Registration button\r\n'
WebUI.click(findTestObject('Object_Sign up/button_Registration'))

'Get the messege'
txt_message = WebUI.getText(findTestObject('Object_Sign up/txt_message'))

'Compare message'
WebUI.verifyMatch(txt_message, 'Member registered! Thank you!', false)

'Get the email'
txt_email = WebUI.getText(findTestObject('Object_Sign up/txt_email'))

WebUI.verifyMatch(txt_email, email, false)


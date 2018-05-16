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

'Open link http://13.250.134.32/subrion/'
WebUI.navigateToUrl(GlobalVariable.link_homepage)

'Call Common TC to Login'
WebUI.callTestCase(findTestCase('Common TC/Common TC to Login'), [('username') : 'katalontest', ('password') : 'katalontest@2018'], 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to Blog'
WebUI.click(findTestObject('Object_Add Blog Entry/a_Blog'))

'Add a new blog'
WebUI.click(findTestObject('Object_Add Blog Entry/a_Add Blog Entry'))

'Input title'
WebUI.sendKeys(findTestObject('Object_Add Blog Entry/input_title'), 'U23 Vietnam won U23 Irag')

'Input content\r\n'
WebUI.sendKeys(findTestObject('Object_Add Blog Entry/input_body'), 'U23 Vietnam went to the final match with U23 Uzbekistan')

'Input tags'
WebUI.sendKeys(findTestObject('Object_Add Blog Entry/input_tag'), '#football')

'Save a new blog'
WebUI.click(findTestObject('Object_Add Blog Entry/button_Save'))

'Get the title'
txt_title = WebUI.getText(findTestObject('Object_Verify the Blog Entry/txt_title'))

'Veriy the title'
WebUI.verifyMatch(txt_title, 'U23 Vietnam won U23 Irag', false)

'Get the content'
txt_content = WebUI.getText(findTestObject('Object_Verify the Blog Entry/txt_content'))

'Veriy the content\r\n'
WebUI.verifyMatch(txt_content, 'U23 Vietnam went to the final match with U23 Uzbekistan', false)

'Get the tags\r\n'
txt_tags = WebUI.getText(findTestObject('Object_Verify the Blog Entry/txt_tags'))

'Verify the tags\r\n'
WebUI.verifyMatch(txt_tags, '#football', false)

WebUI.closeBrowser()


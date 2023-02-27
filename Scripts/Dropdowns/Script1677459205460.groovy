import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.rutaWebDropdown)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/DropdownObjs/home_Dropdown'), GlobalVariable.tiempoEspera)) {
	WebUI.selectOptionByLabel(findTestObject('Object Repository/DropdownObjs/dropList'), "Option 1", false)

}else {
	KeywordUtil.markFailed("No estas en la pantalla de Inputs")
}


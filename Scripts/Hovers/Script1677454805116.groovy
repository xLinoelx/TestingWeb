import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

//Inicio de pagina
WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.rutaWebHovers)

//Pagina de incio
if (WebUI.verifyElementPresent(findTestObject('Object Repository/HoversObjs/home_Hovers'), GlobalVariable.tiempoEspera)) {
	KeywordUtil.markPassed("Estas en el pantalla de inicio de Hovers")

	//Usuario 1
	WebUI.focus(findTestObject('Object Repository/HoversObjs/img_User1'))
	KeywordUtil.markPassed("Estas focalizando el usuario")
	if(WebUI.verifyElementPresent(findTestObject('Object Repository/HoversObjs/name_User1'), GlobalVariable.tiempoEspera) ) {
		WebUI.click(findTestObject('Object Repository/HoversObjs/profile_User1'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/HoversObjs/txt_NotFound'), GlobalVariable.waitTime)
		WebUI.back()
	}else {
		KeywordUtil.markFailed("No estas focalizando un usuario 1")

		//Usuario 2
		WebUI.focus(findTestObject('Object Repository/HoversObjs/img_User2'))
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/HoversObjs/name_User2'), GlobalVariable.tiempoEspera) ) {
			WebUI.click(findTestObject('Object Repository/HoversObjs/profile_User2'))
			WebUI.waitForElementPresent(findTestObject('Object Repository/HoversObjs/txt_NotFound'), GlobalVariable.waitTime)
			WebUI.back()
		}else {
			KeywordUtil.markFailed("No estas focalizando un usuario 2")

			//Usuario 3
			WebUI.focus(findTestObject('Object Repository/HoversObjs/img_User3'))
			if(WebUI.verifyElementPresent(findTestObject('Object Repository/HoversObjs/name_User3'), GlobalVariable.tiempoEspera) ) {
				WebUI.click(findTestObject('Object Repository/HoversObjs/profile_User3'))
				WebUI.waitForElementPresent(findTestObject('Object Repository/HoversObjs/txt_NotFound'), GlobalVariable.waitTime)
				WebUI.back()

				WebUI.verifyElementPresent(findTestObject('Object Repository/HoversObjs/home_Hovers'), GlobalVariable.tiempoEspera)
			}else {
				KeywordUtil.markFailed("No estas focalizando un usuario 3")
			}
		}
	}

}else {
	KeywordUtil.markFailed("No estas en la pantalla de Inputs")
}

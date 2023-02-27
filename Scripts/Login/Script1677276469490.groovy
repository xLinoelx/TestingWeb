import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import javax.xml.xpath.XPath

import org.openqa.selenium.support.FindBy

import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
import utilidades.metodos

TestData loginData = findTestData('Login')


String username = ""
String password = ""

this.usernameLogin = ""
this.passwordLogin = ""

for(int i = 1; i <= loginData.getRowNumbers(); i++){

	if (loginData.getObjectValue('estado', i).toString().equalsIgnoreCase('TRUE')){

		if(this.usernameLogin.toString().equalsIgnoreCase("")){

			username = loginData.getObjectValue('usuario', i).toString()
			password = loginData.getObjectValue('clave', i).toString()
		}

		WebUI.openBrowser('')
		WebUI.navigateToUrl(GlobalVariable.rutaWebHoversLogin)

		if (WebUI.verifyElementPresent(findTestObject('Object Repository/LoginObjs/txt_LoginHomePage'), GlobalVariable.tiempoEspera)) {
			KeywordUtil.markPassed("Estas en el pantalla de inicio del Login")

			WebUI.setText(findTestObject('Object Repository/LoginObjs/input_Username'), username)
			KeywordUtil.markPassed("Se ha escrito correctamente el usuario")
			WebUI.setText(findTestObject('Object Repository/LoginObjs/input_Password'), password)
			KeywordUtil.markPassed("Se ha escrito correctamente la clave")
			WebUI.click(findTestObject('Object Repository/LoginObjs/btn_Login'))
			KeywordUtil.markPassed("Se ha dado click correctamente en el boton de Login")
			
			WebUI.verifyElementPresent(findTestObject('Object Repository/LoginObjs/txt_LoginSucess'), GlobalVariable.tiempoEspera)
			KeywordUtil.markPassed("Haz iniciado sesion correctamente")
			
			
		}else {
			KeywordUtil.markFailed("No estas en la pantalla de Login")
		}
	}

}
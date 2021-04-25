package login

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.google.common.collect.FilteredEntryMultimap.Keys
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import org.openqa.selenium.Keys as Keys

import internal.GlobalVariable

public class ações {

	@Keyword
	def AbreNavegadorAcessandoTakeBlip(){

		WebUI.openBrowser(GlobalVariable.URL)
	}

	@Keyword
	def MaximizarNavegador(){

		WebUI.maximizeWindow()

	}


	@Keyword
	def TiraPrintTela(text){

		WebUI.takeScreenshot(text)
	}
	
	@Keyword
	def FechaNavegador(){
		
		WebUI.closeBrowser()
	}
	
	@Keyword
	def EtapaPassou(text){
		
		KeywordUtil.markPassed(text)
		
	}
	
	@Keyword
	def EtapaFalhou(text){
		
		KeywordUtil.markFailed(text)
		
	}
	
	@Keyword
	def InformativoDaAção(text){
		
		KeywordUtil.markWarning(text)
		
	}
	
	@Keyword
	def EsperaObjetoApresentado(caminhoObjeto, timeout, nomeObjeto){
		
		def var = WebUI.waitForElementPresent(findTestObject(caminhoObjeto), timeout, FailureHandling.STOP_ON_FAILURE)
		
		if(var == true){
			
			InformativoDaAção("Continue: Apresentou o objeto " + nomeObjeto)
			return true
			
		} else {
		
			InformativoDaAção("PossívelErro: Não Apresentou o objeto " + nomeObjeto)
			TiraPrintTela("Evidências/Login/"+nomeObjeto+".png")
			FechaNavegador()
			return false
		}
		
		
	}
	

	@Keyword
	def VerificarExibiçãoLogoBlip(){

		def var = EsperaObjetoApresentado("Object Repository/Login/imagemLogo", GlobalVariable.ShortTimeOut, "Logo Take Blip")

		if(var == true){

			EtapaPassou("Passou: Apresentou o logo Take Blip")
			
		} else{

			EtapaFalhou("Falhou: Não Apresentou o logo da TakeBlip")
			TiraPrintTela("Evidências/Login/LogoBlip.png")
			FechaNavegador()
			
		}
	}
	
	
	@Keyword
	def ClicaCampo(caminhoObjeto, nomeObjeto){
		
		EsperaObjetoApresentado(caminhoObjeto, GlobalVariable.ShortTimeOut, nomeObjeto)
		WebUI.click(findTestObject(caminhoObjeto))
		TiraPrintTela("Evidências/Login/"+nomeObjeto+".png")
		
	}
	
	@Keyword
	def ClicaBotão(caminhoObjeto, nomeObjeto){
		
		EsperaObjetoApresentado(caminhoObjeto, GlobalVariable.ShortTimeOut, nomeObjeto)
		WebUI.click(findTestObject(caminhoObjeto))
		TiraPrintTela("Evidências/Login/"+nomeObjeto+".png")
		
	}
	
	
	@Keyword
	def DigitaCampo(caminhoObjeto, nomeObjeto, massa){
				
		EsperaObjetoApresentado(caminhoObjeto, GlobalVariable.ShortTimeOut, nomeObjeto)
		WebUI.setText(findTestObject(caminhoObjeto), massa)
		TiraPrintTela("Evidências/Login/"+nomeObjeto+".png")
				
	}
	
	@Keyword
	def VerificarComparativoMensagem(caminhoObjeto, nomeObjeto, massa){
		
		def var = EsperaObjetoApresentado(caminhoObjeto, GlobalVariable.ShortTimeOut, nomeObjeto)
		
		if(massa == GlobalVariable.mensagemTexto){
		
			EtapaPassou("Passou: Apresentou a mensagem esperada como " + massa)
			TiraPrintTela("Evidências/Login/"+nomeObjeto+".png")
					
		} else{
		
			EtapaFalhou("Falhou: Não Apresentou a mensagem esperada " + massa +". Apresentou a mensagem como " + GlobalVariable.mensagemTexto)
			TiraPrintTela("Evidências/Login/"+nomeObjeto+".png")
			FechaNavegador()
					
		}
	}
	
	@Keyword
	def CapturarTextoObjeto(caminhoObjeto, nomeObjeto){
		
		EsperaObjetoApresentado(caminhoObjeto, GlobalVariable.TimeOut, nomeObjeto)
		def var = WebUI.getText(findTestObject(caminhoObjeto))
		GlobalVariable.mensagemTexto = var
	    InformativoDaAção("Continue: Capturou o texto do objeto " + var + " na variável Global mensagemTexto")
		TiraPrintTela("Evidências/Login/"+nomeObjeto+".png")
		
	}
	
	@Keyword
	def TeclaTabTeclado(caminhoObjeto){
		
		WebUI.sendKeys(findTestObject(caminhoObjeto), Keys.chord(Keys.TAB))
		
		
	}
	
	
}


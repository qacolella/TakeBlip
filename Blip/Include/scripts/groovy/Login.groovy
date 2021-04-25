import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import io.cucumber.datatable.DataTable
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.pt.E
import cucumber.api.java.pt.Dado
import cucumber.api.java.pt.Então
import cucumber.api.java.pt.Quando



class Login {

	@Dado("que estou na tela de Login takeBlip")
	public void que_estou_na_tela_de_Login_takeBlip() {

		CustomKeywords.'login.ações.AbreNavegadorAcessandoTakeBlip'()
		CustomKeywords.'login.ações.MaximizarNavegador'()
		
	}
	
	@Quando("informo meus dados de acesso")
	public void informo_meus_dados_de_acesso(DataTable table) {
		
		CustomKeywords.'login.ações.VerificarExibiçãoLogoBlip'()

		List<Map<String, String>> data = table.asMaps(String.class, String.class)
		
		CustomKeywords.'login.ações.ClicaCampo'("Object Repository/Login/campoEmail", "Campo Email")
		CustomKeywords.'login.ações.DigitaCampo'("Object Repository/Login/campoEmail", "Campo Email", data[0].usuario)
		CustomKeywords.'login.ações.ClicaCampo'("Object Repository/Login/campoSenha", "Campo Senha")
		CustomKeywords.'login.ações.DigitaCampo'("Object Repository/Login/campoSenha", "Campo Senha", data[0].senha)
		
		CustomKeywords.'login.ações.ClicaBotão'("Object Repository/Login/botaoEntrar", "Botão Entrar")
		
	}
	
	@Então("vejo a mensagem {string}")
	public void vejo_a_mensagem(String massa) {
		
		CustomKeywords.'login.ações.CapturarTextoObjeto'("Object Repository/Login/mensagemLoginSenhaInválidos", "Mensagem Login/Senha Inválidos")
		CustomKeywords.'login.ações.VerificarComparativoMensagem'("Object Repository/Login/mensagemLoginSenhaInválidos", "Mensagem Login/Senha Inválidos", massa)

	}
	
	@Então("encerro a minha aplicação")
	public void encerro_a_minha_aplicação() {

		CustomKeywords.'login.ações.FechaNavegador'()
		
	}
	
	@Quando("não informo meus dados de acesso")
	public void não_informo_meus_dados_de_acesso() {
		
		CustomKeywords.'login.ações.TeclaTabTeclado'("Object Repository/Login/campoEmail")
		CustomKeywords.'login.ações.TeclaTabTeclado'("Object Repository/Login/campoSenha")

	}
	
	@Então("vejo a mensagem {string} abaixo do campo Usuário")
	public void vejo_a_mensagem_abaixo_do_campo_Usuário(String massa) {
		
		CustomKeywords.'login.ações.CapturarTextoObjeto'("Object Repository/Login/campoEmail", "Mensagem Campo Obrigatório abaixo campo Usuário")
		CustomKeywords.'login.ações.VerificarComparativoMensagem'("Object Repository/Login/campoEmail", "Mensagem Campo Obrigatório abaixo campo Usuário", massa)

	}
	
	@Então("vejo a mensagem {string} abaixo do campo Senha")
	public void vejo_a_mensagem_abaixo_do_campo_Senha(String massa) {
		
		CustomKeywords.'login.ações.CapturarTextoObjeto'("Object Repository/Login/campoSenha", "Mensagem Campo Obrigatório abaixo campo Senha")
		CustomKeywords.'login.ações.VerificarComparativoMensagem'("Object Repository/Login/campoSenha", "Mensagem Campo Obrigatório abaixo campo Senha", massa)
	
		
	}
	
	@Quando("informo email {string} inválido")
	public void informo_email_inválido(String email){
		
		CustomKeywords.'login.ações.ClicaCampo'("Object Repository/Login/campoEmail", "Campo Email")
		CustomKeywords.'login.ações.DigitaCampo'("Object Repository/Login/campoEmail", "Campo Email", email)
			
		
	}
	
	
	
	
	
	
	
	
	
	
	}
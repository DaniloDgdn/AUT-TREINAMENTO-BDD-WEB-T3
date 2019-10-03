package curso.treinamento.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import curso.treinamento.utils.Helper;

public class MenuPage {
	
	public MenuPage(WebDriver driver) { 
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy (xpath = "//a[@href='#Cars']")
	private WebElement btnCars;

	@FindBy (xpath = "//ul[@id='Cars']/descendant::a[text()='Cars']")
	private WebElement btnCarsSubCars;
	
	@FindBy (xpath = "//ul[@id='Cars']/descendant::a[text()='Extras']")
	private WebElement btnCarsSubExtras;
	
	@FindBy (xpath = "//ul[@id='Cars']/descendant::a[text()='Cars Settings']")
	private WebElement btnCarsSubCarsSettings;
	
	public void clicar_cars() { 
		Helper.aguardar_elemento(btnCars, 10);
		btnCars.click();
	}
	
	public boolean validar_botoes_cars() {
		
		boolean validacao = true;
		Helper.aguardar_elemento(btnCarsSubCars, 5);
		if(!(Helper.elemento_existe(btnCarsSubCars, 4)||Helper.elemento_existe(btnCarsSubExtras, 4)||Helper.elemento_existe(btnCarsSubCarsSettings, 4)))
		{
			validacao = false;
		}
		return validacao;
	}
}
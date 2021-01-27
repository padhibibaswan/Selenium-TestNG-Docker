package ObjectRepository;

import org.openqa.selenium.By;

public class MAD_Application_OR {

	
	By btn_SyncGui_MAD_HomePage=By.cssSelector("[id='user_email']");
	
	By txt_PostalCOde=By.cssSelector("input[name='postalCode']");
	By txt_streetName=By.cssSelector("input[name='streetName']");
	By txt_municipalityCode=By.cssSelector("input[name='municipalityCode']");
	By txt_streetCode=By.cssSelector("input[name='streetCode']");
	By txt_building=By.cssSelector("input[name='building']");
	By txt_floor=By.cssSelector("input[name='floor']");
	By txt_suite=By.cssSelector("input[name='suite']");
	By btn_search=By.cssSelector("input[name='search']");
	By table_result=By.cssSelector("table[class='logview']");
	By table_searchresult_rows=By.cssSelector("table[class='logview']>tbody>tr");
	
}

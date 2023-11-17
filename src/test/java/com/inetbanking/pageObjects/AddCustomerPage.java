package com.inetbanking.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/ul/li[2]/a")
	WebElement lnkAddNewCustomer;

	@FindBy(how = How.NAME, using = "name")
	WebElement txtCustomerName;

	@FindBy(how = How.XPATH, using = "//input[@type='radio']")
	List<WebElement> rdSelectGender;

	@FindBy(how = How.XPATH, using = "//input[@id='dob']")
	WebElement txtdob;

	@FindBy(how = How.NAME, using = "addr")
	WebElement txtaddress;

	@FindBy(how = How.NAME, using = "city")
	WebElement txtcity;

	@FindBy(how = How.ID_OR_NAME, using = "state")
	WebElement txtstate;

	@FindBy(how = How.NAME, using = "pinno")
	WebElement txtpinno;

	@FindBy(how = How.NAME, using = "telephoneno")
	WebElement txttelephoneno;

	@FindBy(how = How.NAME, using = "emailid")
	WebElement txtemailid;

	@FindBy(how = How.NAME, using = "password")
	WebElement txtpassword;

	@FindBy(how = How.NAME, using = "sub")
	WebElement btnSubmit;

	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();
	}

	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
	}

	public void custGender(String cgender) {
		for(WebElement radio : rdSelectGender) {
			if(radio.getAttribute("value").contains(cgender))
			        radio.click();
		}
	}

	public void custDob(String dd,String mm,String yy) {
		txtdob.sendKeys(dd,mm,yy);


	}

	public void custAddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}

	public void custCity(String ccity) {
		txtcity.sendKeys(ccity);
	}

	public void custState(String cstate) {
		txtstate.sendKeys(cstate);
	}

	public void custPinno(int cpinno) {
		txtpinno.sendKeys(String.valueOf(cpinno));
	}

	public void custTelephone(String ctelephone) {
		txttelephoneno.sendKeys(ctelephone);
	}

	public void custEmailid(String cemailid) {
		txtemailid.sendKeys(cemailid);
	}

	public void custPassword(String cpassword) {
		txtpassword.sendKeys(cpassword);
	}

	public void custSubmit() {
		btnSubmit.click();
	}
}

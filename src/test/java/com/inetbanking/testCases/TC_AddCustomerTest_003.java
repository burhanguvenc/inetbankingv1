package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();

		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		addcust.custName("TatlikusZeynep");
		addcust.custGender("f");
		Thread.sleep(2000);
		addcust.custDob("15","10","1985");
		Thread.sleep(2000);
		addcust.custAddress("USA");
		addcust.custCity("Rochester");
		addcust.custState("NY");
		addcust.custPinno(146252);
		addcust.custTelephone("5852814687");
		String email = randomString() + "@gmail.com";
		addcust.custEmailid(email);
		addcust.custPassword("abcdef");
		addcust.custSubmit();
		Thread.sleep(3000);
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (res == true) {
			Assert.assertTrue(res);
		} else {
			Assert.assertTrue(false);
		}
	}

}

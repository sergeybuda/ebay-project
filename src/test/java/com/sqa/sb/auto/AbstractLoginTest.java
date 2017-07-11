package com.sqa.sb.auto;

import org.testng.annotations.*;

public abstract class AbstractLoginTest extends BasicTest {

	public AbstractLoginTest(String baseUrl) {
		super(baseUrl);
	}

	abstract public void login(String username, String password);

	abstract public void logout();

	@BeforeClass
	public void setupLogin() {
		login(getProp("username"), getProp("password"));
	}

	@AfterClass
	public void setupLogout() {
		logout();
	}
}

package com.sqa.sb.ebay;

import java.sql.*;

import org.testng.annotations.*;

import com.sqa.sb.helpers.*;
import com.sqa.sb.helpers.enums.*;
import com.sqa.sb.helpers.exceptions.*;

public class AddItemToCartTest extends EbayTest {

	@DataProvider
	public Object[][] csvData() {
		return DataHelper.getTextFileData("src/main/resources/", "ebayitem.csv", TextFormat.CSV, false, new DataType[] { DataType.INT,
				DataType.STRING, DataType.INT, DataType.DOUBLE });
	}

	@DataProvider(name = "dbData")
	public Object[][] databaseData() throws ClassNotFoundException, DataTypesMismatchException, SQLException, DataTypesCountException,
			DataTypesTypeException {
		return DataHelper.evalDatabaseTable("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:8889/sqadb", "root", "root", "ebayitem", 0, 0,
				new DataType[] { DataType.INT, DataType.STRING, DataType.INT, DataType.DOUBLE });
	}

	@DataProvider(name = "testData")
	public Object[][] dp() {
		return new Object[][] { new Object[] { "BenQ HT2050 3D DLP Full HD 1080P Home Theater Gaming Projector HDMI 2200 Lumens", 3, 2099.97 },
				new Object[] { "Android 4.4 Quad Core 16GB HD WIFI Tablet PC Case Cover For Kids", 4, 235.96 },
				new Object[] { "SAFETY GLASSES CLEAR LENS SPORT WORK EYEWEAR PYRAMEX ZTEK S2510S 12 PAIR Z87.1", 5, 79.45 },
				new Object[] { "72 pc Army Men Toy Soldiers Military Gray Green Plastic Figurine Action Figure", 6, 41.94 },
				new Object[] { "Colorful Food Hot Dog Pizza Taco For Apple iPhone 6 6S 4.7 Case Cover Screen", 4, 59.80 },
				new Object[] { "Whimzees Toothbrush Dental Dog Treats Small 24 count", 12, 190.68 },
				new Object[] { "DEWALT 20V MAX Cordless Lithium Ion LED Spot Light DCL043 Bare New", 7, 643.86 },
				new Object[] { "SCOSCHE strikeDRIVE Car Charger with EZTIP Reversible Micro USB EZC12", 10, 149.40 } };
	}

	@DataProvider
	public Object[][] excel2003Data() throws InvalidExcelExtensionException {
		return DataHelper.getExcelFileData("src/main/resources/", "ebayitem.xls", false);
	}

	@DataProvider
	public Object[][] excelNewData() throws InvalidExcelExtensionException {
		return DataHelper.getExcelFileData("src/main/resources/", "ebayitem.xlsx", false);
	}

	@Test(dataProvider = "excelNewData", enabled = true)
	public void testAddItemToCartTest(double id, String itemToAdd, double quantity, double expectedCost) {
		getLog().info("Test-" + id + ": Add item to cart: " + itemToAdd + " [" + quantity + "] for an expected price of $" + expectedCost);
		// String totalCost = getDriver()
		// .findElement(By.xpath(".//*[@id='9971484282']/div[1]/div[2]/div/div[2]/div[1]/span/div")).getText();
	}

	@Test(dataProvider = "csvData", enabled = false)
	public void testAddItemToCartTestOriginal(int id, String itemToAdd, int quantity, double expectedCost) {
		getLog().info("Test-" + id + ": Add item to cart: " + itemToAdd + " [" + quantity + "] for an expected price of $" + expectedCost);
		// String totalCost = getDriver()
		// .findElement(By.xpath(".//*[@id='9971484282']/div[1]/div[2]/div/div[2]/div[1]/span/div")).getText();
	}
}

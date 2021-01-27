package resources;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

	int iTestCaseRow;
	Object[][] testObjArray;
	@DataProvider (name = "Authentication")
	 public Object[][] dpMethod(Method testMethod) {
		
		System.out.println("m in dtaa provider");
		 try {
			ExcelUtility.setExcelFile("C:\\Users\\m81084\\Desktop\\TestData.xlsx","Sheet1");
			System.out.println("Before Testmethod: " + testMethod.getName()); 
			System.out.println("the class name is "+testMethod.getDeclaringClass());
			 iTestCaseRow = ExcelUtility.getRowContains(testMethod.getName(),0);
			 testObjArray = ExcelUtility.getTableArray("C:\\Users\\m81084\\Desktop\\TestData.xlsx","Sheet1",iTestCaseRow);
			 
			 return (testObjArray);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return (testObjArray);
		}
		
		
		 
		 
		 
	 
	 
	}
	
}

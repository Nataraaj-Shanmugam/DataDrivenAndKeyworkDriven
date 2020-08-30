package org.testExecutionEngine;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Set;

import com.genericKeywords.GenericKeywords;
import com.genericKeywords.ProjectCustomException;
import com.utilities.ExcelUtilities;
import com.utilities.ReporterUtilities;

public class TestExecutionEngine extends GenericKeywords{
	private static LinkedHashMap<String, LinkedList<String>> executionScenariosKeywordsList;
	private static HashMap<String, HashMap<String, String>> masterTestData;

	/**
	 * Function to Initiate resources - Driver, Reporter
	 * @author Nataraaj
	 */
	public void scenarioKeyword() {
		new ReporterUtilities().createReporterTest(getTestData().get("Scenario"));
		openBrowser(); 
	}


	/**
	 * Execution engine which take cares of the 
	 * @author Nataraaj
	 */
	public void executionEngine() {
		Class<?> classFileName;
		try {
			classFileName = Class.forName("com.applicationRelatedFunctionalities.ApplicationActions");
			for (String eachKeyword : getScenarioKeyword()) {
				boolean flag= false;
				//				try {
				Method[] methodObject = classFileName.getDeclaredMethods();
				for (Method method : methodObject) {
					if(method.getName().equalsIgnoreCase(eachKeyword) && method.getParameters().length == 0) {
						method.invoke(classFileName.getDeclaredConstructor().newInstance(), (Object[])method.getParameters());
						flag=true;
					}
					if(flag)
						break;
				}
				if(!flag)
					throw new Exception();
			}
		} catch (Exception e) {
			new ProjectCustomException(getClassName(), getMethodName(), e,"");
		}
	}

	/**
	 * Function to close resources - Driver
	 * @author Nataraaj
	 */
	public void closeResources() {
		try {
			closeBrowser();
		} catch (Exception e) {
			new ProjectCustomException(getClassName(), getMethodName(), e,"Exception while closing browser");
		}
	}

	/**
	 * Parameterized constructor to set scenario name, Keyword and Test data for each execution
	 * @param scenario
	 * @author Nataraaj
	 */
	public TestExecutionEngine(String scenario){
		scenarioKeywordList.set(executionScenariosKeywordsList.get(scenario));
		scenarioTestData.set(masterTestData.get(scenario));
	}

	/**
	 * Function to get Testdata and Keywords for all executing scenarios
	 * @return
	 * @author Nataraaj
	 */
	public static Set<String> dataProvider() {
		ExcelUtilities excelObject = new ExcelUtilities(propFile.getProperty("TestDataWorkBook"));
		executionScenariosKeywordsList = excelObject.masterKeywordDetails();
		masterTestData = excelObject.masterTestDataSet();
		return masterTestData.keySet();
	}
}

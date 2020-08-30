package org.testExecutionEngine;

import com.genericKeywords.ProjectCustomException;
import com.utilities.ReporterUtilities;

public class ExecutionClass{
	public static void main(String[] args) throws ProjectCustomException {
		TestExecutionEngine executionObject;
		ReporterUtilities reportObject = new ReporterUtilities();
		reportObject.createReport();
		for (String scenarioName : TestExecutionEngine.dataProvider()) {
			executionObject = new TestExecutionEngine(scenarioName);
			executionObject.scenarioKeyword();
			executionObject.executionEngine();
			executionObject.closeResources();
		}
		reportObject.flushReport();
	}
}

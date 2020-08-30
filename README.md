# dataDrivenAndKeyworkDriven
This is a hybrid framework with implementation of DataDriven And KeyworkDriven approaches.

Below is the execution flow of the framework

org.testExecutionEngine.ExecutionClass -> org.testExecutionEngine.TestExecutionEngine -> ApplicationRelatedFunctionalities


Brief about the class file 
  1.	com.applicationRelatedFunctionalities -> Application related functionalities including Action and  Object repository
  2.	com.genericKeywords.GenericKeywords -> Selenium specific generic keywords to perform actions in webpage
  3.	com.genericKeywords.ProjectCustomException -> Custom Exception class  created to follow steps before and after aborting the test flow
  4.	com.genericKeywords.ThreadLocalFunctionalities -> thread local instances implementation for whole framework
  5.	com.utilities.ExcelUtilities -> Excel related utilities class 
  6.	com.utilities.FileUtilities -> File operations utilities class
  7.	com.utilities.ReporterUtilities-> Extent Reporter utilities class 
  8.	org.testExecutionEngine -> Execution Engine where we have define the initiation of resources and execution of the specified method
  9.	org.testExecutionEngine.ExecutionClass -> class with constructive details of the flow of method to execute in stepwise

Brief about other resources:
  1.	TestDataSheet.xlsx – Acts as RunManager,Keyword details and Data details
  2.	ApplicationAndExecution.properties – Property file with predefined information about the locations of file and other entities

Brief about folder details:
  1.	src\test\resources – Holds all the resources including TestDataSheet and ApplicationAndExecution
  2.	executionReports – Extent Report repository


 


package com.bridgelabz.test.EmployeeIO;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class EmployeePayrollServiceTest {
	
	@Test
	public void givenEmployees_whenWrittenToFile_shouldMatchEmployee(){
		EmployeePayroll[] arraysOfEmp = {
				new EmployeePayroll(1, "Jeffy", 500),
				new EmployeePayroll(2, "Bill", 600),
				new EmployeePayroll(3, "Mark", 800)
		};
		EmployeePayrollService employeePayrollService;
		employeePayrollService = new EmployeePayrollService(Arrays.asList(arraysOfEmp));
		employeePayrollService.writeData(EmployeePayrollService.IOService.CONSOLE_IO);
	}
}
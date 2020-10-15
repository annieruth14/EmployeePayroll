package com.bridgelabz.test.EmployeeIO;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmployeePayrollServiceTest {
	EmployeePayrollService employeePayrollService;
	
	@Before
	public void initialze() {
		EmployeePayroll[] arraysOfEmp = {
				new EmployeePayroll(1, "Jeffy", 500),
				new EmployeePayroll(2, "Bill", 600),
				new EmployeePayroll(3, "Mark", 800)
		};
		employeePayrollService = new EmployeePayrollService(Arrays.asList(arraysOfEmp));
	}
	
	@Test
	public void givenEmployees_whenWrittenToFile_shouldMatchEmployee(){
		employeePayrollService.writeData(EmployeePayrollService.IOService.FILE_IO);
		employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
		long entries = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
		Assert.assertEquals(3, entries);
	}
	@Test
	public void givenEmployeesInFile_whenAddedToList_shouldMatchEntries(){
		long entries = employeePayrollService.fileToList(EmployeePayrollService.IOService.FILE_IO);
		System.out.println(entries);
		Assert.assertEquals(3, entries);
	}

}

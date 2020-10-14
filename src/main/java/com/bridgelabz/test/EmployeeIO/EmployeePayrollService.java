package com.bridgelabz.test.EmployeeIO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
	public enum IOService {
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	}

	Scanner userInput = new Scanner(System.in);
	private List<EmployeePayroll> employeePayrollList;

	public EmployeePayrollService() {
	}

	public EmployeePayrollService(List<EmployeePayroll> employeePayrollList) {
		this.employeePayrollList = employeePayrollList;
	}

	public static void main(String[] args) {
		ArrayList<EmployeePayroll> employeePayrollList = new ArrayList<>();
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
		employeePayrollService.readData();
		employeePayrollService.writeData(IOService.CONSOLE_IO);
	}

	private void readData() {
		System.out.println("Enter employee Id");
		int id = userInput.nextInt();
		userInput.nextLine();
		System.out.println("Enter employee name");
		String name = userInput.nextLine();
		System.out.println("Enter employee salary");
		double salary = userInput.nextDouble();
		employeePayrollList.add(new EmployeePayroll(id, name, salary));
	}

	public void writeData(IOService ioService) {
		if(ioService.equals(EmployeePayrollService.IOService.CONSOLE_IO))
			System.out.println("\nWriting Employee Payroll Roaster to Console\n" + employeePayrollList);
		else if(ioService.equals(IOService.FILE_IO))
			new EmployeePayrollFileIOService().writeData(employeePayrollList);}
}

package com.bridgelabz.test.EmployeeIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EmployeePayrollFileIOService {
	public static String PAYROLL_FILE_NAME = "payroll-file.txt";

	public void writeData(List<EmployeePayroll> employeePayrollList) {
		StringBuffer empBuffer = new StringBuffer();
		employeePayrollList.forEach(employee -> {
			String employeeData = employee.toString().concat("\n");
			empBuffer.append(employeeData);
		});
		try {
			Files.write(Paths.get(PAYROLL_FILE_NAME), empBuffer.toString().getBytes());
		} catch (IOException e) {

		}
	}

	public void printData() {
		try {
			Files.lines(new File(PAYROLL_FILE_NAME).toPath())
			.forEach(System.out::println);
		} catch (IOException e) {

		}
	}

	public long countEntries() {
		long entries = 0;
		try {
			entries = Files.lines(new File(PAYROLL_FILE_NAME).toPath()).count();
		} catch (IOException e) {

		}
		return entries;
	}
}

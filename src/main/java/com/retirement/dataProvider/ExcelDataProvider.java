package com.retirement.dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;

	public ExcelDataProvider() {
		File src = new File("./TestData/Data.xlsx");

		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);

		} catch (Exception e) {
			System.out.println("unable to read Excel file" + e.getMessage());

		}

	}

	public String getStringData(String sheetName, int row, int col) {
		return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
	}

	public Double getNumericData(String sheetName, int row, int col) {
		return wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
	}

	public HashMap<String, Object> getAllData(String sheetName) {
		HashMap<String, Object> map = new HashMap<>();
		int n = wb.getSheet(sheetName).getLastRowNum();
		for (int i = 0; i < n; i++) {
			String key = wb.getSheet(sheetName).getRow(i).getCell(0).getStringCellValue();
			Object value;
			if (wb.getSheet(sheetName).getRow(i).getCell(1).getCellType().equals(CellType.STRING)) {
				value = wb.getSheet(sheetName).getRow(i).getCell(1).getStringCellValue();
			} else {
				value = (int) wb.getSheet(sheetName).getRow(i).getCell(1).getNumericCellValue();
			}
			map.put(key, value);
		}
		System.out.println("Map: " + map);
		return map;
	}

}

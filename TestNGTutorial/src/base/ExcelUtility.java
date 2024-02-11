package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	private static XSSFWorkbook book;
	private static XSSFSheet sheet;
	private static XSSFCell cell;
	private static XSSFRow row;

	public static void setExcelFile(String path, String sheetName) throws Exception {
		try {
			FileInputStream excelFile = new FileInputStream(path);
			book = new XSSFWorkbook(excelFile);
			sheet = book.getSheet(sheetName);
		} catch (Exception e) {
			throw(e);
		}
	}

	public static String[][] getTestData(String tableName) {
		String testData[][] = null;
		try {
			XSSFCell[] boundaryCells = findCells(tableName);
			XSSFCell startCell = boundaryCells[0];
			XSSFCell endCell = boundaryCells[1];

			int startRow = startCell.getRowIndex() + 1;
			int endRow = endCell.getRowIndex() - 1;
			int startCol = startCell.getColumnIndex() + 1;
			int endCol = endCell.getColumnIndex() - 1;

			testData = new String[endRow - startRow + 1][endCol - startCol + 1];

			for (int i = startRow; i < endRow + 1; i++) {
				for (int j = startCol; j < endCol + 1; j++) {
					testData[i - startRow][j - startCol] = sheet.getRow(i).getCell(j).getStringCellValue();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return testData;
	}

	public static XSSFCell[] findCells(String tableName) {
		DataFormatter formatter = new DataFormatter();
		// Declare begin position
		String pos = "begin";
		XSSFCell[] cells = new XSSFCell[2];

		for (Row row : sheet) {
			for (Cell cell : row) {
				// if (tableName.equals(cell.getStringCellValue())) {
				if (tableName.equals(formatter.formatCellValue(cell))) {
					if (pos.equalsIgnoreCase("begin")) {
						// Find the begin cell, this is used for boundary cells
						cells[0] = (XSSFCell) cell;
						pos = "end";
					} else {
						// Find the end cell, this is used for boundary cells
						cells[1] = (XSSFCell) cell;
					}
				}
			}
		}
		// Return the cells array
		return cells;
	}

	/*
	 * Write in the Excel cell, String Result
	 * 
	 * @params - Row num and Col num
	 */
	public static void setCellData(String FileName, String Result, int RowNum, int ColNum) throws Exception {
		try {
			row = sheet.getRow(RowNum);
			cell = sheet.getRow(RowNum).getCell(ColNum);
//			cell = row.getCell(ColNum);
			if (cell == null) {
				cell = row.createCell(ColNum);
				cell.setCellValue(Result);
			} else {
				cell.setCellValue(Result);
			}

			// Open the file to write the results
			FileOutputStream fileOut = new FileOutputStream(Constants.File_Path + FileName);

			book.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}
	}

	/*
	 * Write in the Excel cell, double Result
	 * 
	 * @params - Row num and Col num
	 */
	public static void setCellData(String FileName, double Result, int RowNum, int ColNum) throws Exception {
		try {
			row = sheet.getRow(RowNum);
			cell = row.getCell(ColNum);
			if (cell == null) {
				cell = row.createCell(ColNum);
				cell.setCellValue(Result);
			} else {
				cell.setCellValue(Result);
			}

			// Open the file to write the results
			FileOutputStream fileOut = new FileOutputStream(Constants.File_Path + FileName);

			book.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}
	}
}

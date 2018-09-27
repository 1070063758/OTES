package com.ssm.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.service.IUpdateService;

@Controller
@RequestMapping("/update")
public class updateController {

	@Resource
	private IUpdateService update;
	
	
	/**
	 * 教师批量导入
	 */
	@RequestMapping("/updateTeacher")
	public String teacherUpdate() {
		File file = new File("E:/student.xlsx");
		InputStream inputStream = null;
		Workbook workbook = null;
		List<String> li = new ArrayList<String>();
		try {
			inputStream = new FileInputStream(file);
			workbook = WorkbookFactory.create(inputStream);
			inputStream.close();
			Sheet sheet = workbook.getSheetAt(0);
			int rowLength = sheet.getLastRowNum() + 1;
			Row row = sheet.getRow(0);
			int colLength = row.getLastCellNum();
			Cell cell = row.getCell(0);
			CellStyle cellStyle = cell.getCellStyle();
			System.out.println("行数：" + rowLength + ",列数：" + colLength);
			for (int i = 1; i < rowLength; i++) {
				row = sheet.getRow(i);
				for (int j = 0; j < colLength; j++) {
					cell = row.getCell(j);

					if (cell != null)
						cell.setCellType(Cell.CELL_TYPE_STRING);
					System.out.print(cell.getStringCellValue() + "\t");
					li.add(cell.getStringCellValue());
				}
				this.update.updateTeacher(li.get(0), li.get(1), li.get(2),li.get(3));
				li.clear();
				System.out.println();
			}
			OutputStream out = new FileOutputStream(file);
			workbook.write(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	/**
	 * 学生批量导入
	 * @return
	 */
	@RequestMapping("/updateStudent")
	public String read() {
		File file = new File("E:/student.xlsx");
		InputStream inputStream = null;
		Workbook workbook = null;
		List<String> li = new ArrayList<String>();
		try {
			inputStream = new FileInputStream(file);
			workbook = WorkbookFactory.create(inputStream);
			inputStream.close();
			Sheet sheet = workbook.getSheetAt(0);
			int rowLength = sheet.getLastRowNum() + 1;
			Row row = sheet.getRow(0);
			int colLength = row.getLastCellNum();
			Cell cell = row.getCell(0);
			CellStyle cellStyle = cell.getCellStyle();
			System.out.println("行数：" + rowLength + ",列数：" + colLength);
			for (int i = 1; i < rowLength; i++) {
				row = sheet.getRow(i);
				for (int j = 0; j < colLength; j++) {
					cell = row.getCell(j);

					if (cell != null)
						cell.setCellType(Cell.CELL_TYPE_STRING);
					System.out.print(cell.getStringCellValue() + "\t");
					li.add(cell.getStringCellValue());
				}
				this.update.updateStudent(li.get(0), li.get(1), li.get(2));
				li.clear();
				System.out.println();
			}
			OutputStream out = new FileOutputStream(file);
			workbook.write(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	
	/**
	 * 单人导入
	 */
	@RequestMapping("/singleStudent")
	public void singleStudent(String name,String studentNumber, String classID){
		
		
	}
	
}
package com.ssm.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.pojo.User;
import com.ssm.pojo.function;
import com.ssm.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private IUserService userService;
	
	
	@RequestMapping("/show")
	public String show(HttpServletRequest request, Model model) {
		
		return "redirect:/student/getTeacher";
	}
	
	

	@RequestMapping("/showUser")
	public void read() {
		File file = new File("E:/student.xlsx");
		InputStream inputStream = null;
		Workbook workbook = null;
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
			for (int i = 0; i < rowLength; i++) {
				row = sheet.getRow(i);
				for (int j = 0; j < colLength; j++) {
					cell = row.getCell(j);

					if (cell != null)
						cell.setCellType(Cell.CELL_TYPE_STRING);
					System.out.print(cell.getStringCellValue() + "\t");
				}
				System.out.println();
			}
			OutputStream out = new FileOutputStream(file);
			workbook.write(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping("/loginController")
	public String Index(HttpServletRequest request, String username,String password,Model model) {
		User use = this.userService.loginByUandP(username, password);
		model.addAttribute("user", use);
		switch (use.getType()) {
		case 0:
			model.addAttribute("type", "学生");
			break;
		case 1:
			model.addAttribute("type", "教师");
			break;
		case 2:
			model.addAttribute("type", "领导");
			break;
		case 3:
			model.addAttribute("type", "管理员");
			break;

		default:
			break;
		}
		String name = null;
		if(use != null){
			List<function> li = this.userService.getFuncByuser(use);
			model.addAttribute("func",li);
			for (function function : li) {
				name = function.getName();
				System.out.println(function.getFunc());
			}
			request.getSession().setAttribute("jobNumber", use.getJobNumber());
			request.getSession().setAttribute("name", name);
			return "main";
		}
		return "test";
	}
}
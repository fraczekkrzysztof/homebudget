package com.fraczekkrzysztof.homebudget.view;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.fraczekkrzysztof.homebudget.entity.Expense;

public class ExcelView extends AbstractXlsView {
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	 @Override
	    protected void buildExcelDocument(Map<String, Object> model,
	                                      Workbook workbook,
	                                      HttpServletRequest request,
	                                      HttpServletResponse response) throws Exception {

	        // change the file name
	        response.setHeader("Content-Disposition", "attachment; filename=\"my-xls-file.xls\"");

	        @SuppressWarnings("unchecked")
	        List<Expense> expenses = (List<Expense>) model.get("expenses");

	        // create excel xls sheet
	        Sheet sheet = workbook.createSheet("Expense List");
	        sheet.setDefaultColumnWidth(30);

	        // create style for header cells
	        CellStyle style = workbook.createCellStyle();
	        Font font = workbook.createFont();
	        font.setFontName("Arial");
	        style.setFillForegroundColor(HSSFColor.BLUE.index);
	        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        font.setBold(true);
	        font.setColor(HSSFColor.WHITE.index);
	        style.setFont(font);


	        // create header row
	        Row header = sheet.createRow(0);
	        header.createCell(0).setCellValue("Date");
	        header.getCell(0).setCellStyle(style);
	        header.createCell(1).setCellValue("Description");
	        header.getCell(1).setCellStyle(style);
	        header.createCell(2).setCellValue("Category");
	        header.getCell(2).setCellStyle(style);
	        
	        int rowCount = 1;

	        for(Expense exp : expenses){
	            Row expenseRow =  sheet.createRow(rowCount++);
	            expenseRow.createCell(0).setCellValue(sdf.format(exp.getDate()));
	            expenseRow.createCell(1).setCellValue(exp.getDescription());
	            expenseRow.createCell(2).setCellValue(exp.getCategory().getName());
	            
	            }

	    }
}

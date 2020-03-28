package util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelOperation {
    public static List<Map<Integer,String>> ExcelRead(String excelPath)throws Exception{
        List<Map<Integer,String>> work = new ArrayList<>();

        FileInputStream fs=new FileInputStream(excelPath);  //获取head.xls
        POIFSFileSystem ps=new POIFSFileSystem(fs);  //使用POI提供的方法得到excel的信息
        HSSFWorkbook wb=new HSSFWorkbook(ps);
        HSSFSheet sheet=wb.getSheetAt(0);  //获取到工作表，因为一个excel可能有多个工作表
        HSSFRow row=sheet.getRow(0);  //获取第一行（excel中的行默认从0开始，所以这就是为什么，一个excel必须有字段列头），即，字段列头，便于赋值
//        System.out.println(sheet.getLastRowNum()+" "+row.getLastCellNum());  //分别得到最后一行的行号，和一条记录的最后一个单元格

        int lastRowNum = sheet.getLastRowNum();
        int lastCellNum = 7;
        for(int i = 0;i<=lastRowNum;i++){
            row = sheet.getRow(i);
            Map<Integer,String> record = new HashMap<>();
            for(int j=0;j<lastCellNum;j++){
                try {
                    record.put(j,row.getCell(j).getStringCellValue());
                }catch (IllegalStateException ex){
                    record.put(j, String.valueOf(row.getCell(j).getNumericCellValue()));
                }
            }
            work.add(record);
        }
//
//        FileOutputStream out=new FileOutputStream(System.getProperty("user.dir") + "ThePhoneBook.xls");  //向head.xls中写数据
//        row=sheet.createRow((short)(sheet.getLastRowNum()+1)); //在现有行号后追加数据
//        row.createCell(0).setCellValue("hello"); //设置第一个（从0开始）单元格的数据
//        row.createCell(1).setCellValue(1); //设置第二个（从0开始）单元格的数据

//
//        out.flush();
//        wb.write(out);
//        out.close();
        return work;
    }
    public static void ExcelWrite(String excelPath,List<Map<Integer,String>> work)throws IOException {
        // 创建工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建工作表
        HSSFSheet sheet = workbook.createSheet("sheet1");

        for (int row = 0; row < work.size(); row++)
        {
            HSSFRow rows = sheet.createRow(row);
            for (int col = 0; col < work.get(0).size(); col++)
            {
                // 向工作表中添加数据
                rows.createCell(col).setCellValue(work.get(row).get(col));
            }
        }

        File xlsFile = new File(excelPath);
        FileOutputStream xlsStream = new FileOutputStream(xlsFile);
        workbook.write(xlsStream);
    }
}

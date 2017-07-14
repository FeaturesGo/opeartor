package com.www.opeartor.test.excelReader;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

/**
 * Created by Vincent on 2017/7/13.
 */
public class ReadExcelUtil {

    public static void main(String[] args){
        int i;
        Sheet sheet;
        Workbook workbook;
        Cell cell1,cell2,cell3,cell4,cell5,cell6,cell7;
        try {

            //test.xls为要读取的excel文件名
            workbook = Workbook.getWorkbook(new File("E:/aaa/test.xls"));
            //获得第一个工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
            sheet = workbook.getSheet(0);
            cell1 = sheet.getCell(0,0);
            cell2 = sheet.getCell(1,0);
            cell3 = sheet.getCell(2,0);
            cell4 = sheet.getCell(3,0);
            cell5 = sheet.getCell(4,0);
            cell6 = sheet.getCell(5,0);
            cell7 = sheet.getCell(6,0);
            System.out.println("标题: " + cell1.getContents()+"\t"+cell2.getContents()+"\t"+cell3.getContents()+"\t"+cell4.getContents()
                    +"\t"+cell5.getContents()+"\t"+cell6.getContents()+"\t"+cell7.getContents());

            i = 1;
            while (true){
                cell1 = sheet.getCell(0,i);
                cell2 = sheet.getCell(1,i);
                cell3 = sheet.getCell(2,i);
                cell4 = sheet.getCell(3,i);
                cell5 = sheet.getCell(4,i);
                cell6 = sheet.getCell(5,i);
                cell7 = sheet.getCell(6,i);
                if ("".equals(cell1.getContents()) == true)
                    break;
                System.out.println(cell1.getContents()+"\t"+cell2.getContents()+"\t"+cell3.getContents()+"\t"+cell4.getContents()
                        +"\t"+cell5.getContents()+"\t"+cell6.getContents()+"\t"+cell7.getContents());
                i++;
            }
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }
}

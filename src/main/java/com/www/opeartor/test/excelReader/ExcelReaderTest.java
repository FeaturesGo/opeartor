package com.www.opeartor.test.excelReader;

import jxl.Workbook;

import java.io.File;

/**
 * Created by Vincent on 2017/7/13.
 */
public class ExcelReaderTest {
    public static void main(String[] args)throws Exception{
        File file = null;
        file = new File("E:/aaa/test.xls");

        Workbook wb = ExcelReader.getWorkBook(file);
        String data = ExcelReader.readExcelData(wb,2,2,0);
        System.out.println("data = " + data);

        /*String[] data1 = ExcelReader.readExcelRowOrCol(wb,0,1,2,1,6);
        for (int i = 0; i < data1.length; i++) {
            System.out.print(data1[i]+",");
        }

        System.out.println();*/

        wb.close();
    }
}

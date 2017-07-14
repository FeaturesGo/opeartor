package com.www.opeartor.test.excelReader;


import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Vincent on 2017/7/13.
 */
public class ExcelReader {

    private ExcelReader(){}

    /**
     * 获取excelFile引用的Excel文件实例
     * @param excelFile
     * @return
     * @throws BiffException
     * @throws IOException
     */
    public static Workbook getWorkBook(File excelFile)throws BiffException, IOException{
        Workbook rwb = null;
        InputStream inputStream = new FileInputStream(excelFile);
        rwb = Workbook.getWorkbook(inputStream);
        return rwb;
    }

    /**
     * 得到book引用的Excel文件中标签索引为sheetIndex位置处的工作表实例
     * @param book  Excel文件实例
     * @param sheetIndex  Excel文件的标签索引（第一个标签索引为0，第二个为1，以此类推）
     * @return
     */
    public static Sheet getWorkBookSheet(Workbook book, int sheetIndex){
        Sheet sheet = book.getSheet(sheetIndex);
        return sheet;
    }

    /**
     *读取Excel表指定单行或单列的数据并存放到一维数组返回
     * @param rwb
     * @param sheetIndex
     * @param startRow 开始行
     * @param endRow   结束行
     * @param startCol 开始列
     * @param endCol   结束列
     * @return
     * @throws BiffException
     * @throws IOException
     */
    public static String[] readExcelRowOrCol(Workbook rwb,int sheetIndex,int startRow,int endRow,int startCol,int endCol)throws BiffException, IOException{
        String[] data = null;
        int row_distance = Math.abs(endRow - startRow);
        int col_distance = Math.abs(endCol - startCol);

        int need_read_row = -1; //需要读取的行号
        int need_read_col = -1; //需要读取的列号

        Sheet sheet = getWorkBookSheet(rwb,sheetIndex);

        if (row_distance == 0){//如果只读取一行
            data = new String[col_distance + 1];
            need_read_row = startRow;
        }else if (col_distance == 0){//如果只读取一列
            data = new String[row_distance + 1];
            need_read_col = startCol;
        }

        for (int i = 0; i < data.length; i++){
            if (need_read_row != -1){//只需读一行
                data[i] = readExcelData(sheet, need_read_row, i + startCol);
            }else if (need_read_col != -1){//只需读一列
                data[i] = readExcelData(sheet, i + startRow, need_read_col);
            }
        }

        return data;
    }

    /**
     * 读取sheetIndex表中的[starRow,endRow]至[starCol,endCol]区间的数据
     */
    public static String[][] readExcelAreaData(Workbook rwb,int sheetIndex,
                                               int starRow,int endRow,
                                               int starCol,int endCol)throws BiffException, IOException{
        String[][] tempData = new String[endRow - starRow + 1][endCol - starCol + 1];
        Sheet sheet = getWorkBookSheet(rwb,sheetIndex);
        for (int i = starRow; i <= endRow; i++) {
            for (int j = starCol; j <= endCol; j++) {
                tempData[i - starRow][j - starCol] = sheet.getCell(j-1, i-1).getContents();
            }
        }
        return tempData;
    }


    /**
     * 指定读取excel表中的row行col列的数据
     * @param rwb
     * @param row
     * @param col
     * @param sheetIndex
     * @return
     * @throws BiffException
     * @throws IOException
     */
    public static String readExcelData(Workbook rwb, int row, int col,
                                       int sheetIndex) throws BiffException, IOException {
        Sheet sheet = getWorkBookSheet(rwb,sheetIndex);
        Cell cell = null;
        cell = sheet.getCell(col - 1, row - 1);
        String temp = cell.getContents();
        return temp;
    }

    public static String readExcelData(Sheet sheet, int row, int col)
            throws BiffException, IOException {
        Cell cell = null;
        cell = sheet.getCell(col - 1, row - 1);
        String temp = cell.getContents();
        return temp;
    }



}

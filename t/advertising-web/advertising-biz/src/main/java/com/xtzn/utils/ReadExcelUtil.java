package com.xtzn.utils;

import com.xtzn.mapper.entity.AccountInfo;
import com.xtzn.mapper.entity.PersonInfo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月16日]
 */
public class ReadExcelUtil {

    public static List<PersonInfo> readExcel(Workbook workbook, Integer userId, Integer typeId) {
        Sheet sheet = workbook.getSheetAt(0);
        if (sheet == null) {
            return null;
        }
        List<PersonInfo> list = new ArrayList<PersonInfo>();
        //获得当前sheet的开始行
        int firstRowNum = sheet.getFirstRowNum();
        //获得当前sheet的结束行
        int lastRowNum = sheet.getLastRowNum();
        //循环除了第一行的所有行
        for (int rowNum = firstRowNum + 1; rowNum <= lastRowNum; rowNum++) {
            //获得当前行
            Row row = sheet.getRow(rowNum);
            if (row == null) {
                continue;
            }
            PersonInfo cells = new PersonInfo();
            cells.setUserId(userId);
            cells.setTypeId(typeId);
            //循环当前行
            for (int cellNum = 0; cellNum < 14; cellNum++) {
                Cell cell = row.getCell(cellNum);
                switch (cellNum) {
                    case 0:
                        cells.setFirstName(getCellValue(cell));
                        break;
                    case 1:
                        cells.setLastName(getCellValue(cell));
                        break;
                    case 2:
                        cells.setSex(getCellValue(cell));
                        break;
                    case 3:
                        if ("".equals(getCellValue(cell))) {
                            cells.setYear(null);
                        } else {
                            cells.setYear(Integer.parseInt(getCellValue(cell)));
                        }
                        break;
                    case 4:
                        if ("".equals(getCellValue(cell))) {
                            cells.setMonth(null);
                        } else {
                            cells.setMonth(Integer.parseInt(getCellValue(cell)));
                        }
                        break;
                    case 5:
                        if ("".equals(getCellValue(cell))) {
                            cells.setDay(null);
                        } else {
                            cells.setDay(Integer.parseInt(getCellValue(cell)));
                        }
                        break;
                    case 6:
                        cells.setEmail(getCellValue(cell));
                        break;
                    case 7:
                        cells.setPassword(getCellValue(cell));
                        break;
                    case 8:
                        cells.setTelephone(getCellValue(cell));
                        break;
                    case 9:
                        cells.setSecurityCode(getCellValue(cell));
                        break;
                    case 10:
                        cells.setRegion(getCellValue(cell));
                        break;
                    case 11:
                        cells.setCity(getCellValue(cell));
                        break;
                    case 12:
                        cells.setStreet(getCellValue(cell));
                        break;
                    case 13:
                        cells.setZipCode(getCellValue(cell));
                        break;
                }
            }
            list.add(cells);
        }
        return list;

    }


    public static List<AccountInfo> readAccountExcel(Workbook workbook, Integer userId, Integer typeId) {
        Sheet sheet = workbook.getSheetAt(0);
        if (sheet == null) {
            return null;
        }
        List<AccountInfo> list = new ArrayList<AccountInfo>();
        //获得当前sheet的开始行
        int firstRowNum = sheet.getFirstRowNum();
        //获得当前sheet的结束行
        int lastRowNum = sheet.getLastRowNum();
        //循环除了第一行的所有行
        for (int rowNum = firstRowNum + 1; rowNum <= lastRowNum; rowNum++) {
            //获得当前行
            Row row = sheet.getRow(rowNum);
            if (row == null) {
                continue;
            }
            AccountInfo cells = new AccountInfo();
            cells.setUserId(userId);
            cells.setType(typeId);
            //循环当前行
            for (int cellNum = 0; cellNum < 2; cellNum++) {
                Cell cell = row.getCell(cellNum);
                switch (cellNum) {
                    case 0:
                        cells.setUserName(getCellValue(cell));
                        break;
                    case 1:
                        cells.setUserPwd(getCellValue(cell));
                        break;
                }
            }
            list.add(cells);
        }
        return list;

    }

    public static String getCellValue(Cell cell) {
        String cellValue = "";
        if (cell == null) {
            return cellValue;
        }
        //把数字当成String来读，避免出现1读成1.0的情况
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }
        //判断数据的类型
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC: //数字
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_STRING: //字符串
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_BOOLEAN: //Boolean
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA: //公式
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_BLANK: //空值
                cellValue = "";
                break;
            case Cell.CELL_TYPE_ERROR: //故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }
}

package readExcel1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

    public static void main(String[] args) throws FileNotFoundException {
        readXml("C://Users//whaty//Desktop//图书属性表(年龄）.xls");
        // System.out.println(KeyUtils.getPublicKeyString());
    }

    public static void readXml(String fileName) throws FileNotFoundException {
        OutputStream out = new FileOutputStream(new File("C://Users//whaty//Desktop//a.txt"));
        boolean isE2007 = false; // 判断是否是excel2007格式
        if (fileName.endsWith("xlsx"))
            isE2007 = true;
        try {
            InputStream input = new FileInputStream(fileName); // 建立输入流
            Workbook wb = null;
            // 根据文件格式(2003或者2007)来初始化
            if (isE2007)
                wb = new XSSFWorkbook(input);
            else
                wb = new HSSFWorkbook(input);
            Sheet sheet = wb.getSheetAt(0); // 获得第一个表单
            Iterator<Row> rows = sheet.rowIterator(); // 获得第一个表单的迭代器
            while (rows.hasNext()) {
                Row row = rows.next(); // 获得行数据
                String id = "";
                String type = "";
                String grade = "";
                String age = "";
                System.out.println("Row #" + row.getRowNum()); // 获得行号从0开始
                Iterator<Cell> cells = row.cellIterator(); // 获得第一行的迭代器
                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    System.out.println("Cell #" + cell.getColumnIndex());
                    if (cell.getColumnIndex() == 0) {
                        id = cell.getStringCellValue();
                    } else if (cell.getColumnIndex() == 3) {
                        type = cell.getStringCellValue();
                    } else if (cell.getColumnIndex() == 4) {
                        grade = cell.getStringCellValue().replace("幼儿园，", "").replace("小学，", "").replace("初中，", "")
                            .replace("高中，", "");
                    } else if (cell.getColumnIndex() == 5) {
                        age = cell.getStringCellValue();
                    }
                    switch (cell.getCellType()) { // 根据cell中的类型来输出数据
                    case HSSFCell.CELL_TYPE_NUMERIC:
                        // System.out.println(cell.getNumericCellValue());
                        break;
                    case HSSFCell.CELL_TYPE_STRING:
                        // System.out.println(cell.getStringCellValue());
                        break;
                    case HSSFCell.CELL_TYPE_BOOLEAN:
                        // System.out.println(cell.getBooleanCellValue());
                        break;
                    case HSSFCell.CELL_TYPE_FORMULA:
                        // System.out.println(cell.getCellFormula());
                        break;
                    default:
                        // System.out.println("unsuported sell type");
                        break;
                    }
                }
                String temp = "update ddb_resource_book set type='" + type + "' ,grade='"
                    + grade.replace("幼儿园,，", "").replace("小学，", "").replace("初中，", "").replace("高中，", "") + "',age='"
                    + age + "'  where id='" + id + "'; \n";
                String[] split = grade.split("，");
                for (String str : split) {
                    String labelId = "";
                    if ("幼小".equals(str)) {
                        labelId = "8b191772-fd87-11e6-9f75-c81f66dbee68";
                    } else if ("幼儿".equals(str)) {
                        labelId = "624c1a98-fd8c-11e6-9f75-c81f66dbee68";
                    } else if ("幼中".equals(str)) {
                        labelId = "8b1aeb7d-fd87-11e6-9f75-c81f66dbee68";
                    } else if ("幼大".equals(str)) {
                        labelId = "8b1cc017-fd87-11e6-9f75-c81f66dbee68";
                    } else if ("小一".equals(str)) {
                        labelId = "8b1ecf08-fd87-11e6-9f75-c81f66dbee68";
                    } else if ("小二".equals(str)) {
                        labelId = "8b211e1c-fd87-11e6-9f75-c81f66dbee68";
                    } else if ("小三".equals(str)) {
                        labelId = "8b23ae79-fd87-11e6-9f75-c81f66dbee68";
                    } else if ("小四".equals(str)) {
                        labelId = "8b260c13-fd87-11e6-9f75-c81f66dbee68";
                    } else if ("小五".equals(str)) {
                        labelId = "8b298065-fd87-11e6-9f75-c81f66dbee68";
                    } else if ("小六".equals(str)) {
                        labelId = "8b2b8e24-fd87-11e6-9f75-c81f66dbee68";
                    } else if ("初一".equals(str)) {
                        labelId = "8b2db27d-fd87-11e6-9f75-c81f66dbee68";
                    } else if ("初二".equals(str)) {
                        labelId = "8b2ffe96-fd87-11e6-9f75-c81f66dbee68";
                    } else if ("初三".equals(str)) {
                        labelId = "8b321aa4-fd87-11e6-9f75-c81f66dbee68";
                    } else if ("高一".equals(str)) {
                        labelId = "8b343b62-fd87-11e6-9f75-c81f66dbee68";
                    } else if ("高二".equals(str)) {
                        labelId = "8b367400-fd87-11e6-9f75-c81f66dbee68";
                    } else if ("高三".equals(str)) {
                        labelId = "8b3934ca-fd87-11e6-9f75-c81f66dbee68";
                    } else if ("大一".equals(str)) {
                        labelId = "8b3b8c7f-fd87-11e6-9f75-c81f66dbee68";
                    } else if ("大二".equals(str)) {
                        labelId = "8b3e377e-fd87-11e6-9f75-c81f66dbee68";
                    } else if ("大三".equals(str)) {
                        labelId = "8b4088e0-fd87-11e6-9f75-c81f66dbee68";
                    } else if ("大四".equals(str)) {
                        labelId = "8b42a3b7-fd87-11e6-9f75-c81f66dbee68";
                    } else if ("其它".equals(str)) {
                        labelId = "ff80818149ea3d200149eab3e7980014";
                    }

                    temp = "insert into ddb_book_label_relationship (id,fk_book_id,fk_label_id) values (UUID(),'" + id
                        + "','" + labelId + "'); \n";
                    out.write(temp.getBytes());
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

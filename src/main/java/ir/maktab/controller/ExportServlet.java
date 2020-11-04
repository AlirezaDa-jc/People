package ir.maktab.controller;

import ir.maktab.MyApp;
import ir.maktab.domains.Person;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ExportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String excelFilePath = "D:\\Programs\\Java\\People\\People.xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("People");
        List<Person> people = MyApp.getPersonService().findAll();
        writeHeaderLine(sheet);

        try {
            writeDataLines(people, sheet);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        FileOutputStream outputStream = new FileOutputStream(excelFilePath);
        workbook.write(outputStream);
    }

    private void writeHeaderLine(XSSFSheet sheet) {

        Row headerRow = sheet.createRow(0);

        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("ID");

        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("FirstName");

        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("LastName");

        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("PhoneNumber");

    }

    private void writeDataLines(List<Person> result,
                                XSSFSheet sheet) throws SQLException {
        int rowCount = 1;
        int i = 0;
        for (Person person : result) {
            long id = person.getId();
            String firstName = person.getFirstName();
            String lastName = person.getLastName();
            long phoneNumber = person.getPhoneNumber();
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            Cell cell = row.createCell(columnCount++);
            cell.setCellValue(id);
            cell = row.createCell(columnCount++);
            cell.setCellValue(firstName);

            cell = row.createCell(columnCount++);
            cell.setCellValue(lastName);

            cell = row.createCell(columnCount++);
            cell.setCellValue(phoneNumber);
        }
//        while (result.next()) {
//
//            long id = result.getLong("id");
//            String firstName = result.getString("firstname");
//            String lastName = result.getString("lastname");
//            long phoneNumber = result.getLong("phonenumber");
//
//            Row row = sheet.createRow(rowCount++);
//
//            int columnCount = 0;
//            Cell cell = row.createCell(columnCount++);
//            cell.setCellValue(id);
//
//            cell = row.createCell(columnCount++);
//            cell.setCellValue(firstName);
//
//            cell = row.createCell(columnCount++);
//            cell.setCellValue(lastName);
//
//            cell = row.createCell(columnCount++);
//            cell.setCellValue(phoneNumber);
//
//        }
    }
}

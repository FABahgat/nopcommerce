package registeration;

import base.BaseTests;
import homePage.HomePage;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import pages.RegisterationPage;
import pages.RegisterationResultPage;
import static org.testng.Assert.assertEquals;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RegisterationTest extends BaseTests {

     @Test(dataProvider = "registrationData")
     public void testSuccessfulRegistration(String gender, String firstName, String lastName, String dayOfBirth, String monthOfBirth, String yearOfBirth, String email, String companyName, String newsletterCheckbox, String password,String confirmPassword) {
          RegisterationPage registrationPage = homePage.clickRegisterationButton();

          if (gender.equalsIgnoreCase("female")) {
               registrationPage.selectFemale();
          } else {
               registrationPage.selectMale();
          }

          registrationPage.setFirstName(firstName);
          registrationPage.setLastName(lastName);
          registrationPage.clickDropDownDay().selectFromDropDownDay(dayOfBirth);
          registrationPage.clickDropDownMonth().selectFromDropDownMonth(monthOfBirth);
          registrationPage.clickDropDownYear().selectFromDropDownYear(yearOfBirth);
          registrationPage.setEmail(email);
          registrationPage.setCompanyName(companyName);

          if (newsletterCheckbox != null && newsletterCheckbox.equalsIgnoreCase("true")) {
               registrationPage.selectNewsLetter();
          } else {
               registrationPage.deselectNewsLetter();
          }

          registrationPage.setPassword(password);
          registrationPage.setConfirmPassword(confirmPassword);

          RegisterationResultPage registrationResultPage = registrationPage.clickRegisterButton();

          assertEquals(registrationResultPage.getAlertText(), "Your registration completed", "Incorrect message");

          registrationResultPage.logout();
          RegisterationPage newRegistrationPage = registrationResultPage.navigateToRegistrationPage();

     }

     @DataProvider(name = "registrationData")
     public Object[][] getRegistrationData() {
          Object[][] testData = null;
          try {
               FileInputStream file = new FileInputStream("D:\\nopcommerce\\resources\\testDataSheet-latest.xlsx");
               Workbook workbook = WorkbookFactory.create(file);
               Sheet sheet = workbook.getSheet("Sheet1");
               int rowCount = sheet.getPhysicalNumberOfRows();
               int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

               testData = new Object[rowCount - 1][colCount];
               for (int i = 1; i < rowCount; i++) {
                    Row row = sheet.getRow(i);
                    for (int j = 0; j < colCount; j++) {
                         Cell cell = row.getCell(j);
                         if (cell.getCellType() == CellType.BOOLEAN) {
                              testData[i - 1][j] = String.valueOf(cell.getBooleanCellValue());
                         } else if (cell.getCellType() == CellType.NUMERIC) {
                              testData[i - 1][j] = String.valueOf((int) cell.getNumericCellValue());
                         } else {
                              testData[i - 1][j] = cell.getStringCellValue();
                         }
                    }
               }
               workbook.close();
               file.close();
          } catch (FileNotFoundException e) {
               e.printStackTrace();
          } catch (IOException e) {
               e.printStackTrace();
          }
          return testData;
     }
}
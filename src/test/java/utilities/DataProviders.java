package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {
    //DataProvider 1

    @DataProvider(name="LoginData")
    public String [][] getData() throws IOException, IOException {
        String path=".//testData//Opencart_LoginData.xlsx"; //taking xl file from testData

        ExelUtility xlutil=new ExelUtility(path);  //creating an object for XLUtility

        int totalrows=xlutil.getRowCount("Sheet1");
        int totalcols=xlutil.getCellCount("Sheet1", 1);

        String logindata [][]=new String[totalrows][totalcols]; //created for two dimension array which can store
        for (int i=1;i<=totalrows;i++)     //1     //read the data from xl storing in two deminsional array
        {
            for (int j=0;j<totalcols;j++){           //0      //is rows j is col
                logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);
            }
        }
        return logindata;  //returning two dimension array
    }

    //DataProvider 2
    //DataProvider 3
    //dataProvider 4


}

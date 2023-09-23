import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

public class CommonData {
    static int id = 0;
    static String mainPath = "Supermarket_Files";

    public static void createDataStructure(){
        try {

            File mainDirectory = new File(mainPath);
            mainDirectory.mkdir();

            File employeesDirectory = new File(mainDirectory+"/Employees");
            employeesDirectory.mkdir();
            File bookLogDirectory = new File(mainDirectory + "/BookLog");
            bookLogDirectory.mkdir();
            File customers = new File(mainDirectory + "/Customers");
            customers.mkdir();
        }catch (Exception io){
            CommonData.logBook(io,"CreateStructure error");
        }
    }

    static public void logBook(Exception ex, String info){
        id++;
        try{
            info = LocalDateTime.now() + " " + ex.getMessage() +  "\n"
                    + "Aditional information: " +info ;
            File logFile = new File("Supermarkert_Files/LogBook/"+id + "_Log");
            FileWriter writer = new FileWriter(logFile);
            writer.write(info);
            writer.close();
        }catch (IOException io){
            System.out.println("logBook error");
        }
    }
}

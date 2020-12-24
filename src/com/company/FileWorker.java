package com.company;

import java.io.*;
import java.util.Scanner;

public class FileWorker {

    public void ReadRequestFromFile (String filename) throws java.io.IOException {
      FileReader fr = null;

      try{
          fr = new FileReader("resources\\" + filename);
          Scanner read = new Scanner(fr);
          SQLrequest = " ";
          while (read.hasNext()){
              SQLrequest += read.next();
              SQLrequest += " ";
          }

        }

      catch (Exception ex) {
        System.out.println("Что - то пошло не так при считывании запроса из файла \n" + ex);
      }

      finally {
          assert fr != null;
          fr.close();
      }
    }




    public void WriteResultToFile (String result, String filename) throws IOException {

            File resultFile = new File("resources\\" + filename);

            if (resultFile.exists()) {
                resultFile.delete();
            }

            boolean suq = resultFile.createNewFile();
            if (suq){
                System.out.println("Файл ответа создан!");
                FileWriter fw = new FileWriter(resultFile);
                fw.write(result);
                fw.flush();
                fw.close();
                System.out.println("Ответ записан!");
            }
            else {
                System.out.println("Создать файл не получилось");
            }


        }


   public String GetRequest(){
        return SQLrequest;
    }
   private String SQLrequest;
}

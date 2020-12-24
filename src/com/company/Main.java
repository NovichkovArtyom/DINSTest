package com.company;

import java.io.IOException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        System.out.println("Файл с найстройками подключения должен находиться в" +
                " папке resources \n\n\n"  +
                "    Press Enter" );

        System.in.read();
        Connection.GetSettingFromJFile();
        System.out.println("Введите логин:");
        Scanner input = new Scanner(System.in);
        String login = input.next();
        System.out.println("\n" + "Введите пароль:");
        String password = input.next();
        input.close();


        Connection.SetConnectionUNAMEPASS(login, password);
        System.out.println("Подключаемся к базе и отправляем запрос из файла");
        FileWorker fileWork = new FileWorker();
        fileWork.ReadRequestFromFile("requests.txt");
        fileWork.WriteResultToFile(Connection.ConnectAndSend(fileWork.GetRequest()),"answer.txt" );

        /* filename - заделка на будущее, где можно через консоль выбрать название файла,
        выбрав перед этим файл, который нужно запустить*/

        System.out.println("Закрываемся");

    }

}


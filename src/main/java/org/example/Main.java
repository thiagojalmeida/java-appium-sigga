package org.example;

import io.appium.java_client.AppiumBy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        BufferedReader objReader = null;

        try {
            String strCurrentLine;
            objReader = new BufferedReader(new FileReader("src/main/resources/stepsTest.txt"));
            while ((strCurrentLine = objReader.readLine()) != null) {
                String[] split = strCurrentLine.split("&");

                System.out.println(split[0] +" "+ split[1]);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
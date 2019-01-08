package com.example.webhook;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReaderService {

    public static String readFileAsString(String fileName)
    {
        String data = null;
        try {
            data = new String(Files.readAllBytes(Paths.get(fileName)));
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return data;
    }
}

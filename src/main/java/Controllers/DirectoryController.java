package Controllers;
import Functional.User;

import java.io.*;
class DirectoryController
{
    public static void create(String str)
    {
        try{
            boolean success;
            success = (new File(str)).mkdirs();

        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
}
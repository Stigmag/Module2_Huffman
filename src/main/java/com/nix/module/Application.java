package com.nix.module;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Application {
    private static final Logger logger
            = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {


       try{
           logger.info("Example log from {}", Application.class.getSimpleName());
        Print.printCodeTable(File.readImage("C:\\Users\\Kate\\Desktop\\DIARY\\24b492a28f2a2d6abbc232385d6bcbc9.png"));
           logger.info("Example log from {}", Application.class.getSimpleName());
           Print.printCodeHuffman(File.readImage("C:\\Users\\Kate\\Desktop\\DIARY\\24b492a28f2a2d6abbc232385d6bcbc9.png"));
       }
       catch (IOException e)
       {
           logger.error("Example log from {}", Application.class.getSimpleName());
       }

        //String text= "ihii hkd dd bj";
        try {
            Print.printCodeTable(File.read("C:\\Users\\Kate\\Desktop\\Haffman - Copy\\test.txt"));
            Print.printCodeHuffman(File.read("C:\\Users\\Kate\\Desktop\\Haffman - Copy\\test.txt"));
        } catch (IOException e) {
            logger.error(e.getMessage(), Application.class.getSimpleName());
        }


    }
}

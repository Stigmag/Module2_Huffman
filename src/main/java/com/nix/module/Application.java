package com.nix.module;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Scanner;

public class Application {
    private static final Logger logger
            = LoggerFactory.getLogger(Application.class);

    //C:\\Users\\Kate\\Desktop\\Haffman\\file.txt
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        args[0] = scanner.nextLine();
        switch (File.getFileExtension(args[0])) {
            case ".hf":
                try {

                    Print.printCodeHuffman(File.read("kol.hf"));
                } catch (IOException e) {
                    logger.error(e.getMessage(), Application.class.getSimpleName());
                }
                break;
            case ".png":
                try {
                    logger.info("Example log from {}", Application.class.getSimpleName());
                    Print.printCodeTable(File.readImage(args[0]));
                    logger.info("Example log from {}", Application.class.getSimpleName());
                    Print.printCodeHuffman(File.readImage(args[0]));
                } catch (IOException e) {
                    logger.error("Example log from {}", Application.class.getSimpleName());
                }
                break;
            case ".txt":
                try {
                    Print.printCodeTable(File.read(args[0]));
                    Print.printCodeHuffman(File.read(args[0]));
                } catch (IOException e) {
                    logger.error(e.getMessage(), Application.class.getSimpleName());
                }
                break;
        }


    }
}

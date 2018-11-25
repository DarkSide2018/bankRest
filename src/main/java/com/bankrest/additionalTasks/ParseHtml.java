package com.bankrest.additionalTasks;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;

public class ParseHtml {
    public static void main(String[] args) {
        String s = Paths.get(".").toAbsolutePath().normalize().toString();
        System.out.println(s);
    }
}

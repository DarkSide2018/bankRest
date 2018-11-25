package com.bankrest.additionalTasks;

import java.io.File;
import java.net.URL;

public class ParseHtml {
    public static void main(String[] args) {
        URL resource = Thread.currentThread().getContextClassLoader().getResource("test.html");
        File file = new File(resource.getFile());
        System.out.println(file.getName());
    }
}

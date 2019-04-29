package com.nemk.educator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;

@SpringBootApplication
public class NemkEducatorApplication {

//    http://websystique.com/springmvc/spring-mvc-4-fileupload-download-hibernate-example/

    public static void main(String[] args) {
        SpringApplication.run(NemkEducatorApplication.class, args);
    }

    private static final long MAX_FILE_SIZE = 1024 * 1024 * 25;//25MB

    private static final long MAX_REQUEST_SIZE = 1024 * 1024 * 30;//30MB

    private static final int FILE_SIZE_THRESHOLD = 0;

}

package com.kmv.naumentest.nameservice;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

@Component
public class FileNameService {

    private final HashMap<String, Integer> valueMap = new HashMap<>();
    private boolean isInitialized = false;

    public Optional<Integer> getAge(String name) {
        if (!isInitialized)
            initialize();
        return Optional.ofNullable(valueMap.get(name));
    }

    private void initialize() {
        try {
            File file = ResourceUtils.getFile("classpath:names.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
            String readLine;
            while ((readLine = reader.readLine()) != null) {
                String[] values = readLine.split("_");
                valueMap.put(values[0], Integer.valueOf(values[1]));
            }
        } catch (IOException e) {
            System.out.println("Exception! " + e.getMessage());
        } finally {
            isInitialized = true;
        }
    }
}
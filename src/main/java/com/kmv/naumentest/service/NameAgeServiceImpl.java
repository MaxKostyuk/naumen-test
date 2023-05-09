package com.kmv.naumentest.service;

import com.kmv.naumentest.nameservice.FileNameService;
import com.kmv.naumentest.nameservice.ServerNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NameAgeServiceImpl implements NameAgeService {

    private final ServerNameService serverName;
    private final FileNameService fileName;
    @Override
    public Integer getNameAge(String name) {
        return fileName.getAge(name).orElse(serverName.getAge(name));
    }
}

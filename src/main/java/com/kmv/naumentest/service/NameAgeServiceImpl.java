package com.kmv.naumentest.service;

import com.kmv.naumentest.model.NameAge;
import com.kmv.naumentest.nameservice.FileNameService;
import com.kmv.naumentest.nameservice.ServerNameService;
import com.kmv.naumentest.statistics.StatisticsModule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NameAgeServiceImpl implements NameAgeService {

    private final ServerNameService serverName;
    private final FileNameService fileName;
    private final StatisticsModule statistics;
    @Override
    public Integer getNameAge(String name) {
        Integer age = fileName.getAge(name).orElse(serverName.getAge(name));
        statistics.update(name, age);
        return age;
    }

    @Override
    public NameAge getOldestName() {
        return statistics.getOldestName();
    }

    @Override
    public List<NameAge> getNameRequestFrequency() {
        return statistics.getNameRequestFrequency();
    }
}

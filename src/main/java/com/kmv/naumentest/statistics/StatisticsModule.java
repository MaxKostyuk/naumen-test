package com.kmv.naumentest.statistics;

import com.kmv.naumentest.model.NameAge;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StatisticsModule {

    private final HashMap<String, Integer> statisticsMap = new HashMap<>();
    private final NameAge oldestName = new NameAge("name by default", -1, 0);

    public void update(String name, Integer age) {
        statisticsMap.put(name, statisticsMap.getOrDefault(name, 0) + 1);
        if (oldestName.getAge() < age) {
            oldestName.setAge(age);
            oldestName.setName(name);
        }
    }

    public NameAge getOldestName() {
        return oldestName;
    }

    public List<NameAge> getNameRequestFrequency() {
        return statisticsMap.entrySet().stream()
                .map(es -> new NameAge(es.getKey(), 0, es.getValue()))
                .sorted(Comparator.comparingInt(NameAge::getCount).reversed())
                .collect(Collectors.toList());
    }
}

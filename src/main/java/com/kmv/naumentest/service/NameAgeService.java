package com.kmv.naumentest.service;

import com.kmv.naumentest.model.NameAge;

import java.util.List;

public interface NameAgeService {

    Integer getNameAge(String name);

    NameAge getOldestName();

    List<NameAge> getNameRequestFrequency();

}

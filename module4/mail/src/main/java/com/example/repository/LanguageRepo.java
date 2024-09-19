package com.example.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LanguageRepo implements ILanguageRepo{
    @Override
    public List<String> getLanguages() {
        List<String> list = new ArrayList<>();
        list.add("English");
        list.add("Vietnamese");
        list.add("Japanese");
        list.add("Chinese");
        return list;
    }
}

package com.example.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PageSizeRepo implements IPageSizeRepo{
    @Override
    public List<String> getPageSizes() {
        List<String> list = new ArrayList<String>();
        list.add("5");
        list.add("10");
        list.add("15");
        list.add("25");
        list.add("50");
        list.add("100");
        return list;
    }
}

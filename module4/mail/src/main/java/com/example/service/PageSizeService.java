package com.example.service;

import com.example.repository.IPageSizeRepo;
import com.example.repository.PageSizeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageSizeService implements IPageSizeService{
    private IPageSizeRepo pageSizeRepo = new PageSizeRepo();
    @Override
    public List<String> getPageSizes() {
        return pageSizeRepo.getPageSizes();
    }
}

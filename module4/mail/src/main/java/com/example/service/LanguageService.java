package com.example.service;

import com.example.repository.ILanguageRepo;
import com.example.repository.LanguageRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService implements ILanguageService{
    private ILanguageRepo languageRepo = new LanguageRepo();
    @Override
    public List<String> getLanguages() {
        return languageRepo.getLanguages();
    }
}

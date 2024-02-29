package com.karacamehmet.turkcelljavabootcamphomework2.repository.implementation;

import com.karacamehmet.turkcelljavabootcamphomework2.model.entity.ProgrammingLanguage;
import com.karacamehmet.turkcelljavabootcamphomework2.repository.abstraction.ProgrammingLanguageRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProgrammingLanguageRepositoryImpl implements ProgrammingLanguageRepository {

    private final List<ProgrammingLanguage> programmingLanguages = new ArrayList<>();

    //adding the programming language to the list
    @Override
    public ProgrammingLanguage addProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
        programmingLanguages.add(programmingLanguage);
        return programmingLanguage;
    }

    //updating the programming language with the given id
    @Override
    public ProgrammingLanguage updateProgrammingLanguageById(int programmingLanguageId, ProgrammingLanguage newProgrammingLanguage) {
        programmingLanguages.stream()
                .filter(language -> language.getId() == programmingLanguageId)
                .findFirst()
                .ifPresent(language -> {
                    int index = programmingLanguages.indexOf(language);
                    programmingLanguages.set(index, newProgrammingLanguage);
                });
        return newProgrammingLanguage;
    }
    //updating the programming language with the given name
    @Override
    public ProgrammingLanguage updateProgrammingLanguageByName(String programmingLanguageName, ProgrammingLanguage newProgrammingLanguage) {
        programmingLanguages.stream()
                .filter(language -> language.getName().equals(programmingLanguageName))
                .findFirst()
                .ifPresent(language -> {
                    int index = programmingLanguages.indexOf(language);
                    programmingLanguages.set(index, newProgrammingLanguage);
                });
        return newProgrammingLanguage;
    }
    //getting the programming language with the given id
    @Override
    public ProgrammingLanguage getProgrammingLanguageById(int programmingLanguageId) {
        return programmingLanguages.stream()
                .filter(language -> language.getId() == programmingLanguageId)
                .findFirst()
                .orElse(null);
    }
    //getting the programming language with the given name
    @Override
    public ProgrammingLanguage getProgrammingLanguageByName(String programmingLanguageName) {
        return programmingLanguages.stream()
                .filter(language -> language.getName().equals(programmingLanguageName))
                .findFirst()
                .orElse(null);
    }
    //getting all the programming languages
    @Override
    public List<ProgrammingLanguage> getAllProgrammingLanguages() {
        return programmingLanguages;
    }

    //deleting the programming language with the given id
    @Override
    public void deleteProgrammingLanguageByName(String programmingLanguageName) {
        programmingLanguages.stream()
                .filter(language -> language.getName().equals(programmingLanguageName))
                .findFirst()
                .ifPresent(programmingLanguages::remove);
    }
    //deleting the programming language with the given name
    @Override
    public void deleteProgrammingLanguageById(int programmingLanguageId) {
        programmingLanguages.stream()
                .filter(language -> language.getId() == programmingLanguageId)
                .findFirst()
                .ifPresent(programmingLanguages::remove);
    }
}

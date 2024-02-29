package com.karacamehmet.turkcelljavabootcamphomework2.service.implementation;


import com.karacamehmet.turkcelljavabootcamphomework2.model.entity.ProgrammingLanguage;
import com.karacamehmet.turkcelljavabootcamphomework2.repository.abstraction.ProgrammingLanguageRepository;
import com.karacamehmet.turkcelljavabootcamphomework2.service.abstraction.ProgrammingLanguageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammingLanguageServiceImpl implements ProgrammingLanguageService {
    ProgrammingLanguageRepository programmingLanguageRepository;

    public ProgrammingLanguageServiceImpl(ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    //checking if the programming language already exists and if not add it to the list
    @Override
    public ProgrammingLanguage addProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
        if (programmingLanguage == null || programmingLanguage.getName().isEmpty()) {
            throw new RuntimeException("Programming language cannot be empty.");
        }

        if (getProgrammingLanguageByName(programmingLanguage.getName()) == null &&
                getProgrammingLanguageById(programmingLanguage.getId()) == null) {
            return programmingLanguageRepository.addProgrammingLanguage(programmingLanguage);
        } else {
            throw new RuntimeException("Programming language already exists by name or id.");
        }

    }

    //checking if the programming language already exists and if not update it
    @Override
    public ProgrammingLanguage updateProgrammingLanguageById(int programmingLanguageId, ProgrammingLanguage newProgrammingLanguage) {
        if (newProgrammingLanguage == null || newProgrammingLanguage.getName().isEmpty()) {
            throw new RuntimeException("Programming language cannot be empty.");
        }
        if (programmingLanguageId < 0) {
            throw new RuntimeException("Programming language Id cannot be less than 0.");
        }

        if ((getProgrammingLanguageByName(newProgrammingLanguage.getName()) == null ||
                getProgrammingLanguageById(programmingLanguageId).getName().equals(newProgrammingLanguage.getName())) &&
                (getProgrammingLanguageById(newProgrammingLanguage.getId()) == null ||
                        programmingLanguageId == newProgrammingLanguage.getId())) {
            return programmingLanguageRepository.updateProgrammingLanguageById(programmingLanguageId, newProgrammingLanguage);
        } else {
            throw new RuntimeException("Programming language already exists by name or id.");
        }
    }
    //checking if the programming language already exists and if not update it
    @Override
    public ProgrammingLanguage updateProgrammingLanguageByName(String programmingLanguageName, ProgrammingLanguage newProgrammingLanguage) {
        if (newProgrammingLanguage == null || newProgrammingLanguage.getName().isEmpty() || programmingLanguageName.isEmpty()) {
            throw new RuntimeException("Programming language cannot be empty.");
        }

        if ((getProgrammingLanguageByName(newProgrammingLanguage.getName()) == null ||
                programmingLanguageName.equals(newProgrammingLanguage.getName())) &&
                (getProgrammingLanguageById(newProgrammingLanguage.getId()) == null ||
                        getProgrammingLanguageByName(programmingLanguageName).getId() == newProgrammingLanguage.getId())) {
            return programmingLanguageRepository.updateProgrammingLanguageByName(programmingLanguageName, newProgrammingLanguage);
        } else {
            throw new RuntimeException("Programming language already exists.");
        }
    }
    //getting the programming language with the given id
    @Override
    public ProgrammingLanguage getProgrammingLanguageById(int programmingLanguageId) {
        return programmingLanguageRepository.getProgrammingLanguageById(programmingLanguageId);
    }
    //getting the programming language with the given name
    @Override
    public ProgrammingLanguage getProgrammingLanguageByName(String programmingLanguageName) {
        return programmingLanguageRepository.getProgrammingLanguageByName(programmingLanguageName);
    }
    //getting all the programming languages
    @Override
    public List<ProgrammingLanguage> getAllProgrammingLanguages() {
        return programmingLanguageRepository.getAllProgrammingLanguages();
    }
    //deleting the programming language with the given name
    @Override
    public void deleteProgrammingLanguageByName(String programmingLanguageName) {
        programmingLanguageRepository.deleteProgrammingLanguageByName(programmingLanguageName);
    }
    //deleting the programming language with the given id
    @Override
    public void deleteProgrammingLanguageById(int programmingLanguageId) {
        programmingLanguageRepository.deleteProgrammingLanguageById(programmingLanguageId);
    }
}

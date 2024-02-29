package com.karacamehmet.turkcelljavabootcamphomework2.service.abstraction;


import com.karacamehmet.turkcelljavabootcamphomework2.model.entity.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageService {
    ProgrammingLanguage addProgrammingLanguage(ProgrammingLanguage programmingLanguage);

    ProgrammingLanguage updateProgrammingLanguageById(int programmingLanguageId, ProgrammingLanguage newProgrammingLanguage);

    ProgrammingLanguage updateProgrammingLanguageByName(String programmingLanguageName, ProgrammingLanguage newProgrammingLanguage);

    ProgrammingLanguage getProgrammingLanguageById(int programmingLanguageId);

    ProgrammingLanguage getProgrammingLanguageByName(String programmingLanguageName);

    List<ProgrammingLanguage> getAllProgrammingLanguages();

    void deleteProgrammingLanguageByName(String programmingLanguageName);

    void deleteProgrammingLanguageById(int programmingLanguageId);
}

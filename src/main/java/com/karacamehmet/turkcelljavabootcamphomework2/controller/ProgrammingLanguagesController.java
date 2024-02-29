package com.karacamehmet.turkcelljavabootcamphomework2.controller;

import com.karacamehmet.turkcelljavabootcamphomework2.model.entity.ProgrammingLanguage;
import com.karacamehmet.turkcelljavabootcamphomework2.service.abstraction.ProgrammingLanguageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/languages")
public class ProgrammingLanguagesController {
    ProgrammingLanguageService programmingLanguageService;

    public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }


    //adding a new programming language
    @PostMapping("/add")
    public ProgrammingLanguage addProgrammingLanguage(@RequestBody ProgrammingLanguage programmingLanguage) {
        return programmingLanguageService.addProgrammingLanguage(programmingLanguage);
    }

    //updating a programming language with language id given
    @PutMapping("/update/id/{programmingLanguageId}")
    public ProgrammingLanguage updateProgrammingLanguageById(
            @PathVariable int programmingLanguageId, @RequestBody ProgrammingLanguage newProgrammingLanguage) {
        return programmingLanguageService.updateProgrammingLanguageById(programmingLanguageId, newProgrammingLanguage);
    }
    //updating a programming language with language name given
    @PutMapping("/update/name/{programmingLanguageName}")
    public ProgrammingLanguage updateProgrammingLanguageByName(
            @PathVariable String programmingLanguageName, @RequestBody ProgrammingLanguage newProgrammingLanguage) {
        return programmingLanguageService.updateProgrammingLanguageByName(programmingLanguageName, newProgrammingLanguage);
    }
    //getting a programming language with language id given
    @GetMapping("/get/id/{programmingLanguageId}")
    public ProgrammingLanguage getProgrammingLanguageById(@PathVariable int programmingLanguageId) {
        return programmingLanguageService.getProgrammingLanguageById(programmingLanguageId);
    }
    //getting a programming language with language name given
    @GetMapping("/get/name/{programmingLanguageName}")
    public ProgrammingLanguage getProgrammingLanguageByName(@PathVariable String programmingLanguageName) {
        return programmingLanguageService.getProgrammingLanguageByName(programmingLanguageName);
    }
    //getting all programming languages
    @GetMapping("/get/all")
    public List<ProgrammingLanguage> getAllProgrammingLanguages() {
        return programmingLanguageService.getAllProgrammingLanguages();
    }
    //deleting a programming language with language name given
    @DeleteMapping("/delete/name/{programmingLanguageName}")
    public void deleteProgrammingLanguageByName(@PathVariable String programmingLanguageName) {
        programmingLanguageService.deleteProgrammingLanguageByName(programmingLanguageName);
    }
    //deleting a programming language with language id given
    @DeleteMapping("/delete/id/{programmingLanguageId}")
    public void deleteProgrammingLanguageById(@PathVariable int programmingLanguageId) {
        programmingLanguageService.deleteProgrammingLanguageById(programmingLanguageId);
    }
}

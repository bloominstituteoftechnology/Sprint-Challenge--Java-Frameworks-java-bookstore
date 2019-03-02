package com.abrahambueno.librarybooks.controllers;

import com.abrahambueno.librarybooks.models.Section;
import com.abrahambueno.librarybooks.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = {}, produces = MediaType.APPLICATION_JSON_VALUE)
public class SectionController {
    @Autowired
    private SectionRepository sectionrepos;

    @GetMapping("/sections")
    public List<Section> getAllBookDetailInformation() {
        var foundBooks = sectionrepos.findAll();
        if (foundBooks != null) {
            return foundBooks;
        } else {
            return null;
        }
    }
}

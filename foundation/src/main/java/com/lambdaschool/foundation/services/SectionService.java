package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Section;

public interface SectionService {

    Section findById(long id);
    Section save(Section section);
}

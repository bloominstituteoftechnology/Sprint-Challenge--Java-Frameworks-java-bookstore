package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.exceptions.ResourceNotFoundException;
import com.lambdaschool.foundation.models.Section;
import com.lambdaschool.foundation.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "sectionService")
public class SectionServiceImpl implements  SectionService{

@Autowired
   private SectionRepository sectionRepository;
@Override
public Section findById(long id)
{
    return sectionRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Useremail with id " + id + " Not Found!"));
}


    @Override
    public Section save(Section section) {

        return null;
    }
}


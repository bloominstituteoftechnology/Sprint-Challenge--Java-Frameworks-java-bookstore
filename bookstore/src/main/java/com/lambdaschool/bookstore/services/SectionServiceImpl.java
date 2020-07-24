package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.exceptions.ResourceFoundException;
import com.lambdaschool.bookstore.exceptions.ResourceNotFoundException;
import com.lambdaschool.bookstore.models.Section;
import com.lambdaschool.bookstore.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("sectionService")
public class SectionServiceImpl
        implements SectionService
{
    @Autowired
    SectionRepository sectionrepos;

    @Override
    public List<Section> findAll()
    {
        List<Section> list = new ArrayList<>();
        sectionrepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;

    }

    @Override
    public Section findSectionById(long id)
    {
        return sectionrepos.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Section with id " + id + " Not Found!"));
    }

    @Transactional
    @Override
    public void delete(long id)
    {
        Section goodbyeSection = findSectionById(id);
        if (goodbyeSection != null)
        {
            if (goodbyeSection.getBooks()
                    .size() > 0)
            {
                throw new ResourceFoundException("Sections containing books cannot be deleted. Move the books to a new section first");
            } else
            {
                sectionrepos.deleteById(id);
            }
        } else
        {
            throw new ResourceNotFoundException("Section with id " + id + " Not Found!");
        }
    }

    @Transactional
    @Override
    public Section save(Section section)
    {
        if (section.getBooks()
                .size() > 0)
        {
            throw new ResourceFoundException("Book are not added through sections.");
        }

        Section newSection = new Section();

        newSection.setName(section.getName());

        return sectionrepos.save(newSection);
    }

    @Transactional
    @Override
    public Section update(Section section,
                          long id)
    {
        Section currentSection = findSectionById(id);

        if (section.getBooks()
                .size() > 0)
        {
            throw new ResourceFoundException("Book are not updated through sections.");
        }

        if (section.getName() != null)
        {
            currentSection.setName(section.getName());
        }

        return sectionrepos.save(currentSection);
    }

    @Transactional
    @Override
    public void deleteAll()
    {
        sectionrepos.deleteAll();
    }
}

package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.exceptions.ResourceFoundException;
import com.lambdaschool.bookstore.exceptions.ResourceNotFoundException;
import com.lambdaschool.bookstore.models.Author;
import com.lambdaschool.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("authorService")
public class AuthorServiceImpl
        implements AuthorService
{
    @Autowired
    AuthorRepository authorrespos;

    @Override
    public List<Author> findAll()
    {
        List<Author> list = new ArrayList<>();
        authorrespos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Author findAuthorById(long id)
    {
        return authorrespos.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author with id " + id + " Not Found!"));
    }

    @Transactional
    @Override
    public void delete(long id)
    {
        if (authorrespos.findById(id)
                .isPresent())
        {
            authorrespos.deleteById(id);
        } else
        {
            throw new ResourceNotFoundException("Author with id " + id + " Not Found!");
        }
    }

    @Transactional
    @Override
    public Author save(Author author)
    {
        if (author.getWrotes()
                .size() > 0)
        {
            throw new ResourceFoundException("Wrotes are not added through Author.");
        }

        Author newAuthor = new Author();
        newAuthor.setFname(author.getFname());
        newAuthor.setLname(author.getLname());

        return authorrespos.save(newAuthor);
    }

    @Transactional
    @Override
    public Author update(Author author,
                         long id)
    {
        Author currentAuthor = findAuthorById(id);
        if (author.getWrotes()
                .size() > 0)
        {
            throw new ResourceFoundException("Wrotes are not updated through Author.");
        }

        if (author.getFname() != null)
        {
            currentAuthor.setFname(author.getFname());
        }

        if (author.getLname() != null)
        {
            currentAuthor.setLname(author.getLname());
        }
        return authorrespos.save(currentAuthor);
    }

    @Transactional
    @Override
    public void deleteAll()
    {
        authorrespos.deleteAll();
    }

}

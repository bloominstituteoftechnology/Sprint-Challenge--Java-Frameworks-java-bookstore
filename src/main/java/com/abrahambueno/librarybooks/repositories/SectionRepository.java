package com.abrahambueno.librarybooks.repositories;

import com.abrahambueno.librarybooks.models.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Long> {
//    @Query(value = "select  a.firstname, a.lastname, b.booktitle from author a, book b, section, wrote w where w.bookid = b.bookid", nativeQuery = true)
//    List<Object[]> getAllSectionDetails();
}

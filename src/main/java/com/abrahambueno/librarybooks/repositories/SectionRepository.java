package com.abrahambueno.librarybooks.repositories;

import com.abrahambueno.librarybooks.models.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Long> {

}

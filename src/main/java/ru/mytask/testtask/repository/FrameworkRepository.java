package ru.mytask.testtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mytask.testtask.model.FrameworkModel;

import java.util.Collection;

public interface FrameworkRepository extends JpaRepository<FrameworkModel, Long> {

    Collection<FrameworkModel> findAllByLanguage(String language);
}

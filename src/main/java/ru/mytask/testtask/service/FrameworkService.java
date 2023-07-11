package ru.mytask.testtask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mytask.testtask.model.FrameworkModel;
import ru.mytask.testtask.repository.FrameworkRepository;

import java.util.Collection;

@Service
public class FrameworkService {

    @Autowired
    private FrameworkRepository frameworkRepository;

    public FrameworkModel createFramework(FrameworkModel frameworkModel) {

        return frameworkRepository.save(frameworkModel);
    }

    public Collection<FrameworkModel> findAll() {
        return frameworkRepository.findAll();
    }

    public Collection<FrameworkModel> findAllByLanguage(String language) {
        return frameworkRepository.findAllByLanguage(language);
    }
}

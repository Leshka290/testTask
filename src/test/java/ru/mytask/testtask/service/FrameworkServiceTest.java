package ru.mytask.testtask.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mytask.testtask.model.FrameworkModel;
import ru.mytask.testtask.repository.FrameworkRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class FrameworkServiceTest {

    @Mock
    private FrameworkRepository frameworkRepository;

    @InjectMocks
    private FrameworkService frameworkService;

    private final FrameworkModel frameworkTest = new FrameworkModel();

    private static final String LANGUAGE = "Java";
    public FrameworkModel getFrameworkModelTest(FrameworkModel frameworkModel) {
        frameworkModel.setPk(1L);
        frameworkModel.setName("Spring");
        frameworkModel.setLanguage(LANGUAGE);
        return frameworkModel;
    }

    @Test
    public void shouldFindAll() {
        List<FrameworkModel> frameworkModels = new ArrayList<>(List.of(frameworkTest));

        Mockito.when(frameworkRepository.findAll()).thenReturn(frameworkModels);

        frameworkService.createFramework(frameworkTest);

        assertTrue(frameworkService.findAll().containsAll(frameworkModels));
    }

    @Test
    public void shouldGetStudentById() {
        final List<FrameworkModel> frameworkModels = new ArrayList<>(List.of(frameworkTest));
        frameworkModels.add(frameworkTest);
        Mockito.when(frameworkRepository.save(frameworkTest)).thenReturn(getFrameworkModelTest(frameworkTest));
        Mockito.when(frameworkRepository.findAllByLanguage(LANGUAGE)).thenReturn(frameworkModels);
        frameworkService.createFramework(frameworkTest);
        frameworkRepository.save(frameworkTest);

        assertEquals(frameworkModels, frameworkService.findAllByLanguage(LANGUAGE));
    }
}

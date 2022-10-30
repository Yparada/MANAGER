package com.udevtools.service;

import com.udevtools.entity.State;
import com.udevtools.repository.StateRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StateServiceImplTest {
    @InjectMocks
    private StateServiceImpl stateService;

    @Mock
    private StateRepository stateRepository;

    @Test
    public void getAllState(){
        List<State> stateList = new ArrayList<>();
        Mockito.lenient().when(stateRepository.findAll()).thenReturn(stateList);
        List<State> res = stateService.getAllState();
        Assertions.assertNotNull(res);
        Assertions.assertEquals(stateList, res);

    }
}

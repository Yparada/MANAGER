package com.udevtools.controller;

import com.udevtools.entity.State;
import com.udevtools.service.StateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StateControllerTest {
    @InjectMocks
    private StateController stateController;

    @Mock
    private StateService stateService;
    private ResponseEntity<List<State>> getAllStateRes;
    private List<State> getAllStateMock;

    @BeforeEach
    public void setUp(){

    }

    @Test
    public void getAllState(){
        Mockito.lenient().when(stateService.getAllState()).thenReturn(getAllStateMock);
        getAllStateRes = stateController.getAllState();
        Assertions.assertNotNull(getAllStateRes);
        Assertions.assertEquals(getAllStateMock, getAllStateRes.getBody());
    }

}

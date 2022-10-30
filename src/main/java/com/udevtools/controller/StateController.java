package com.udevtools.controller;

import com.udevtools.dto.Mensaje;
import com.udevtools.entity.State;
import com.udevtools.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/state")
@CrossOrigin(origins = "*",allowedHeaders = "*",methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class StateController {

    @Autowired
    StateService stateService;

    @GetMapping("/getAllState")
    public ResponseEntity<List<State>> getAllState(){
        return ResponseEntity.ok(stateService.getAllState());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/createState")
    public ResponseEntity<?> createState(@RequestBody State state){
        State statedb = stateService.findStateByName(state.getName());

        if (statedb != null){
            return new ResponseEntity(new Mensaje("Ya existe un estado con ese nombre"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(stateService.createState(state));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/updateState")
    public ResponseEntity<State> updateState(@RequestBody State state){
        State state1 = stateService.updateState(state);
        if (state1 == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(state1);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteState/{id}")
    public ResponseEntity<State> deleteState(@PathVariable("id") Long id){
        State state = stateService.findStateById(id);

        if (state == null){
            return ResponseEntity.notFound().build();
        }
        stateService.deleteState(id);
        return ResponseEntity.ok(state);
    }
}

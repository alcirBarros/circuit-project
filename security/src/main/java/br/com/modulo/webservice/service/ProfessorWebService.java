package br.com.modulo.webservice.service;

import br.com.modulo.webservice.model.Aluno;
import java.util.ArrayList;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("api/tasks")
public class ProfessorWebService {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Aluno>> findAllTasks() {
        Iterable<Aluno> tasks = new ArrayList<>();
        return ResponseEntity.ok().body(tasks);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Iterable<Aluno>> addTasks(@RequestBody Iterable<Aluno> newTasks) {
        Iterable<Aluno> tasks = new ArrayList<>();
        return ResponseEntity.ok().body(tasks);
    }

}

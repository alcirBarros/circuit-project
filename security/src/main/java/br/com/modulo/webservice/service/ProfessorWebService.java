package br.com.modulo.webservice.service;

import br.com.modulo.webservice.model.AlunoWs;
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
    public ResponseEntity<Iterable<AlunoWs>> findAllTasks() {
        Iterable<AlunoWs> tasks = new ArrayList<>();
        return ResponseEntity.ok().body(tasks);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Iterable<AlunoWs>> addTasks(@RequestBody Iterable<AlunoWs> newTasks) {
        Iterable<AlunoWs> tasks = new ArrayList<>();
        return ResponseEntity.ok().body(tasks);
    }

}

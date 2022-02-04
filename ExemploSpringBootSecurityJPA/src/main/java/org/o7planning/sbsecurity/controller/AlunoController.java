package org.o7planning.sbsecurity.controller;



	import java.util.List;
	import java.util.Optional;

	import javax.validation.Valid;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RestController;

	import org.o7planning.sbsecurity.entity.Aluno;
	import org.o7planning.sbsecurity.repository.AlunoRepository;

	@RestController
	public class AlunoController {
	    @Autowired
	    private AlunoRepository _alunoRepository;

	    @RequestMapping(value = "/aluno", method = RequestMethod.GET)
	    public List<Aluno> Get() {
	        return _alunoRepository.findAll();
	    }

	    @RequestMapping(value = "/aluno/{id}", method = RequestMethod.GET)
	    public ResponseEntity<Aluno> GetById(@PathVariable(value = "id") int id)
	    {
	        Optional<Aluno> aluno = _alunoRepository.findById(id);
	        if(aluno.isPresent())
	            return new ResponseEntity<Aluno>(aluno.get(), HttpStatus.OK);
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    @RequestMapping(value = "/aluno", method =  RequestMethod.POST)
	    public Aluno Post(@Valid @RequestBody Aluno aluno)
	    {
	        return _alunoRepository.save(aluno);
	    }

	    @RequestMapping(value = "/aluno/{id}", method =  RequestMethod.PUT)
	    public ResponseEntity<Aluno> Put(@PathVariable(value = "id") int id, @Valid @RequestBody Aluno newAluno)
	    {
	        Optional<Aluno> oldAluno = _alunoRepository.findById(id);
	        if(oldAluno.isPresent()){
	            Aluno aluno = oldAluno.get();
	            try {
					aluno.setNome(newAluno.getNome());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            _alunoRepository.save(aluno);
	            return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    @RequestMapping(value = "/aluno/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Object> Delete(@PathVariable(value = "id") int id)
	    {
	        Optional<Aluno> aluno = _alunoRepository.findById(id);
	        if(aluno.isPresent()){
	            _alunoRepository.delete(aluno.get());
	            return new ResponseEntity<>(HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
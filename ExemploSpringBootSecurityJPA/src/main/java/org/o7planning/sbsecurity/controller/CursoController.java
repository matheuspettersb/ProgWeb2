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
    import org.o7planning.sbsecurity.entity.Curso;
    import org.o7planning.sbsecurity.repository.AlunoRepository;
	import org.o7planning.sbsecurity.repository.CursoRepository;

	@RestController
	public class CursoController {
	    @Autowired
	    private CursoRepository _cursoRepository;

	    @RequestMapping(value = "/curso", method = RequestMethod.GET)
	    public List<Curso> Get() {
	        return _cursoRepository.findAll();
	    }

	    @RequestMapping(value = "/curso/{id}", method = RequestMethod.GET)
	    public ResponseEntity<Curso> GetById(@PathVariable(value = "id") int id)
	    {
	        Optional<Curso> curso = _cursoRepository.findById(id);
	        if(curso.isPresent())
	            return new ResponseEntity<Curso>(curso.get(), HttpStatus.OK);
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    @RequestMapping(value = "/curso", method =  RequestMethod.POST)
	    public Curso Post(@Valid @RequestBody Curso curso)
	    {
	        return _cursoRepository.save(curso);
	    }

	    @RequestMapping(value = "/curso/{id}", method =  RequestMethod.PUT)
	    public ResponseEntity<Curso> Put(@PathVariable(value = "id") int id, @Valid @RequestBody Curso newCurso)
	    {
	        Optional<Curso> oldCurso = _cursoRepository.findById(id);
	        if(oldCurso.isPresent()){
	            Curso curso = oldCurso.get();
	            try {
					curso.setNome(newCurso.getNome());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            _cursoRepository.save(curso);
	            return new ResponseEntity<Curso>(curso, HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    @RequestMapping(value = "/curso/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Object> Delete(@PathVariable(value = "id") int id)
	    {
	        Optional<Curso> curso = _cursoRepository.findById(id);
	        if(curso.isPresent()){
	            _cursoRepository.delete(curso.get());
	            return new ResponseEntity<>(HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
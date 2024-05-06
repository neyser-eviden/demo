package com.example.demo.controller;

import com.example.demo.model.Obras;
import com.example.demo.service.ObrasServ;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
public class ObrasCont {

	@Autowired
	private ObrasServ obrasServ;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void createObras(@Validated @RequestBody Obras Obras){
    	obrasServ.createObras(Obras);
    }
    @PutMapping("/{id}")
    @ResponseBody
    public void updateObras(@Validated @RequestBody Obras obras,@PathVariable int id){
    	obrasServ.updateObras(obras,id);

    }
    
    @GetMapping
    @ResponseBody
    public List<Obras> listObras() {
    	return obrasServ.listObras();
    }
     
    @GetMapping("/{id}")
    @ResponseBody
    public Obras getObrasId(@PathVariable int id) {
    	return obrasServ.getObrasId(id);
    }
    
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void deleteObras(@PathVariable int id) {
    	obrasServ.deleteObras(id);
    }
}

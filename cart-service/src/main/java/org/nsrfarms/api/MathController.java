package org.nsrfarms.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@Data
class Input{
	int a;
	int b;
	
}

@Data
class Output{
	public Output(int i) {
		this.result = i;
	}

	int result;
	
}

@RestController
@RequestMapping("/math")
public class MathController {
	
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity<Output> add(@RequestBody Input input){
		LOGGER.info(" Input : {}", input); 
		return new ResponseEntity<Output>(new Output((input.getA()+input.getB())),HttpStatus.OK);
	}
	
	@GetMapping("/get/{no}")
	@ResponseBody
	public ResponseEntity<List<Integer>> getNos(@PathVariable Integer no){
		List<Integer> list= new ArrayList<Integer>();
		for(Integer i =1;i<=no;i++) {
			list.add(i);
		}
		LOGGER.info(" List : {}", list); 
		return new ResponseEntity<List<Integer>>(list ,HttpStatus.OK);
	}
}

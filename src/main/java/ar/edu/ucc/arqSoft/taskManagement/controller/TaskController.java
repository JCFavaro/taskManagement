package ar.edu.ucc.arqSoft.taskManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ar.edu.ucc.arqSoft.common.dto.GenericExceptionDto;
import ar.edu.ucc.arqSoft.common.exception.BadRequestException;
import ar.edu.ucc.arqSoft.common.exception.EntityNotFoundException;
import ar.edu.ucc.arqSoft.taskManagement.dto.TaskRequestDto;
import ar.edu.ucc.arqSoft.taskManagement.dto.TaskResponseDto;
import ar.edu.ucc.arqSoft.taskManagement.service.TaskService;

@Controller
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Object> lookupTaskById(@PathVariable("id") Long id) {
		try {

			TaskResponseDto dto = taskService.getTaskById(id);
			return new ResponseEntity<Object>(dto, HttpStatus.OK);

		} catch (EntityNotFoundException e) {
			GenericExceptionDto exDto = new GenericExceptionDto("1001", "Task not found");
			return new ResponseEntity<Object>(exDto, HttpStatus.NOT_FOUND);
		} catch (BadRequestException e) {
			GenericExceptionDto exDto = new GenericExceptionDto("1002", "No se entendió que buscar");
			return new ResponseEntity<Object>(exDto, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public @ResponseBody TaskResponseDto registerTask(@RequestBody TaskRequestDto request)
			throws EntityNotFoundException, BadRequestException {
		return taskService.registerTask(request);
	}

	@RequestMapping(value = "/{taskID}/assignuser", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Object> changeUser(@PathVariable("taskID") Long taskID,
			@RequestBody Long userID) throws EntityNotFoundException, BadRequestException {
		TaskResponseDto dto = taskService.changeUser(taskID, userID);
		return new ResponseEntity<Object>(dto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{taskID}/changestate", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Object> changeState(@PathVariable("taskID") Long taskID,
			@RequestBody Long stateID) throws EntityNotFoundException, BadRequestException {
		TaskResponseDto dto = taskService.changeState(taskID, stateID);
		return new ResponseEntity<Object>(dto, HttpStatus.OK);
	}

}

package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Classroom;
import com.service.ClassroomService;

@RestController
@RequestMapping("/api/classrooms")

public class ClassroomController {

	@Autowired
	private ClassroomService classroomService;

	@GetMapping
	public List<Classroom> getAllClassrooms() {
		Classroom c1 = new Classroom(1, "abcd");
		Classroom c2 = new Classroom(2, "pqr");
		ArrayList<Classroom> list = new ArrayList();
		list.add(c1);
		list.add(c2);
		return list;
	}

	@GetMapping("/{id}")
	public Classroom getClassroomById(@PathVariable Long id) {
		return classroomService.getClassroomById(id);
	}

	@PostMapping
	public Classroom createClassroom(@RequestBody Classroom classroom) {
		classroomService.saveClassroom(classroom);
		return classroom;
	}

	@PutMapping("/{id}")
	public Classroom updateClassroom(@PathVariable Long id, @RequestBody Classroom classroomDetails) {
		Classroom classroom = classroomService.getClassroomById(id);
		if (classroom != null) {
			classroom.setName(classroomDetails.getName());
			classroomService.saveClassroom(classroom);
		}
		return classroom;
	}

	@DeleteMapping("/{id}")
	public void deleteClassroom(@PathVariable Long id) {
		classroomService.deleteClassroom(id);
	}
}
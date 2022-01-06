package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.constant.ConstantURL;
import com.exam.model.Menu;
import com.exam.service.MenuService;

@RestController
@Component
@CrossOrigin("*")
@RequestMapping(ConstantURL.Menu_Controller)
public class MenuController {

	@Autowired
	private MenuService menuService;

//	 ADD MENU
	@PostMapping("/")
	public ResponseEntity<Menu> addMenu(@RequestBody Menu menu) {

		return ResponseEntity.ok(this.menuService.addMenu(menu));

	}

////	 UPDATE QUIZ
//	@PutMapping("/")
//	public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz) {
//		if (quiz.getCreatedDate() == null) {
//			quiz.setCreatedDate(LocalDateTime.now());
//		}
//		return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
//
//	}
//
//	 GET ALL MENUS
	@GetMapping("/")
	public ResponseEntity<?> getMenus() {
		return ResponseEntity.ok(this.menuService.getMenus());

	}
//
////	 GET SINGLE QUIZ BY ID
//	@GetMapping("/{qid}")
//	public Quiz getQuiz(@PathVariable("qid") Long qid) {
//		return this.quizService.getQuiz(qid);
//
//	}
//
////	 DELETE QUIZ BY ID
//	@DeleteMapping("/{qid}")
//	public void deleteQuiz(@PathVariable("qid") Long qid) {
//		this.quizService.deleteQuiz(qid);
//
//	}
//	
//	@GetMapping("/category/{cid}")
//	public List<Quiz> getQuizzesOfCategory(@PathVariable("cid") Long cid){
//		Category category = new Category();
//		category.setCid(cid);
//		return this.quizService.getQuizzesOfCategory(category);
//	}
//	
////	Get Active Quizzes
//	@GetMapping("/active")
//	public List<Quiz> getActiveQuizzes(){
//		return this.quizService.getActiveQuizzes();
//	}
//	
////	Get Active Quizzes of Category
//	@GetMapping("/category/active/{cid}")
//	public List<Quiz> getActiveQuizzes(@PathVariable("cid") Long cid){
//		Category category = new Category();
//		category.setCid(cid);
//		return this.quizService.getActiveQuizzesOfCategory(category);
//	}

}

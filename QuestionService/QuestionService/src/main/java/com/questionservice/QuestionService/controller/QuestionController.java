package com.questionservice.QuestionService.controller;


import com.questionservice.QuestionService.model.Book;
import com.questionservice.QuestionService.model.Question;
import com.questionservice.QuestionService.model.QuestionWrapper;
import com.questionservice.QuestionService.model.Response;
import com.questionservice.QuestionService.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    Environment environment;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return  questionService.addQuestion(question);
    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz
            (@RequestParam String categoryName, @RequestParam Integer numQuestions ){
        return questionService.getQuestionsForQuiz(categoryName, numQuestions);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds){
        System.out.println(environment.getProperty("local.server.port"));
        return questionService.getQuestionsFromId(questionIds);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses)
    {
        return questionService.getScore(responses);
    }


    @PostMapping("addABook")
    public ResponseEntity<Book> addABook(@RequestBody Book book){
        return ResponseEntity.ok(questionService.addBook(book));
    }

    @GetMapping("findAllBooks")
    public ResponseEntity<List<Book>> getAllBooks(){
        System.out.println(environment.getProperty("local.server.port"));
        return ResponseEntity.ok(questionService.getAllBooks());
    }
    // generate
    // getQuestions (questionid)
    // getScore

}


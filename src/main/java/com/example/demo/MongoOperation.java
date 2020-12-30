package com.example.demo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongodb.client.MongoDatabase;


public interface MongoOperation extends MongoRepository<QuizQuestions, String> {

	//List<QuizQuestions> findAll(String category); 
}

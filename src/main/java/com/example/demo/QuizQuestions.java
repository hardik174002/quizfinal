package com.example.demo;

import java.util.Arrays;

import javax.annotation.Generated;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "QuizQuestions")
public class QuizQuestions {
	
	@org.springframework.data.annotation.Id
	private String id;
	
    public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	private String category;
	@Override
	public String toString() {
		return "QuizQuestions [category=" + category + ", question=" + question + ", option=" + Arrays.toString(option)
				+ ", correctOption=" + correctOption + "]";
	}
	private String question;
	private String []option =new String[3];
	private int correctOption;
	
	
	
	
	public QuizQuestions(String category,String question, String[] option, int correctOption) {
		super();
		this.question = question;
		this.category=category;
		this.option = option;
		this.correctOption = correctOption;
	}
	
	
	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String[] getOption() {
		return option;
	}
	public void setOption(String[] option) {
		this.option = option;
	}
	public int getCorrectOption() {
		return correctOption;
	}
	public void setCorrectOption(int correctOption) {
		this.correctOption = correctOption;
	}
	
	
}

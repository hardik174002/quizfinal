package com.example.demo;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import javax.websocket.server.PathParam;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.ModelAndView;


@Controller
public class ControlUnit {

@Autowired
private  MongoOperation op;
	
	private static  List<QuizQuestions> list=new ArrayList<QuizQuestions>();

	private static List<QuizQuestions> quizie=new ArrayList<>();
	
	@ResponseBody
	@GetMapping("/getAllType")
	public List mainPage() {
		return list;
	}
	
	@RequestMapping("/startQuiz")
	public ModelAndView startQuiz(ModelMap mp, @PathParam("quizType") String quizType) {
		  quizie.clear();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getCategory().equalsIgnoreCase(quizType)) {
				quizie.add(list.get(i));
			}
		}
		System.out.println("SIZE = "+quizie.size());
		  ModelAndView modelAndView = new ModelAndView("startingpage");
		   modelAndView.addObject("list",quizie);
		   modelAndView.addObject("initially", 0);
		   modelAndView.addObject("quizOver", null);
		    return modelAndView;
	}
	
	@RequestMapping("/")
	public String homePage(ModelMap mp) {
		list=op.findAll();
		LinkedHashSet<String> hash=new LinkedHashSet<>();
		for(int i=0;i<list.size();i++) {
			hash.add(list.get(i).getCategory());
		}
		mp.put("list",hash);
		return "Start";
	}
	
	
	
	
	@RequestMapping("/nextQuestion")
	public String nextQuestion(ModelMap mp,@PathParam("currentValue")int currentValue) {
		System.out.println(currentValue);
		int incrementNumber=++currentValue;
		System.out.println("CRT = " +quizie.size()+incrementNumber);
		if(quizie.size()>incrementNumber) {
		mp.put("list",quizie);
		mp.put("quizOver",null);
		mp.put("initially", incrementNumber);
		System.out.println("CR = " +incrementNumber);
		}
		else
			mp.put("quizOver", "Quiz Is Over");
		return "startingpage";
	}
	
	@ResponseBody
	@RequestMapping(value="/checkingResult")
	public String resultCheck(@PathParam("value")String value ,@PathParam("indexNumber") int indexNumber) {
		if(value!=null && indexNumber>=0) {
		String arr[]=quizie.get(indexNumber).getOption();
		int res1=quizie.get(indexNumber).getCorrectOption();
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
			if(arr[i].equalsIgnoreCase(value)) {
			int res=i;
			if(res==res1) {
			return "true";
			}
			}
		}
		}
		return "False";
	}
	

	
	@RequestMapping(value="/checkingResultForWebsite")
	public String resultCheckForWebsite(@PathParam("value")String value ,@PathParam("indexNumber") int indexNumber,ModelMap mp) {
		if(value!=null && indexNumber>=0) {
		String arr[]=quizie.get(indexNumber).getOption();
		int res1=quizie.get(indexNumber).getCorrectOption();
		mp.put("list", quizie);
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
			if(arr[i].equalsIgnoreCase(value)) {
				
			int res=i;
			if(res==res1) {
			mp.put("result", "Correct");
			}
			else {
				mp.put("result","False");
			}
			}
		}
		}
		else {
		mp.put("result","False");
		}
	  mp.put("initially",indexNumber);
		return "startingpage";
		
	}

	@ResponseBody
	@GetMapping("/category/{category}")
	public List<QuizQuestions> categoryWiseReterive(@PathVariable("category")String category,ModelMap mp)  {
		System.out.println("Searching For "+category);
		List<QuizQuestions> quiz=new ArrayList<QuizQuestions>();
		for(int i=0;i<list.size();i++) {
			QuizQuestions q=list.get(i);
			if(q.getCategory().equalsIgnoreCase(category)) {
				quiz.add(q);
			}
		}
		mp.addAttribute(quiz);
		return quiz;
	}

	@ResponseBody
	@GetMapping("/getCategory")
	public LinkedHashSet<String> getCategory(){
		list=op.findAll();
		LinkedHashSet<String> strList=new LinkedHashSet<>();
		for(int i=0;i<list.size();i++) {
			strList.add(list.get(i).getCategory());
		}
		return strList;
	}
	
	@RequestMapping("/backToMenu")
	public String returnToPage(@PathParam("back") String back,ModelMap mp) {
		list=op.findAll();
		LinkedHashSet<String> hash=new LinkedHashSet<>();
		for(int i=0;i<list.size();i++) {
			hash.add(list.get(i).getCategory());
		}
		mp.put("list",hash);
		return "Start";
	}

}

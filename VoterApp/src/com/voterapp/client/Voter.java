package com.voterapp.client;

import java.util.Scanner;

import com.voterapp.exception.InvalidVoterException;
import com.voterapp.service.ElectionBoothImpl;
import com.voterapp.service.IElectionBooth;

public class Voter {
public static void main(String[] args) {
	System.out.println("Welcome to Electionbooth");
	Scanner scanner = new Scanner(System.in);
	System.out.println("your age");
	int age =scanner.nextInt(); 
	System.out.println("your locality");
	String locality = scanner.next();
	System.out.println("your voter id number");
	int voterId = scanner.nextInt();
	IElectionBooth electinBooth = new ElectionBoothImpl();
		
	try {
		boolean check = electinBooth.checkEligibility(age, locality, voterId);
		if(check) {
			System.out.println("your eligible");
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	scanner.close();
	}
}

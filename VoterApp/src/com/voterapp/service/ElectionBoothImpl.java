package com.voterapp.service;

import com.voterapp.exception.InvalidVoterException;
import com.voterapp.exception.LocalityNotFoundException;
import com.voterapp.exception.NoVoterIdException;
import com.voterapp.exception.UnderAgeException;

public class ElectionBoothImpl implements IElectionBooth {
String[] ref= {"Bangalore","Yelahanka","Hebbala","Rajajinagar"};


	@Override
	public boolean checkEligibility(int age, String locality, int voterId) throws InvalidVoterException {
		try {
			checkAge(age);
			checkLocality(locality);
			checkVoterId(voterId);

		} catch (UnderAgeException e) {
			throw e;
		} catch(LocalityNotFoundException e) {
			throw e;
		}catch(NoVoterIdException e) {
			throw e;
		}
	    return false;
	}
	private boolean checkVoterId(int voterId) throws NoVoterIdException{
		if(voterId < 100 || voterId >8888) {
     throw new NoVoterIdException("Voter id is invalid");
	}
		return true;
	}

	private boolean checkLocality(String locality) throws LocalityNotFoundException{
		for(String checklocality : ref)
			if(checklocality.equalsIgnoreCase(locality)) {
		//	throw new LocalityNotFoundException("locality is not found");	
				return true;
			}
		 throw new LocalityNotFoundException("locality is not found");	
     // return true;
	}
	
	private boolean checkAge(int age) throws UnderAgeException {
		if(age>18)
			throw new UnderAgeException("Not eligible for voting");
		return true;
	}

}

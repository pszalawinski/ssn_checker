package org.pawel.steps.NameSteps;

public abstract class WordStep {

	String name;
	WordStep nextProcessor;
	private WordStep(){

	}
	public WordStep(String name){
		this.name=name;
	}
	public abstract void setNext(WordStep nextProcessor);

	public boolean isNameValid (String name)
	{
		if(this.nextProcessor != null)
			this.nextProcessor.isNameValid(name);
		return false;
	}

}

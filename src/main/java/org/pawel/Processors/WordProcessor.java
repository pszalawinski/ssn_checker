package org.pawel.Processors;

public abstract class WordProcessor {

	String name;
	WordProcessor nextProcessor;
	private WordProcessor(){

	}
	public WordProcessor(String name){
		this.name=name;
	}
	public abstract void setNext(WordProcessor nextProcessor);

	public boolean isNameValid (String name)
	{
		if(this.nextProcessor != null)
			this.nextProcessor.isNameValid(name);
		return false;
	}

}

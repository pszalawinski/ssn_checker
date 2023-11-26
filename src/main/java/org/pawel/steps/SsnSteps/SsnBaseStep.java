package org.pawel.steps.SsnSteps;

public abstract class SsnBaseStep {

	String name;
	SsnBaseStep nextProcessor;

	private SsnBaseStep() {
	}

	public SsnBaseStep(String name) {
		this.name = name;
	}

	public abstract void setNext(SsnBaseStep nextProcessor);

	public boolean isSsnValid(String name) {
		if (this.nextProcessor != null) {
			this.nextProcessor.isSsnValid(name);
		}
		return false;
	}

}

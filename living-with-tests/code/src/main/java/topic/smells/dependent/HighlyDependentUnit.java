package topic.smells.dependent;

public class HighlyDependentUnit {

	private final DependencyOne dependencyOne;
	private final DependencyTwo dependencyTwo;
	private final DependencyThree dependencyThree;
	private final DependencyFour dependencyFour;
	private final DependencyFive dependencyFive;
	private final DependencySix dependencySix;

	public HighlyDependentUnit(DependencyOne dependencyOne, DependencyTwo dependencyTwo, DependencyThree dependencyThree, DependencyFour dependencyFour, DependencyFive dependencyFive, DependencySix dependencySix) {
				this.dependencyOne = dependencyOne;
				this.dependencyTwo = dependencyTwo;
				this.dependencyThree = dependencyThree;
				this.dependencyFour = dependencyFour;
				this.dependencyFive = dependencyFive;
				this.dependencySix = dependencySix;
	}

	public String workSomethingOut(String something) {
		doSomeChecksAgainstSomeDependencies();
		if (dependencyFive.someMethod() != null) {
			return something + dependencySix.someMethod();
		}
		return null; 
	}

	private void doSomeChecksAgainstSomeDependencies() {
		if (dependencyOne.someMethod() == null
				|| dependencyTwo.someMethod() == null
				|| dependencyThree.someMethod() == null
				|| dependencyFour.someMethod() == null) {
			throw new IllegalStateException();
		}
	}

}

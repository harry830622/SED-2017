public abstract class Duck {

	protected String duckType;

	private FlyMode flyMode;
	private QuackMode quackMode;

	protected Duck(String duckType)
	{
		this.duckType = duckType;
	}

	public void swim()
	{
		System.out.println( duckType + " is swimming");
	}

	public void fly()
	{
		if (flyMode != null)
			flyMode.fly();
	}

	public void quack()
	{
		if (quackMode != null)
			quackMode.quack();
	}

	public void setFly(FlyMode flyMode)
	{
		this.flyMode = flyMode;
	}

	public void setQuack(QuackMode quackMode)
	{
		this.quackMode = quackMode;
	}
}
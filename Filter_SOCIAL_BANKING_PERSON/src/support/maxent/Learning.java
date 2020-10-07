package maxent;

public class Learning {

	private final String klass;
	private final String text;

	public Learning(String klass, String text) {
		this.klass = klass;
		this.text = text;
	}

	public String getKlass() {
		return klass;
	}

	public String getText() {
		return text;
	}
}

package a;


class task implements Runnable {
	private String message;


	public task(String message) {
		this.message = message;
	}

	public void run() {
		for(int i=0;i<1000;i++)
	System.out.println(message);

	}

}

package miniWat;

public class Threadin implements Runnable {
	public Threadin(){
		
	}
	public static void main(String[] args){
		Threadin t = new Threadin();
		t.run();
	}

	
	public void run() {
		System.out.println("yep");
		
	}
}

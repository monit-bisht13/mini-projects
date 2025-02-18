package banking;

public class Main {

	 public static void main(String[] args) {
	        Jdbc.getConnection();
	        Menu m = new Menu();
	        m.menu1();
	    }
}
public class Launch{

    public static void main (String[] args){

    try {
		new Runner();
	} catch (Exception e) {
        System.out.println(e);
		e.printStackTrace();
	}
    }
}

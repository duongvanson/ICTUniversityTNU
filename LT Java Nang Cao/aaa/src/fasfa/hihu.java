package fasfa;

public class hihu {
	boolean check() {
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x= "abccba";
		x.trim();
		int l = x.length();
		//System.out.println(l);
		for (int i = 0; i < l/2; i++) {
			if(x.charAt(i) != x.charAt(l-i-1)) {
				System.out.println("not");
				break;
			}
		}
	}

}

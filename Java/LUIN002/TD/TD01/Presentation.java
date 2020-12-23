public class Presentation{

	public static void main(String args[]){

		int i = 0;
		Personne p1 = new Personne("Paul", 25);
		Personne p2 = new Personne("Pierre", 37);

		System.out.println(p2.toString());
		p1.sePresenter();

		for (i = 0; i < 20; i++)
			p1.vieillir();
		i = 0;
		while (i < 10){
			p2.vieillir();
			i++;
		}
		System.out.println(p2.toString());
		p1.sePresenter();
	}
}

package modelo;

public class Ladrillo {

	public boolean destruido = false;
	public double x, y;
	public double tamanoX;
	public double tamanoY;
	public double anchoLadrillo = 60;
	public double altoLadrillo = 20;
	public static final int ladrillosEnX = 5;
	public static final int ladrillosEnY = 5;


	public Ladrillo(double x, double y) {
		this.x = x;
		this.y = y;
		destruido = false;
		tamanoX = anchoLadrillo;
		tamanoY = altoLadrillo;
	}
	
//	public void inicializarLadrillos(List<Ladrillo> ladrillo) {   // REVISAR
//		ladrillo.clear(); //borro si habia ladrillos
//
//		for (int iX = 0; iX < ladrillosEnX; ++iX) {
//			for (int iY = 0; iY < ladrillosEnY; ++iY) {
//				ladrillo.add(new Ladrillo((iX + 1) * (anchoLadrillo + 3) + 22,
//						(iY + 2) * (altoLadrillo + 3) + 20));
//			}
//		}
//	}

}
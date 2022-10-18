import java.awt.*;
import java.util.Scanner;

public class Sierpinski {

	public static final int SIZE = 512;
	public static final int TRIANGLE_HEIGHT = (int) Math.round(SIZE * Math.sqrt(3.0) / 2);
	public static final DrawingPanel panel = new DrawingPanel(SIZE, SIZE);
	public static final Graphics g = panel.getGraphics();
	public static void main(String[] args) {
		while (true) {
			Scanner console = new Scanner(System.in);
			System.out.println("How many levels do you want?");
			int level = console.nextInt();
			panel.clear();
			Point p1 = new Point(0, TRIANGLE_HEIGHT);
			Point p2 = new Point(SIZE / 2, 0);
			Point p3 = new Point(SIZE, TRIANGLE_HEIGHT);
			drawTriangle(p1, p2, p3, level);
		}

	}

	private static void drawTriangle(Point p1, Point p2, Point p3, int level) {
		if (level == 1) {
			Polygon triangle = new Polygon();
			triangle.addPoint(p1.x, p1.y);
			triangle.addPoint(p2.x, p2.y);
			triangle.addPoint(p3.x, p3.y);
			g.fillPolygon(triangle);
		} else {
			Point p4 = midpoint(p1, p2);
			Point p5 = midpoint(p2, p3);
			Point p6 = midpoint(p1, p3);
			drawTriangle(p1, p4, p6, level - 1);
			drawTriangle(p4, p2, p5, level - 1);
			drawTriangle(p6, p5, p3, level - 1);

		}

	}

	private static Point midpoint(Point p1, Point p2) {
		return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
	}
}

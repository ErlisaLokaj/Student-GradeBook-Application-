package erlisa;

public class Exam {
	private String description;
	private double points;

	public Exam() {
		description = "Exam ";
		points = 0;
	}

	public Exam(String d, double p) {
		description = d;
		points = p;
	}

	public String getDescription() {
		return description;
	}

	public double getPoints() {
		return points;
	}

	public void setDescription(String d) {
		description = d;
	}

	public void setPoints(double p) {
		points = p;
	}
}

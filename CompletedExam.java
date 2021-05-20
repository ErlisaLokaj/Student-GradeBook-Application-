package erlisa;

public class CompletedExam extends Exam {
	double pointsEarned;
	int grade;

	public CompletedExam() {
		setDescription("Exam");
		setPoints(0);
		pointsEarned = (0);
	}

	public CompletedExam(Exam e, double p) {
		setDescription(e.getDescription());
		setPoints(e.getPoints());
		pointsEarned = p;
	}

	public double getPointsEarned() {
		return pointsEarned;
	}

	public void setPointsEarned(double p) {
		pointsEarned = p;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int g) {
		grade = g;
	}

	public String toString() {
		return "Provimi: " + super.getDescription() + "\n" + "Pikët: " + getPointsEarned() / getPoints() * 100 + "\n"
				+ "Nota: " + getGrade();
	}
}


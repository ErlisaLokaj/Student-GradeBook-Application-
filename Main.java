package erlisa;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		GradeBook myGradeBook = new GradeBook();
		boolean x = false;
		while (x == false) {
			String input = JOptionPane.showInputDialog(null, "Mirësevini në Student GradeBook Application!" + "\n"
					+ "Shtypni numrin përkatës për komanden e dëshiruar: " + "\n" + "1. Krijo një student." + "\n"
					+ "2. Modifiko një student." + "\n" + "3. Largo një student dhe të dhënat e tij përkatëse." + "\n"
					+ "4. Krijo një provim." + "\n" + "5. Cakto notë studentëve për një provim." + "\n"
					+ "6. Shfaq të dhënat e një studenti." + "\n" + "7. Shfaq të dhënat e të gjithë studentëve." + "\n"
					+ "8. Mbyll programin.");
			int y = Integer.parseInt(input);

			switch (y) {
			case 1: {
				String input1 = JOptionPane.showInputDialog(null, "Shkruaj emrin e studentit që doni të krijoni: ");
				String input2 = JOptionPane.showInputDialog(null, "Shkruaj mbiemrin e studentit që doni të krijoni: ");
				myGradeBook.addStudent(new Student(input1, input2));
				JOptionPane.showMessageDialog(null,
						input1 + " " + input2 + " është shtuar në menyrë të suksesshme në GradeBook.");
				break;
			}
			case 2: {
				String input3 = JOptionPane.showInputDialog(null,
						"Shkruaj indeksin e studentit emrin e të cilit dëshironi të modifikoni si dhe emrin e tij të ri:");
				String[] input3Array = input3.split(" ");
				for (int i = 2; i < input3Array.length; i++)
					input3Array[1] = input3Array[1] + " " + input3Array[i];
				input3Array[1].trim();
				myGradeBook.getStudent(Integer.parseInt(input3Array[0])).setName(input3Array[1]);
				JOptionPane.showMessageDialog(null, "Studenti në pozitën " + input3Array[0] + " tani ka emrin: "
						+ myGradeBook.getStudent(Integer.parseInt(input3Array[0])).getName());

				String input4 = JOptionPane.showInputDialog(null,
						"Shkruaj indeksin e studentit mbiemrin e të cilit dëshironi të modifikoni si dhe mbiemrin e tij të ri:");
				String[] input4Array = input4.split(" ");
				for (int i = 2; i < input4Array.length; i++)
					input4Array[1] = input4Array[1] + " " + input4Array[i];
				input4Array[1].trim();
				myGradeBook.getStudent(Integer.parseInt(input4Array[0])).setSurname(input4Array[1]);
				JOptionPane.showMessageDialog(null, "Studenti në pozitën " + input4Array[0] + " tani ka mbiemrin: "
						+ myGradeBook.getStudent(Integer.parseInt(input4Array[0])).getSurname());
				break;
			}

			case 3: {
				String input5 = JOptionPane.showInputDialog(null,
						"Shkruaj indeksin e studemtit që dëshironi të largoni:");
				myGradeBook.removeStudent(Integer.parseInt(input5));
				JOptionPane.showMessageDialog(null, "Studenti në pozitën " + " " + input5 + " është larguar. ");
				break;
			}

			case 4: {
				String desc = JOptionPane.showInputDialog(null, "Shkruani një përshkrim(emër) për provimin:");
				String tp = JOptionPane.showInputDialog(null,
						"Shkruni numrin total të pikëve që mund të fitohen për: " + desc);
				Exam ex = new Exam(" " + desc, Integer.parseInt(tp));
				String e = JOptionPane.showInputDialog(null, "Provimi  " + desc
						+ " u krijua. Ju lutemi shtypni indeksat e studenteve të cilëve doni t'ja caktoni, nëse dëshironi t'ja caktoni të gjithëve shtypni enter: ");
				if (e.equals("")) {
					for (int i = 0; i < myGradeBook.size(); i++)
						myGradeBook.getStudent(i).addExam(ex, ex.getPoints());
					JOptionPane.showMessageDialog(null, desc + " është shtuar në mënyrë të suksesshme në GradeBook.");
				} else {
					String[] ee = e.split(" ");
					for (int i = 0; i < ee.length; i++)
						myGradeBook.getStudent(Integer.parseInt(ee[i])).addExam(ex, ex.getPoints());
					JOptionPane.showMessageDialog(null, desc + " është shtuar në mënyrë të suksesshme në GradeBook.");
				}
				break;
			}

			case 5: {
				String sd = JOptionPane.showInputDialog(null,
						"Shkruaj indeksin e studentit që do të pranoj një notë: ");
				String exm = JOptionPane.showInputDialog(null,
						"Shkruaj indeksin e provimit që studenti do të notohet: ");
				String p = JOptionPane.showInputDialog(null,
						"Shkruani numrin e pikeve të fituara të studentit në atë provim:");
				myGradeBook.getStudent(Integer.parseInt(sd)).getExam(Integer.parseInt(exm))
						.setPointsEarned(Double.parseDouble(p));
				String n = JOptionPane.showInputDialog(null, "Bazuar në pikët e fituara të studentit shkruani notën që studenti meriton: ");
				myGradeBook.getStudent(Integer.parseInt(sd)).getExam(Integer.parseInt(exm))
						.setGrade(Integer.parseInt(n));
				break;
			}

			case 6: {
				String in = JOptionPane.showInputDialog(null,
						"Shkruaj indeksin e studentit që dëshiron t'i shikosh të dhënat :");
				int index = Integer.parseInt(in);
				for (int i = 0; i < myGradeBook.getStudent(index).getNumberOfExams(); i++)
					JOptionPane.showMessageDialog(null,
							"Emri: " + myGradeBook.getStudent(index).getName() + "\n" + "Mbiemri: "
									+ myGradeBook.getStudent(index).getSurname()+ "\n"
									+ myGradeBook.getStudent(index).getExam(i).toString());
				break;
			}
			case 7: {
				for (int index = 0; index < myGradeBook.size(); index++) {
					for (int i = 0; i < myGradeBook.getStudent(index).getNumberOfExams(); i++)
						JOptionPane.showMessageDialog(null,
								"Emri: " + myGradeBook.getStudent(index).getName() + "\n" + "Mbiemri: "
										+ myGradeBook.getStudent(index).getSurname()+"\n"
										+ myGradeBook.getStudent(index).getExam(i).toString());
				}
				break;
			}
			case 8:
				x = true;
				break;
			default:
				JOptionPane.showMessageDialog(null, "Ju lutemi provoni përsëri", "Syntax Error",
						JOptionPane.ERROR_MESSAGE);
				break;
			}

		}
	}

}

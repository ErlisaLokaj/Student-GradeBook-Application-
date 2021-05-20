package erlisa;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		GradeBook myGradeBook = new GradeBook();
		boolean x = false;
		while (x == false) {
			String input = JOptionPane.showInputDialog(null, "Mir�sevini n� Student GradeBook Application!" + "\n"
					+ "Shtypni numrin p�rkat�s p�r komanden e d�shiruar: " + "\n" + "1. Krijo nj� student." + "\n"
					+ "2. Modifiko nj� student." + "\n" + "3. Largo nj� student dhe t� dh�nat e tij p�rkat�se." + "\n"
					+ "4. Krijo nj� provim." + "\n" + "5. Cakto not� student�ve p�r nj� provim." + "\n"
					+ "6. Shfaq t� dh�nat e nj� studenti." + "\n" + "7. Shfaq t� dh�nat e t� gjith� student�ve." + "\n"
					+ "8. Mbyll programin.");
			int y = Integer.parseInt(input);

			switch (y) {
			case 1: {
				String input1 = JOptionPane.showInputDialog(null, "Shkruaj emrin e studentit q� doni t� krijoni: ");
				String input2 = JOptionPane.showInputDialog(null, "Shkruaj mbiemrin e studentit q� doni t� krijoni: ");
				myGradeBook.addStudent(new Student(input1, input2));
				JOptionPane.showMessageDialog(null,
						input1 + " " + input2 + " �sht� shtuar n� menyr� t� suksesshme n� GradeBook.");
				break;
			}
			case 2: {
				String input3 = JOptionPane.showInputDialog(null,
						"Shkruaj indeksin e studentit emrin e t� cilit d�shironi t� modifikoni si dhe emrin e tij t� ri:");
				String[] input3Array = input3.split(" ");
				for (int i = 2; i < input3Array.length; i++)
					input3Array[1] = input3Array[1] + " " + input3Array[i];
				input3Array[1].trim();
				myGradeBook.getStudent(Integer.parseInt(input3Array[0])).setName(input3Array[1]);
				JOptionPane.showMessageDialog(null, "Studenti n� pozit�n " + input3Array[0] + " tani ka emrin: "
						+ myGradeBook.getStudent(Integer.parseInt(input3Array[0])).getName());

				String input4 = JOptionPane.showInputDialog(null,
						"Shkruaj indeksin e studentit mbiemrin e t� cilit d�shironi t� modifikoni si dhe mbiemrin e tij t� ri:");
				String[] input4Array = input4.split(" ");
				for (int i = 2; i < input4Array.length; i++)
					input4Array[1] = input4Array[1] + " " + input4Array[i];
				input4Array[1].trim();
				myGradeBook.getStudent(Integer.parseInt(input4Array[0])).setSurname(input4Array[1]);
				JOptionPane.showMessageDialog(null, "Studenti n� pozit�n " + input4Array[0] + " tani ka mbiemrin: "
						+ myGradeBook.getStudent(Integer.parseInt(input4Array[0])).getSurname());
				break;
			}

			case 3: {
				String input5 = JOptionPane.showInputDialog(null,
						"Shkruaj indeksin e studemtit q� d�shironi t� largoni:");
				myGradeBook.removeStudent(Integer.parseInt(input5));
				JOptionPane.showMessageDialog(null, "Studenti n� pozit�n " + " " + input5 + " �sht� larguar. ");
				break;
			}

			case 4: {
				String desc = JOptionPane.showInputDialog(null, "Shkruani nj� p�rshkrim(em�r) p�r provimin:");
				String tp = JOptionPane.showInputDialog(null,
						"Shkruni numrin total t� pik�ve q� mund t� fitohen p�r: " + desc);
				Exam ex = new Exam(" " + desc, Integer.parseInt(tp));
				String e = JOptionPane.showInputDialog(null, "Provimi  " + desc
						+ " u krijua. Ju lutemi shtypni indeksat e studenteve t� cil�ve doni t'ja caktoni, n�se d�shironi t'ja caktoni t� gjith�ve shtypni enter: ");
				if (e.equals("")) {
					for (int i = 0; i < myGradeBook.size(); i++)
						myGradeBook.getStudent(i).addExam(ex, ex.getPoints());
					JOptionPane.showMessageDialog(null, desc + " �sht� shtuar n� m�nyr� t� suksesshme n� GradeBook.");
				} else {
					String[] ee = e.split(" ");
					for (int i = 0; i < ee.length; i++)
						myGradeBook.getStudent(Integer.parseInt(ee[i])).addExam(ex, ex.getPoints());
					JOptionPane.showMessageDialog(null, desc + " �sht� shtuar n� m�nyr� t� suksesshme n� GradeBook.");
				}
				break;
			}

			case 5: {
				String sd = JOptionPane.showInputDialog(null,
						"Shkruaj indeksin e studentit q� do t� pranoj nj� not�: ");
				String exm = JOptionPane.showInputDialog(null,
						"Shkruaj indeksin e provimit q� studenti do t� notohet: ");
				String p = JOptionPane.showInputDialog(null,
						"Shkruani numrin e pikeve t� fituara t� studentit n� at� provim:");
				myGradeBook.getStudent(Integer.parseInt(sd)).getExam(Integer.parseInt(exm))
						.setPointsEarned(Double.parseDouble(p));
				String n = JOptionPane.showInputDialog(null, "Bazuar n� pik�t e fituara t� studentit shkruani not�n q� studenti meriton: ");
				myGradeBook.getStudent(Integer.parseInt(sd)).getExam(Integer.parseInt(exm))
						.setGrade(Integer.parseInt(n));
				break;
			}

			case 6: {
				String in = JOptionPane.showInputDialog(null,
						"Shkruaj indeksin e studentit q� d�shiron t'i shikosh t� dh�nat :");
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
				JOptionPane.showMessageDialog(null, "Ju lutemi provoni p�rs�ri", "Syntax Error",
						JOptionPane.ERROR_MESSAGE);
				break;
			}

		}
	}

}

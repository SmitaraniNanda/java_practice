
import java.util.Scanner;

class Company {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		Employee emp = new Employee();

		System.out.print("Enter eno: ");
		emp.eno = scn.nextInt();
		scn.nextLine();

		System.out.print("Enter ename: ");
		emp.ename = scn.nextLine();

		System.out.print("Enter sal: ");
		emp.sal = scn.nextDouble();
		scn.nextLine();

		System.out.print("Enter dept: ");
		emp.dept = scn.nextLine();

		System.out.print("Enter mobile: ");
		emp.mobile = scn.nextLong();

		System.out.print("Enter email: ");
		emp.email = scn.next();

		System.out.print("Enter gender: ");
		emp.gender = scn.next().charAt(0);

		System.out.print("Enter working status: ");
		emp.workingStatus = scn.nextBoolean();

		System.out.println("Employee object is created and initialized by reading values " + "from end-user from KB");

		System.out.println("\nEmp object details");
		System.out.println("  eno\t\t\t: " + emp.eno);
		System.out.println("  ename\t\t\t: " + emp.ename);
		System.out.println("  sal\t\t\t: " + emp.sal);
		System.out.println("  dept\t\t\t: " + emp.dept);
		System.out.println("  mobile\t\t: " + emp.mobile);
		System.out.println("  email\t\t\t: " + emp.email);
		System.out.println("  gender\t\t: " + emp.gender);
		System.out.println("  workingStatus\t\t: " + emp.workingStatus);

	}// main close
}// class close

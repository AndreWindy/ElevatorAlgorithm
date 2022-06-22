package visma.elevator;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ElevatorAlgorithm {

	private static int currentFloor = 0;
	private static List<Integer> floors = new LinkedList<>();
	private static List<Integer> upperFloors = new LinkedList<>();
	private static List<Integer> lowerFloors = new LinkedList<>();

	public static void setUpperFloors(int n) {
		for (int i = 1; i <= n; i++)
			upperFloors.add(i);
	}

	public static void setLowerFloors(int n) {
		for (int i = n; i > 0; i--)
			lowerFloors.add(-i);
	}

	public static void setFloors() {
		floors.addAll(lowerFloors);
		floors.add(0);
		floors.addAll(upperFloors);
	}

	public static void elevatorAlgorhithm(int floor) {
		if (!floors.contains(floor)) {
			System.out.println(
					"I'm sorry, but the given input is invalid, this elevator does not have the given floor. Please try again.");
			return;
		}
		if (floor == currentFloor) {
			System.out.println("You are currently on the given floor.");
			return;
		}
		if (floor < currentFloor) {
			for (int i = currentFloor; i >= floor; i--) {
				System.out.println(i);
			}
		}
		if (floor > currentFloor) {
			for (int i = currentFloor; i <= floor; i++) {
				System.out.println(i);
			}
		}
		if (floor == 0)
			System.out.println("Welcome to ground floor.");
		else
			System.out.println("Welcome to floor " + floor + ".");
		currentFloor = floor;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many floors above the ground level should the elevator have?: ");
		setUpperFloors(sc.nextInt());
		System.out.println("How many underground floors should there be?: ");
		setLowerFloors(sc.nextInt());
		setFloors();
		String s = "string";
		System.out.println("You are currently on the ground floor.");
		while (true) {
			System.out.println("What floor would you like to go to from the given? " + floors
					+ " (if you want to stop the program, put in stop)");
			s = sc.next();
			if (s.equals("stop")) {
				System.out.println("Thank you for your time. Goodbye.");
				sc.close();
				break;
			}
			elevatorAlgorhithm(Integer.parseInt(s));
		}
	}
}
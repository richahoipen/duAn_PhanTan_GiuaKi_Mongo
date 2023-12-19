package list_DAO;

import java.util.ArrayList;
import java.util.HashSet;

import entity.Person;

public class List_Person_DAO {
	/**
	 * @return the listPerson
	 */
	public ArrayList<Person> getListPerson() {
		return listPerson;
	}

	/**
	 * @param listPerson the listPerson to set
	 */
	public void setListPerson(ArrayList<Person> listPerson) {
		this.listPerson = listPerson;
	}

	private ArrayList<Person> listPerson;

	public List_Person_DAO() {
		super();
		setListPerson(new ArrayList<Person>());
	}

	public boolean addPerson(Person p) {
		if (!listPerson.contains(p)) {
			listPerson.add(p);
			return true;
		}
		return false;
	}

	public String toString() {
		String s = "";
		for (Person p : listPerson) {
			s += p.toString() + "\n";
		}
		return s;
	}

	// Tính tổng số person cho mỗi bang
	public double calculate_Population_State(String state) {
		int pop = 0;

		for (Person p : listPerson) {
			if (state.equalsIgnoreCase(p.getAddress().getState())) {
				pop++;
			}
		}
		return pop;
	}

	// Không được xuất đối tượng thuộc tính state cùng nhau nhóm
	public String toString_Population_State() {
		String s = "";
		HashSet<String> uniqueNames = new HashSet<>();
		ArrayList<Person> uniquePersons = new ArrayList<>();
		for (Person p : listPerson) {
			if (!uniqueNames.contains(p.getAddress().getState())) {
				uniqueNames.add(p.getAddress().getState());
				uniquePersons.add(p);
			}
		}

		// Xuất chuỗi toString() cho các Person có name không giống nhau
		for (Person p : uniquePersons) {
			s += p.getAddress().getState() + ": " + calculate_Population_State(p.getAddress().getState()) + "\n";
		}
		return s;
	}

	// Tính trung bình tuổi
	public double calculate_Avg_Age(String state) {
		int age = 0;
		double averageAge;
		for (Person p : listPerson) {
			if (state.equalsIgnoreCase(p.getAddress().getState())) {
				age += p.getAge();
			}
		}
		averageAge = age / getListPerson().size();
		return averageAge;
	}

	// Không được xuất đối tượng thuộc tính state cùng nhau nhóm
	public String toString_AverageAge_State() {
		String s = "";
		HashSet<String> uniqueNames = new HashSet<>();
		ArrayList<Person> uniquePersons = new ArrayList<>();
		for (Person p : listPerson) {
			if (!uniqueNames.contains(p.getAddress().getState())) {
				uniqueNames.add(p.getAddress().getState());
				uniquePersons.add(p);
			}
		}

		// Xuất chuỗi toString() cho các Person có name không giống nhau
		for (Person p : uniquePersons) {
			s += p.getAddress().getState() + ": " + calculate_Avg_Age(p.getAddress().getState()) + "\n";
		}
		return s;
	}

	public Person timKiemPerson(String firstName, String lastName) {
		for (Person p : listPerson) {
			if (p.getFirstName().equalsIgnoreCase(firstName) && p.getLastName().equalsIgnoreCase(lastName)) {
				return p;
			}
		}
		return null;
	}

	public boolean deletePerson(String firstName, String lastName) {
		Person p = timKiemPerson(firstName, lastName);
		if (p != null) {
			listPerson.remove(p);
			return true;
		}
		return false;
	}

}

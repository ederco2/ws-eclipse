package entities;

public class Rooms {
	private String name;
	private String email;
	private int rooms;
	Double nomees;
	double x;
	
	
	public Rooms(String name, String email, int rooms) {	
		this.name = name;
		this.email = email;
		this.rooms = rooms;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getRooms() {
		return rooms;
	}


	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	@Override
	public String toString() {
		return "Rooms [name=" + name + ", email=" + email + ", rooms=" + rooms + "]";
	}

	
}

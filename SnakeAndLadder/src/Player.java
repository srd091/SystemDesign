public class Player {

	String name;
	int position;

	Player(String name){
		this.name = name;
		this.position = 0;
	}

	public String getName() {
		return name;
	}

	public int getPosition(){
		return this.position;
	}

	public void setPosition(int position){
		this.position = position;
	}

}

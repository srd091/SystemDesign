import java.util.List;

public class Board {

	int sizeOfBoard;
	List<Jump> snakes;
	List<Jump> ladders;
	List<Player> players;
	int numOfDices;

	Board(int sizeOfBoard, List<Jump> snakes, List<Jump> ladders, int numOfDices, List<Player> players){
		this.sizeOfBoard = sizeOfBoard;
		this.snakes = snakes;
		this.ladders = ladders;
		this.numOfDices = numOfDices;
		this.players = players;
	}

	public int getSizeOfBoard(){
		return this.sizeOfBoard;
	}

	public List<Jump> getSnakes() {
		return snakes;
	}

	public List<Jump> getLadders() {
		return ladders;
	}

	public int getNumOfDices() {
		return numOfDices;
	}

	public List<Player> getPlayers() {
		return players;
	}

}

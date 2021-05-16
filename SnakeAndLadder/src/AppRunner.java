import java.util.ArrayList;
import java.util.List;

public class AppRunner {

	public static void main(String[] args) {

		Player p1 = new Player("Dhoni");
		Player p2 = new Player("Virat");
		Player p3 = new Player("Rohit");

		List<Player> players = new ArrayList<>();
		players.add(p1);
		players.add(p2);
		players.add(p3);


		Jump snake1 = new Jump(99, 45);
		Jump snake2 = new Jump(63, 29);
		Jump snake3 = new Jump(25, 7);

		Jump ladder1 = new Jump(3, 21);
		Jump ladder2 = new Jump(18, 49);
		Jump ladder3 = new Jump(57, 91);

		List<Jump> snakes = new ArrayList<>();
		snakes.add(snake1);
		snakes.add(snake2);
		snakes.add(snake3);

		List<Jump> ladders = new ArrayList<>();
		ladders.add(ladder1);
		ladders.add(ladder2);
		ladders.add(ladder3);

		Board board = new Board(100, snakes, ladders, 2, players);

		Game game = new Game();
		game.startGame(board);

	}

}

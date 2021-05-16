import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Game {

	public void startGame(Board board){

		int sizeOfBoard = board.getSizeOfBoard();
		List<Jump> snakes = board.getSnakes();
		List<Jump> ladders = board.getLadders();
		List<Player> players = board.getPlayers();
		int numOfDices = board.getNumOfDices();

		Queue<Player> q = new ArrayDeque<>();
		for(Player player: players){
			q.offer(player);
		}

		while(q.size() > 1){

			Player currentPlayer = q.poll();

			int move = getValidMove(numOfDices);
			System.out.println(currentPlayer.getName()+" got a " + move);

			int newPosition = currentPlayer.getPosition() + move;

			if (newPosition > sizeOfBoard){
				q.offer(currentPlayer);
				System.out.println(currentPlayer.getName() + " is at " + currentPlayer.getPosition());
			}else if (newPosition == sizeOfBoard){
				System.out.println("*** " + currentPlayer.getName() + " is Winner ***");
			}else{
				currentPlayer.setPosition(newPosition);
				for(Jump snake: snakes){
					if(snake.start == newPosition){
						currentPlayer.setPosition(snake.end);
						System.out.println(currentPlayer.getName() + " got bitten by a snake at " + snake.start);
						break;
					}
				}

				for(Jump ladder: ladders){
					if(ladder.start == newPosition){
						currentPlayer.setPosition(ladder.end);
						System.out.println(currentPlayer.getName() + " got a ladder at " + ladder.start);
						break;
					}
				}
				System.out.println(currentPlayer.getName() + " is at " + currentPlayer.getPosition());
				q.offer(currentPlayer);
			}

		}
	}

	private int getValidMove(int numOfDices) {
		return (int)(Math.random()*(numOfDices*6 - numOfDices*1) + numOfDices);
	}

}

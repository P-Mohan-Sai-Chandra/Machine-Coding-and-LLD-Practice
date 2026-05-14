package com.target20.tic_tac_toe;


import com.target20.tic_tac_toe.controllers.GameController;
import com.target20.tic_tac_toe.models.Player;
import com.target20.tic_tac_toe.models.Symbol;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TicTacToeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TicTacToeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Player player = new Player();
		player.setPlayerName("Mohan");
		Symbol symbol1 = new Symbol();
		symbol1.setSymbolImage("X");
		player.setPlayerSymbol(symbol1);
		Player p2 =  new Player();
		Symbol s2 = new Symbol();
		s2.setSymbolImage("O");
		p2.setPlayerSymbol(s2);
		p2.setPlayerName("Robot");
		GameController controller = new GameController();
		List<Player> players = new ArrayList<>();
		players.add(player);
		players.add(p2);
		controller.startGame(players,3);
	}
}

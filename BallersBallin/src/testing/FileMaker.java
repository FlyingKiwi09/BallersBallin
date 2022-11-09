package testing;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;

import org.junit.jupiter.api.Test;

import application.FantasyLeagueController;
import application.Player;

public class FileMaker {
	
	public static boolean Makescanfile(String fileLocation) {
		
		FantasyLeagueController scan = new FantasyLeagueController();
		
		scan.scanData();
		
		ArrayList<Player> samiam = scan.getPlayers();
		
	
	
	Player lebron = samiam.get(0);

	int year = lebron.getSeasonStats().get(0).getYear();
	int game = lebron.getSeasonStats().get(0).getGameStatistics().get(0).getRound();
	
	
	File file = new File("testfile.txt");
	
	try {
		PrintStream print = new PrintStream(file);
		
		print.println(year);
		print.print(game);
		
		for(Player p : samiam) {
			
			print.print(p.getName() + "," + p.getNBLTeamName()+ "," + p.getJerseyNumber()+ "," + p.getPosition()+ "," + p.getSeasonStats().get(0).getTotalPoints() + "," +
			p.getSeasonStats().get(0).getTotalRebounds()+ "," + p.getSeasonStats().get(0).getTotalAssists()+ "," + p.getSeasonStats().get(0).getTotalTimePlayed()+ ",");
			
		}
		
		
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
		
	/*
	 * JFileChooser j = new JFileChooser(); int returnVal = j.showOpenDialog(null);
	 * 
	 * File ComparisonFile = j.getSelectedFile();
	 * System.out.print(ComparisonFile.getName() + " selected");
	 */
	
	//BallersBallin_newusertest_set0.txt
	 System.out.println("Working Directory = " + System.getProperty("user.dir"));
	File ComparisonFile = new File("./BallersBallin/src/testing/" + fileLocation);/* scan.getFiletoPass();*///BallersBallin_newusertest_set0.txt
	File printedFile = file;
	
	try {
		
		Scanner scan1 = new Scanner(ComparisonFile);
		Scanner scan2 = new Scanner(printedFile);
		
	while(scan2.hasNext() ) {
		String s =  scan1.nextLine();
		String z =scan2.nextLine();
		if (!(s.equals(z))) {
			fail(s + "Does not equal " + z);
			return false;
			
		}
		
	}
		
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return true;
}
		
	


}

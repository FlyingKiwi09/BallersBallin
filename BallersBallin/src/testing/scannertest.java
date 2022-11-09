package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class scannertest {

	
	
	  @ParameterizedTest
	  
	  @DisplayName("TestFileScanner: Version 1")
	  
	  @ValueSource(strings= { "filetest.txt","BallersBallin_newusertest_set0.txt", "BallersBallin_newusertest_set1.txt",
	  "BallersBallin_updatedatatest_set0.txt", "BallersBallin_updatedatatest_set1.txt" })
	
	void testscanner(String fileLocation) {

		assertEquals(true, FileMaker.Makescanfile(fileLocation));
		/*
		 * assertEquals(true,
		 * FileMaker.Makescanfile("BallersBallin_newusertest_set1.txt"));
		 * assertEquals(true,
		 * FileMaker.Makescanfile("BallersBallin_updatedatatest_set0.txt"));
		 * //assertEquals(true, FileMaker.Makescanfile(file));
		 */

	}

}

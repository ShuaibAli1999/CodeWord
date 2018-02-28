package test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import code.assign;
import code.Location;
import code.PersonAssignments;
import code.CodenamesList;

public class LocationAssignmentsTest{
	@Test
	public void locationAssignments() throws FileNotFoundException, IOException{
	assign a=new assign();
	CodenamesList c=new CodenamesList();
	PersonAssignments p=new PersonAssignments();
	a.gameStarted(c, p);
	Location[][] l=new Location[5][5];
	l=a.getBoard();
	assertEquals(l[0][0].getName(),a.getcodename().get(0));
	}
	
}

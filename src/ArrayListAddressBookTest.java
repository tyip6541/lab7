import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArrayListAddressBookTest
{

    private AddressBook dir;
    private AddressBook deptDir;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception
    {
    }

    @Before
    public void initialize() 
    {
        dir = new ArrayListAddressBook();
        deptDir = new ArrayListAddressBook();
        deptDir.load("deptdir.txt");
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    (expected=NoSuchElementException.class) public void directoryHasNoSoljaBoy() 
    {
        //AddressBook dir = new ArrayListAddressBook();
        dir.put("Solja Boy", "Phone", "678-999-8212");
        dir.put("Fred", "Phone", "555-0132");
        dir.remove("Christine", "2423535");
        //dir.remove("Solja Boy", "Phone");
        //dir.get("Solja Boy", "Phone");
        //assertNull(dir.get("Solja Boy", "Phone"));
    }
    
    @Test
    public void deptDirContainsHorstmann() 
    {
       assertNotNull(deptDir.get("Horstmann", "Phone"));
    }
    
    /*@Test
    public void removeFromNonEmptyDirectory()
    {
        AddressBook dir = new ArrayListAddressBook();
        dir.remove("Solja Boy", "Phone");
    }*/

}

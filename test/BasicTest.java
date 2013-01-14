import org.junit.*;

import com.google.gson.Gson;

import java.util.*;
import play.test.*;
import library.seat.manage.dto.DeskInfo;
import models.*;

public class BasicTest extends UnitTest {

    @Test
    public void aVeryImportantThingToTest() {
        assertEquals(2, 1 + 1);
    }
    
    @Test
    public void createTestDate() {
    	List<DeskInfo> desksList = new ArrayList<DeskInfo>();
    	DeskInfo d1 = new DeskInfo();
    	DeskInfo d2 = new DeskInfo();
    	DeskInfo d3 = new DeskInfo();
    	DeskInfo d4 = new DeskInfo();
    	
    	d1.setBlock("A");
    	d2.setBlock("B");
    	d3.setBlock("C");
    	d4.setBlock("D");
    	d1.setDeskId(1);
    	d2.setDeskId(2);
    	d3.setDeskId(3);
    	d4.setDeskId(4);
    	d1.setDeskNum(6);
    	d2.setDeskNum(1);
    	d3.setDeskNum(3);
    	d4.setDeskNum(4);
    	d1.setFloor(2);
    	d2.setFloor(1);
    	d3.setFloor(3);
    	d4.setFloor(4);
    	d1.setIsAble(true);
    	d2.setIsAble(true);
    	d3.setIsAble(false);
    	d4.setIsAble(true);
    	d1.getExtFields().put("reserveStatus", 3);
    	d2.getExtFields().put("reserveStatus", 48);
    	d3.getExtFields().put("reserveStatus", 131);
    	d4.getExtFields().put("reserveStatus", 225);
    	
    	desksList.add(d1);
    	desksList.add(d2);
    	desksList.add(d3);
    	desksList.add(d4);
    	
    	Gson gson = new Gson();
    	System.out.println(gson.toJson(desksList));
    	
    }
    
    
    

}

package tranings;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by clouway on 8/17/15.
 */
public class Demo {


    @Test
    public void test(){

       GetObject  getObject = new GetObject();
        Obj o = null;

        assertNotNull(getObject.GettingObject(o));
    }
}

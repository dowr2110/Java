package lst;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class L2 implements HttpSessionAttributeListener {

    public void attributeAdded(HttpSessionBindingEvent e) {
        System.out.println("L2:attributeAdded");
    }
    public void attributeRemoved(HttpSessionBindingEvent e) {
        System.out.println("L2:attributeRemoved");
    }
    public void attributeReplaced(HttpSessionBindingEvent e) {
        System.out.println("L2:attributeReplaced");
    }
}
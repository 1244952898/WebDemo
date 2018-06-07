package listerDemo;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Created by zy on 2018-4-13.
 */
public class MySessionAttrListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        HttpSession session=(HttpSession)httpSessionBindingEvent;
        Object o=session.getAttribute("a");
        System.out.println("attributeAdded=="+o);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("attributeRemoved");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        HttpSession session=(HttpSession)httpSessionBindingEvent;
        Object obj = httpSessionBindingEvent.getValue();
        System.out.println("old==="+obj);
        Object o=session.getAttribute("a");
        System.out.println("new=="+o);
        System.out.println("attributeReplaced");
    }
}

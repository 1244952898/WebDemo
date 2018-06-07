package listerDemo;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Created by zy on 2018-4-13.
 */
public class MyServletRequestLister implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("requestDestroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("++++++++++++++++++++++++++++++++requestInitialized+++++++++++++++++++++++++++++");
    }
}

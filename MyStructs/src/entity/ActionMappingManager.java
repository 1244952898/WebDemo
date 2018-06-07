package entity;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by zy on 2018-5-29.
 */
public class ActionMappingManager {
    public ActionMappingManager() {
        allActions=new HashMap<>();
        this.init();
    }

    Map<String, ActionMapping> allActions;

    public ActionMapping getActionMapping(String actionName) {
        if (actionName == null)
            throw new RuntimeException("参数有误，请查询mystruts配置文件");
        ActionMapping actionMapping = allActions.get(actionName);
        if (actionMapping == null)
            throw new RuntimeException("路径在mystruts中找不到");
        return actionMapping;
    }

    private void init() {
        try {
            SAXReader sax = new SAXReader();
            InputStream in = this.getClass().getResourceAsStream("/mystruts.xml");
            Document document = sax.read(in);
            Element root = document.getRootElement();
            Element ele_package = root.element("package");
            List<Element> listAction = ele_package.elements("action");
            for (Element ele : listAction) {
                ActionMapping action = new ActionMapping();

                String name = ele.attributeValue("name");
                String className = ele.attributeValue("class");
                String method = ele.attributeValue("method");

                Map<String,Result> results=new HashMap<>();
                Iterator<Element> its = ele.elementIterator("result");
                while (its.hasNext()) {
                    Result result = new Result();
                    Element el = its.next();
                    result.setName(el.attributeValue("name"));
                    result.setType(el.attributeValue("type"));
                    result.setPage(el.getTextTrim());
                    results.put(el.attributeValue("name"),result);
                }

                action.setName(name);
                action.setClassName(className);
                action.setMethod(method);
                action.setResults(results);
                allActions.put(action.getName(), action);
            }


        } catch (DocumentException e) {
            throw new RuntimeException("初始化错误");
        }
    }
}

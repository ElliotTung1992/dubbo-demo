package com.github.dge.mvc;


import com.alibaba.fastjson.JSON;
import com.github.dge.mvc.annotation.*;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

public class DispatcherServlet extends HttpServlet{

    /**
     * 配置文件映射对象
     */
    private Properties properties = new Properties();

    /**
     * 扫描组件集合
     */
    private List<String> componentList = new ArrayList<>();

    /**
     * 容器
     */
    private Map<String, Object> context = new HashMap<>();

    /**
     * 执行链
     */
    private Map<String, Method> handlerMapping = new HashMap<>();

    @Override
    public void init() throws ServletException {
        loadConfig();
        componentScan(properties.getProperty("componentScan"));
        instantiationBean();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatcher(req, resp);
    }

    /**
     * 请求分发
     * @param request
     * @param response
     */
    private void dispatcher(HttpServletRequest request, HttpServletResponse response) {
        try {
            String requestURI = request.getRequestURI();
            requestURI = requestURI.substring(0, requestURI.indexOf("."));
            Method method = handlerMapping.get(requestURI);
            if(method == null){
                return;
            }
            //封装参数
            Map<String, String[]> parameterMap = request.getParameterMap();
            Parameter[] parameters = method.getParameters();
            Object[] parameterValues = new Object[parameters.length];
            for (int i = 0; i < parameters.length; i++) {
                String name = parameters[i].getName();
                String[] strings = parameterMap.get(name);
                if(strings == null){
                    break;
                }
                String value = strings[0];
                Class<?> type = parameters[i].getType();
                switch (type.getSimpleName()){
                    case "Integer":
                        parameterValues[i] = Integer.parseInt(value);
                        break;
                    case "int":
                        parameterValues[i] = Integer.parseInt(value);
                        break;
                    case "String":
                        parameterValues[i] = value;
                        break;
                    case "Boolean":
                        parameterValues[i] = Boolean.parseBoolean(value);
                        break;
                    case "boolean":
                        parameterValues[i] = Boolean.parseBoolean(value);
                        break;
                }
            }
            //设置依赖
            Class<?> clazzMethod = method.getDeclaringClass();
            Object controller = context.get(toLowerCaseFirstOne(clazzMethod.getSimpleName()));
            Field[] fields = controller.getClass().getDeclaredFields();
            for (Field field:fields) {
                boolean isAutowired = field.isAnnotationPresent(Autowired.class);
                if(isAutowired){
                    String name = field.getName();
                    Object service = context.get(name);
                    field.setAccessible(true);
                    field.set(controller, service);
                    Field[] mapperFields = service.getClass().getDeclaredFields();
                    for (Field mapperField:mapperFields) {
                        boolean isAutowired2 = mapperField.isAnnotationPresent(Autowired.class);
                        if(isAutowired2){
                            String mapperName = mapperField.getName();
                            Object mapper = context.get(mapperName);
                            mapperField.setAccessible(true);
                            mapperField.set(service, mapper);
                        }
                    }
                }
            }
            method.setAccessible(true);
            Object result = method.invoke(controller, parameterValues);

            boolean isResponseBody = method.isAnnotationPresent(ResponseBody.class);
            String str = JSON.toJSONString(result);
            if(isResponseBody){
                response.getWriter().print(str);
            }else{
                request.getRequestDispatcher("/test" + properties.get("mvc_suffix")).forward(request, response);
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        //销毁
    }

    /**
     * 实例化组件
     */
    private void instantiationBean() {
        if(componentList.isEmpty()){
            return;
        }
        try {
            for (String component:componentList) {
                Class<?> clazz = Class.forName(component);
                if (clazz.isAnnotationPresent(Controller.class)){
                    context.put(toLowerCaseFirstOne(clazz.getSimpleName()), clazz.newInstance());
                    if(clazz.isAnnotationPresent(RequestMapping.class)){
                        String requestMappingValue = clazz.getDeclaredAnnotation(RequestMapping.class).value();
                        Method[] methods = clazz.getMethods();
                        for (Method method:methods) {
                            RequestMapping requestMapping = method.getDeclaredAnnotation(RequestMapping.class);
                            if(requestMapping != null){
                                String value = requestMapping.value();
                                if(StringUtils.isNotEmpty(value)){
                                    handlerMapping.put(requestMappingValue + value, method);
                                }
                            }
                        }
                    }
                }else if(clazz.isAnnotationPresent(Service.class)){
                    context.put(toLowerCaseFirstOne(clazz.getSimpleName()), clazz.newInstance());
                }else if(clazz.isAnnotationPresent(Mapper.class)){
                    context.put(toLowerCaseFirstOne(clazz.getSimpleName()), clazz.newInstance());
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * 扫描包
     */
    private void componentScan(String componentScan) {
        try {
            if(StringUtils.isNotEmpty(componentScan)){
                String[] components = componentScan.split(",");
                for (String component:components) {
                    URL url = this.getClass().getClassLoader().getResource("/" + component.replaceAll("\\.", "/"));
                    URI uri = url.toURI();
                    File files = new File(uri);
                    for (File file:
                            files.listFiles()) {
                        if(file.isDirectory()){
                            componentScan(component + "." + file.getName());
                        }else{
                            componentList.add(component + "." + file.getName().replaceAll("\\.class", ""));
                        }
                    }
                }
            }
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取配置文件
     */
    private void loadConfig() {
        InputStream inputStream = null;
        try {
            inputStream = this.getClass().getClassLoader().getResourceAsStream("config.properties");
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 首字母大写转小写
     * @param s
     * @return
     */
    public static String toLowerCaseFirstOne(String s){
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return new StringBuilder().append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }

}

package com.springmvc.util;

import java.lang.reflect.Field;

public class Utils {

    public static  <T> void mergeObject(T origin, T destination) {
        if (origin == null || destination == null)
            return;
        if (!origin.getClass().equals(destination.getClass()))
            return;
 
        Field[] fields = origin.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            try {
                fields[i].setAccessible(true);
                Object value = fields[i].get(origin);
                if (null != value) {
                    fields[i].set(destination, value);
                }
                fields[i].setAccessible(false);
            } catch (Exception e) {
            }
        }
    }
    
//    public static Map<String ,List<Goods>> goodsListToMap(List<Goods> goodList){
//        Map<String,List<Goods>> map=new HashMap<String, List<Goods>>();
//        List<Goods> tempList=new ArrayList<Goods>();
//        for(Goods g:goodList){
//            if(map!=null){
//                tempList=map.get(g.getGoodsType().getTypeId().toString());
//                if(tempList==null){
//                    tempList=new ArrayList<Goods>();
//                }
//            }
//            tempList.add(g);
//            map.put(g.getGoodsType().getTypeId().toString(), tempList);
//        }
//        return map;
//    }
}

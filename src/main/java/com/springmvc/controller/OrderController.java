package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.service.H5TagCountService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private H5TagCountService orderService;

//    @Autowired
//    private GoodsService goodsService;
//    @RequestMapping("/save")
//    public Map<String, Object> saveOrder(HttpServletRequest request, HttpServletResponse response,
//            HttpSession session, OrderList order, Integer[] gIds, Integer[] goodsIds, String[] goodsNames,
//            String[] goodsSizes, String[] goodsNumbers, Float[] goodsPrices) {
//        Map<String, Object> map = new HashMap<>();
//        try {
//            List<GoodsShow> list = new ArrayList<GoodsShow>();
//            if (goodsIds == null) {
//                map.put("SUCCESS", false);
//                map.put("MESSAGE", "请选择商品");
//                return map;
//            }
//            if (goodsNames == null) {
//                map.put("SUCCESS", false);
//                map.put("MESSAGE", "商品名称为空");
//                return map;
//            }
//            if (goodsSizes == null) {
//                map.put("SUCCESS", false);
//                map.put("MESSAGE", "商品型号为空");
//                return map;
//            }
//            if (goodsNumbers == null) {
//                map.put("SUCCESS", false);
//                map.put("MESSAGE", "商品数量为空");
//                return map;
//            }
//            if (goodsPrices == null) {
//                map.put("SUCCESS", false);
//                map.put("MESSAGE", "商品价格为空");
//                return map;
//            }
//            // if(goodsIds.length==goodsNames.length&&goodsSizes.length==goodsNumbers.length&&goodsPrices.length==goodsNumbers.length&&goodsPrices.length==goodsIds.length){
//            // map.put("SUCCESS",false);
//            // map.put("MESSAGE", "请选择商品");
//            // return map;
//            // }
//            if (gIds != null) {
//                for (int i = 0; i < goodsIds.length; i++) {
//                    GoodsShow gs = new GoodsShow(gIds[i], goodsService.getGoodsById(goodsIds[i]), goodsNames[i], goodsSizes[i], goodsNumbers[i],
//                            goodsPrices[i]);
//                    list.add(gs);
//                }
//            } else {
//                for (int i = 0; i < goodsIds.length; i++) {
//                    GoodsShow gs = new GoodsShow(goodsService.getGoodsById(goodsIds[i]), goodsNames[i], goodsSizes[i], goodsNumbers[i],
//                            goodsPrices[i]);
//                    list.add(gs);
//                }
//            }
//
//            order.setGoods(list);
//            orderService.saveOrder(order);
//            map.put("DATA", order);
//            map.put("SUCCESS", true);
//            map.put("MESSAGE", "保存成功");
//            return map;
//        } catch (Exception e) {
//            e.printStackTrace();
//            map.put("SUCCESS", false);
//            map.put("MESSAGE", "保存失败");
//            return map;
//        }
//    }
//
//    @RequestMapping("/update")
//    public Map<String, Object> updateOrder(HttpServletRequest request, HttpServletResponse response,
//            HttpSession session, OrderList order, Integer[] gIds, Integer[] goodsIds, String[] goodsNames,
//            String[] goodsSizes, String[] goodsNumbers, Float[] goodsPrices) {
//        Map<String, Object> map = new HashMap<>();
//        try {
//            List<GoodsShow> list = new ArrayList<GoodsShow>();
//            OrderList ol=orderService.getOrder(order.getId());
//            if(ol==null){
//                map.put("DATA", order);
//                map.put("SUCCESS", false);
//                map.put("MESSAGE", "更新失败!订单id为空");
//                return map;
//            }
//            if (gIds != null) {
//                for (int i = 0; i < goodsIds.length; i++) {
//                    GoodsShow gs = new GoodsShow(gIds[i], goodsService.getGoodsById(goodsIds[i]), goodsNames[i], goodsSizes[i], goodsNumbers[i],
//                            goodsPrices[i]);
//                    list.add(gs);
//                }
//            }
//            Utils.mergeObject(order, ol);
//            ol.setGoods(list);
//            orderService.updateOrder(ol);
//            map.put("DATA", order);
//            map.put("SUCCESS", true);
//            map.put("MESSAGE", "保存成功");
//            return map;
//        } catch (Exception e) {
//            e.printStackTrace();
//            map.put("SUCCESS", false);
//            map.put("MESSAGE", "保存失败");
//            return map;
//        }
//    }
//    @RequestMapping("/list")
//    @ResponseBody
//    public Map<String, Object> getList(HttpServletRequest request, HttpServletResponse response, HttpSession session,
//            OrderList order, Integer orderId) {
//        Map<String, Object> map = new HashMap<>();
//        try {
////            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////            Date date = null; // 初始化date
////            date = sdf.parse(currentTime); 
//            List<OrderList> list = orderService.getOrderList(order, orderId);
//            map.put("DATA", list);
//            map.put("SUCCESS", true);
//            map.put("MESSAGE", "查询成功");
//            return map;
//        } catch (Exception e) {
//            e.printStackTrace();
//            map.put("SUCCESS", false);
//            map.put("MESSAGE", "查询失败");
//            return map;
//        }
//    }
}

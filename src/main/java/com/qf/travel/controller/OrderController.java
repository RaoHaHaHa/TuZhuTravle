package com.qf.travel.controller;

import com.qf.travel.entity.Order;
import com.qf.travel.entity.User;
import com.qf.travel.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    /**
     * 查询订单
     * @param session
     * @return
     */
    @RequestMapping(value = "findUserOrder",method = RequestMethod.GET)
    @ResponseBody
    public Object findUserOrder(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user != null){

            return orderService.findUserOrder(user.getId());
        }
        return "session is not user";
    }

    /**
     * 通过订单id 删除用户订单
     * @param orderId
     * @return
     */
    @RequestMapping(value = "deleteOrder",method = RequestMethod.GET)
    @ResponseBody
    public Object deleteOrder(int orderId){
        System.out.println(orderId);
        int i = orderService.deleteOrder(orderId);
        return Integer.toString(i);
    }

    /**
     * 生成订单
     * @param order
     * @return
     */
    @RequestMapping(value = "insertOneOrder",method = RequestMethod.POST)
    @ResponseBody
    public Object insertOneOrder(@RequestBody Order order){
        System.out.println(order);
        return orderService.insertOneOrder(order);
    }
}

package com.qf.travel.controller;
import com.qf.travel.dto.DtoOrder;
import com.qf.travel.dto.OrderPay;
import com.qf.travel.utils.AlipayUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version 1.0.0
 * @auther Snake
 * @date 2019/7/5 9:31
 */
@Controller
public class PayController {
    @Resource
    OrderPay orderPay;

    @RequestMapping(value = "roomPay",produces = "application/json;charset=utf-8")
    public void roomPay(@RequestParam String orderNo, String totalMoney, String orderName, String orderDetail, HttpServletRequest request, HttpServletResponse response){
        orderPay.setOrderDetail(orderDetail);
        orderPay.setOrderName(orderName);
        orderPay.setOrderNo(orderNo);
        orderPay.setTotalMoney(totalMoney);
        //System.out.println("controller  !!!"+orderName);
        String s = AlipayUtil.tradePagePay(orderPay, request);



        response.setContentType("text/html;charset=utf-8");
        try {

            response.getWriter().write(s);//直接将完整的表单html输出到页面
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                response.getWriter().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @ResponseBody
    @RequestMapping(value = "getOrder",produces = "application/json;charset=utf-8")
    public Object getOrder(HttpServletRequest request){
        DtoOrder dtoOrder = new DtoOrder();
        dtoOrder.setOrderName("王者荣耀");
        dtoOrder.setTotalMoney("1000");
        return dtoOrder;
    }


    @RequestMapping(value = "returnUrl",produces = "application/json;charset=utf-8")
    public void returnUrl(HttpServletRequest request, HttpServletResponse response){
        AlipayUtil.setReturn_url(request);
        response.setContentType("text/html;charset=utf-8");
        try {
            response.getWriter().print("<script >alert('支付成功');location='index_qian.html'</script>");
            System.out.println(orderPay.getOrderNo());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "setNotifyUrl",produces = "application/json;charset=utf-8")
    public void setNotifyUrl(HttpServletRequest request, HttpServletResponse response){
        OrderPay orderPay = AlipayUtil.setNotify_url(request);
       request.getSession().setAttribute("order",orderPay);
        System.out.println(orderPay.getOrderNo());
    }
}

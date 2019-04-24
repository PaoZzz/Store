package com.jxnydx.store.factory;

import com.jxnydx.store.service.front.IGoodsServiceFront;
import com.jxnydx.store.service.front.IMerchantServiceFront;
import com.jxnydx.store.service.front.IOrdersServiceFront;
import com.jxnydx.store.service.front.IStudentServiceFront;
import com.jxnydx.store.service.front.impl.GoodsServiceFrontImpl;
import com.jxnydx.store.service.front.impl.MerchantServiceFrontImpl;
import com.jxnydx.store.service.front.impl.OrdersServiceFrontImpl;
import com.jxnydx.store.service.front.impl.StudentServiceFrontImpl;

public class ServiceFrontFactory {
    public static IStudentServiceFront getIStudentServiceFrontInstance() throws Exception {
        return new StudentServiceFrontImpl();
    }

    public static IMerchantServiceFront getIMerchantServiceFrontInstance() throws Exception {
        return new MerchantServiceFrontImpl();
    }

    public static IGoodsServiceFront getIGoodsServiceFrontInstance() {
        return new GoodsServiceFrontImpl();
    }

    public static IOrdersServiceFront getIOrdersServiceFrontInstance() {
        return new OrdersServiceFrontImpl();
    }
}

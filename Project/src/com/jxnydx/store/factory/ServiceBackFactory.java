package com.jxnydx.store.factory;

import com.jxnydx.store.service.back.IAdminServiceBack;
import com.jxnydx.store.service.back.IMerchantServiceBack;
import com.jxnydx.store.service.back.IOrdersServiceBack;
import com.jxnydx.store.service.back.IStudentServiceBack;
import com.jxnydx.store.service.back.impl.AdminServiceBackImpl;
import com.jxnydx.store.service.back.impl.MerchantServiceBackImpl;
import com.jxnydx.store.service.back.impl.OrdersServiceBackImpl;
import com.jxnydx.store.service.back.impl.StudentServiceBackImpl;

public class ServiceBackFactory {

    public static IAdminServiceBack getIAdminServiceBackInstance() throws Exception {
        return new AdminServiceBackImpl();
    }

    public static IStudentServiceBack getIStudentServiceBackInstance() {
        return new StudentServiceBackImpl();
    }

    public static IMerchantServiceBack getIMerchantServiceBackInstance() {
        return new MerchantServiceBackImpl();
    }

    public static IOrdersServiceBack getIOrdersServiceBackInstance() {
        return new OrdersServiceBackImpl();
    }

}

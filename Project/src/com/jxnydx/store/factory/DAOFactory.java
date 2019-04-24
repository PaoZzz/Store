package com.jxnydx.store.factory;

import com.jxnydx.store.dao.*;
import com.jxnydx.store.dao.impl.*;

import java.sql.Connection;

public class DAOFactory {
    public static IAdminDAO getIAdminDAOInstance(Connection conn) {
        return new AdminDAOImpl(conn);
    }

    public static IStudentDAO getIStudentDAOInstance(Connection conn) {
        return new StudentDAOImpl(conn);
    }

    public static IMerchantDAO getIMerchantDAOInstance(Connection conn) {
        return new MerchantDAOImpl(conn);
    }

    public static IGoodsDAO getIGoodsDAOInstance(Connection conn) {
        return new GoodsDAOImpl(conn);
    }

    public static IOrdersDAO getIOrdersDAOInstance(Connection conn) {
        return new OrdersDAOImpl(conn);
    }
}

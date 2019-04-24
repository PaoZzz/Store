package com.jxnydx.store.frame.front.merchant;

import com.jxnydx.store.factory.ServiceFrontFactory;
import com.jxnydx.store.vo.Goods;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.List;

public class MerchantUserGoodsShowFrame extends JFrame {
    private String mid;
    private List<Goods> goodsList;

    public MerchantUserGoodsShowFrame(String frameName, String mid) {
        this.mid = mid;
        try {
            goodsList = ServiceFrontFactory.getIGoodsServiceFrontInstance().getAllMerchantGoods(mid);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setSize(500, 350);
        this.setTitle(frameName);
        this.setLayout(new GridLayout(this.goodsList.size(),3));

        Iterator<Goods> iter = this.goodsList.iterator();
        while (iter.hasNext()) {
            final Goods goods = iter.next();
            JPanel jPanelOnePointOne = new JPanel();
            JPanel jPanelOnePointTwo = new JPanel();
            JPanel jPanelOnePointThree = new JPanel();
            JLabel goodsName = new JLabel(goods.getGname());
            JLabel goodsPrice = new JLabel(String.valueOf(goods.getGprice()) + "¥");
            JLabel goodsStatus = null;
            if (goods.getGstatus() == 0) {
                goodsStatus = new JLabel("下架");
            } else if(goods.getGstatus() == 1) {
                goodsStatus = new JLabel("上架");
            } else if(goods.getGstatus() == 2) {
                goodsStatus = new JLabel("删除");
            }

            jPanelOnePointOne.add(goodsName);
            jPanelOnePointTwo.add(goodsPrice);
            jPanelOnePointThree.add(goodsStatus);

            this.add(jPanelOnePointOne);
            this.add(jPanelOnePointTwo);
            this.add(jPanelOnePointThree);
        }

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}

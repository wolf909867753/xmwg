package com.xmwg.wq.wechat.utils;

import com.xmwg.wq.wechat.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 手动创建菜单
 */
public class MenuManager {
    private static Logger log = LoggerFactory.getLogger(MenuManager.class);

    public static void main(String[] args) {
        // 第三方用户唯一凭证
        String appId = "u appid";
        // 第三方用户唯一凭证密钥
        String appSecret = "u appSecret";

        // 调用接口获取access_token
        AccessToken at = WechatUtil.getAccessToken(appId, appSecret);

        if (null != at) {
            // 调用接口创建菜单
            int result = WechatUtil.createMenu(getMenu(), at.getToken());

            // 判断菜单创建结果
            if (0 == result)
                log.info("菜单创建成功！");
            else
                log.info("菜单创建失败，错误码：" + result);
        }
    }

    /**
     * 组装菜单数据
     *
     * @return
     */
    private static Menu getMenu() {
        CommonButton btn11 = new CommonButton();
        btn11.setName("食疗文化");
        btn11.setType("click");
        btn11.setKey("11");

        CommonButton btn12 = new CommonButton();
        btn12.setName("招商通道");
        btn12.setType("click");
        btn12.setKey("12");

        CommonButton btn21 = new CommonButton();
        btn21.setName("免费领取");
        btn21.setType("click");
        btn21.setKey("21");

        ViewButton btn22 = new ViewButton();
        btn22.setName("代理下单");
        btn22.setType("view");
        btn22.setUrl("http://wolf909867753.xicp.net");

        CommonButton btn31 = new CommonButton();
        btn31.setName("调理案例");
        btn31.setType("click");
        btn31.setKey("31");

        CommonButton btn32 = new CommonButton();
        btn32.setName("食物营养");
        btn32.setType("click");
        btn32.setKey("32");

        CommonButton btn33 = new CommonButton();
        btn33.setName("中医五行");
        btn33.setType("click");
        btn33.setKey("33");

        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("走进食疗");
        mainBtn1.setSub_button(new Button[] { btn11, btn12});//, btn13, btn14

        ComplexButton mainBtn2 = new ComplexButton();
        mainBtn2.setName("自助服务");
        mainBtn2.setSub_button(new Button[] { btn21, btn22 });//, btn23, btn24, btn25

        ComplexButton mainBtn3 = new ComplexButton();
        mainBtn3.setName("食疗养生汇");
        mainBtn3.setSub_button(new Button[] { btn31, btn32, btn33 });

        Menu menu = new Menu();
        menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });

        return menu;
    }
}

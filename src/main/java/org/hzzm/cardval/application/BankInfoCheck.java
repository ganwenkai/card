package org.hzzm.cardval.application;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.hzzm.cardval.util.AccountUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jwang on 2017/4/24.
 */
public class BankInfoCheck {
    private static final Logger logger = Logger.getLogger(BankInfoCheck.class);
    /**
     *
     * @param bankcard
     * @param idcard
     * @param mobile
     * @param realname
     * @return
             */
    public static Map<String, String> Call(String bankcard, String idcard, String mobile, String realname) {
        logger.info(System.getProperty("java.version"));
        Map<String, String> result = new HashMap<>();
        Map<String, String> ret = AccountUtil.account(bankcard, idcard, realname, mobile); //是否传手机号
        result.put("code", ret.get("respCode"));
        result.put("desc", ret.get("respDesc"));
        if (!"00".equals(result.get("code")) && !"05".equals(result.get("code"))) {
            logger.info("通道认证异常 信息如下：" + JSONObject.toJSONString(result));
            return null;
        }
        return result;
    }
}

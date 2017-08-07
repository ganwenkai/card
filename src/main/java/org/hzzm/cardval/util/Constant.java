/**
 *
 */
package org.hzzm.cardval.util;

/**
 * @author Renne66
 * @Description:
 * @email 465119455@qq.com
 * @date 2016年4月21日
 */
public class Constant {
    public static int BANK_PRICE;

    static {
        BANK_PRICE = StringUtil.isEmptyReplace(PropertiesUtil.getIntProperties("BANK_PRICE"), 200);
    }

}

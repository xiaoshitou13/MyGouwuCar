package Bean;

import java.util.List;

/**
 * Created by 白玉春 on 2017/10/19.
 */

public class Users {

    /**
     * code : 200
     * data : [{"datas":[{"add_time":"2016-12-10 14:54:58","cart_id":"445162","house_id":"1","msg":"购买渠道:大陆国行","price":500,"type_name":"苹果 iPhone 6（白金色）","type_sn_id":"ggh"},{"add_time":"2016-12-10 14:55:18","cart_id":"445163","house_id":"1","msg":"购买渠道:水货无锁","price":1000,"type_name":"苹果 iPhone 7 （亮黑色）","type_sn_id":"tgg"}],"title":"苹果","title_id":"59280"},{"datas":[{"add_time":"2016-12-10 14:54:58","cart_id":"445162","house_id":"1","msg":"边框背板:全新未使用","price":50,"type_name":"小米4s (白金色)","type_sn_id":"ggh"},{"add_time":"2016-12-10 14:55:18","cart_id":"445163","house_id":"1","msg":"屏幕性能:色差/亮点/轻微发黄","price":100,"type_name":"小米5s （亮黑色）","type_sn_id":"tgg"}],"title":"小米","title_id":"59279"},{"datas":[{"add_time":"2016-12-10 14:54:58","cart_id":"445162","house_id":"1","msg":"边框背板:全新未使用","price":50,"type_name":"三星 (白金色)","type_sn_id":"ggh"},{"add_time":"2016-12-10 14:55:18","cart_id":"445163","house_id":"1","msg":"屏幕性能:色差/亮点/轻微发黄","price":100,"type_name":"三星 （亮黑色）","type_sn_id":"tgg"}],"title":"三星","title_id":"59279"},{"datas":[{"add_time":"2016-12-10 14:54:58","cart_id":"445162","house_id":"1","msg":"边框背板:全新未使用","price":50,"type_name":"华为 (白金色)","type_sn_id":"ggh"},{"add_time":"2016-12-10 14:55:18","cart_id":"445163","house_id":"1","msg":"屏幕性能:色差/亮点/轻微发黄","price":100,"type_name":"华为 （亮黑色）","type_sn_id":"tgg"},{"add_time":"2016-12-10 4:55:28","cart_id":"445164","house_id":"1","msg":"屏幕性能:色差/亮点/轻微发黄","price":150,"type_name":"华为 （纯黑色）","type_sn_id":"hgg"}],"title":"华为","title_id":"59279"}]
     * flag : Success
     * msg : 描述
     */

    private String code;
    private String flag;
    private String msg;
    private List<DataBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * datas : [{"add_time":"2016-12-10 14:54:58","cart_id":"445162","house_id":"1","msg":"购买渠道:大陆国行","price":500,"type_name":"苹果 iPhone 6（白金色）","type_sn_id":"ggh"},{"add_time":"2016-12-10 14:55:18","cart_id":"445163","house_id":"1","msg":"购买渠道:水货无锁","price":1000,"type_name":"苹果 iPhone 7 （亮黑色）","type_sn_id":"tgg"}]
         * title : 苹果
         * title_id : 59280
         */

        private String title;
        private String title_id;
        private List<DatasBean> datas;
        private boolean isCallCex;

        public boolean isCallCex() {
            return isCallCex;
        }

        public void setCallCex(boolean callCex) {
            isCallCex = callCex;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle_id() {
            return title_id;
        }

        public void setTitle_id(String title_id) {
            this.title_id = title_id;
        }

        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public static class DatasBean {
            /**
             * add_time : 2016-12-10 14:54:58
             * cart_id : 445162
             * house_id : 1
             * msg : 购买渠道:大陆国行
             * price : 500
             * type_name : 苹果 iPhone 6（白金色）
             * type_sn_id : ggh
             */

            private String add_time;
            private String cart_id;
            private String house_id;
            private String msg;
            private int price;
            private String type_name;
            private String type_sn_id;
            private boolean zisCallCex;

            public boolean isZisCallCex() {
                return zisCallCex;
            }

            public void setZisCallCex(boolean zisCallCex) {
                this.zisCallCex = zisCallCex;
            }

            public String getAdd_time() {
                return add_time;
            }

            public void setAdd_time(String add_time) {
                this.add_time = add_time;
            }

            public String getCart_id() {
                return cart_id;
            }

            public void setCart_id(String cart_id) {
                this.cart_id = cart_id;
            }

            public String getHouse_id() {
                return house_id;
            }

            public void setHouse_id(String house_id) {
                this.house_id = house_id;
            }

            public String getMsg() {
                return msg;
            }

            public void setMsg(String msg) {
                this.msg = msg;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public String getType_name() {
                return type_name;
            }

            public void setType_name(String type_name) {
                this.type_name = type_name;
            }

            public String getType_sn_id() {
                return type_sn_id;
            }

            public void setType_sn_id(String type_sn_id) {
                this.type_sn_id = type_sn_id;
            }
        }
    }
}

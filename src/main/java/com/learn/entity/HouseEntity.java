package com.learn.entity;

        import java.io.Serializable;
        import java.util.Date;
        import com.learn.service.*;



/**
 * 房屋信息
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-14 21:43:35
 */
public class HouseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

            //
                    private Long id;
        
            //小区
                    private String xiaoqu;
        
            //所在地区
                    private String area;
        
            //价格
                    private Double price;
        
            //户型
                    private String huxing;
        
            //图片
                    private String img;
        
            //联系人
                    private String lianxi;
        
            //联系方式
                    private String phone;
        
            //状态
                    private String state;
        
            //卖家
                    private Long saler;

            private  SalerEntity  salerEntity;

            public SalerEntity getSalerEntity() {
                return salerEntity;
            }

            public void setSalerEntity(SalerEntity salerEntity) {
                this.salerEntity = salerEntity;
            }
        
            //买家
                    private Long buyer;

            private  BuyerEntity  buyerEntity;

            public BuyerEntity getBuyerEntity() {
                return buyerEntity;
            }

            public void setBuyerEntity(BuyerEntity buyerEntity) {
                this.buyerEntity = buyerEntity;
            }
        
            //更新时间
                    private String time;
        
            //添加时间
                    private Date gmttime =new  Date();
        
    
            /**
         * 设置：
         */
        public void setId(Long id) {
            this.id = id;
        }

        /**
         * 获取：
         */
        public Long getId() {
            return id;
        }
            /**
         * 设置：小区
         */
        public void setXiaoqu(String xiaoqu) {
            this.xiaoqu = xiaoqu;
        }

        /**
         * 获取：小区
         */
        public String getXiaoqu() {
            return xiaoqu;
        }
            /**
         * 设置：所在地区
         */
        public void setArea(String area) {
            this.area = area;
        }

        /**
         * 获取：所在地区
         */
        public String getArea() {
            return area;
        }
            /**
         * 设置：价格
         */
        public void setPrice(Double price) {
            this.price = price;
        }

        /**
         * 获取：价格
         */
        public Double getPrice() {
            return price;
        }
            /**
         * 设置：户型
         */
        public void setHuxing(String huxing) {
            this.huxing = huxing;
        }

        /**
         * 获取：户型
         */
        public String getHuxing() {
            return huxing;
        }
            /**
         * 设置：图片
         */
        public void setImg(String img) {
            this.img = img;
        }

        /**
         * 获取：图片
         */
        public String getImg() {
            return img;
        }
            /**
         * 设置：联系人
         */
        public void setLianxi(String lianxi) {
            this.lianxi = lianxi;
        }

        /**
         * 获取：联系人
         */
        public String getLianxi() {
            return lianxi;
        }
            /**
         * 设置：联系方式
         */
        public void setPhone(String phone) {
            this.phone = phone;
        }

        /**
         * 获取：联系方式
         */
        public String getPhone() {
            return phone;
        }
            /**
         * 设置：状态
         */
        public void setState(String state) {
            this.state = state;
        }

        /**
         * 获取：状态
         */
        public String getState() {
            return state;
        }
            /**
         * 设置：卖家
         */
        public void setSaler(Long saler) {
            this.saler = saler;
        }

        /**
         * 获取：卖家
         */
        public Long getSaler() {
            return saler;
        }
            /**
         * 设置：买家
         */
        public void setBuyer(Long buyer) {
            this.buyer = buyer;
        }

        /**
         * 获取：买家
         */
        public Long getBuyer() {
            return buyer;
        }
            /**
         * 设置：更新时间
         */
        public void setTime(String time) {
            this.time = time;
        }

        /**
         * 获取：更新时间
         */
        public String getTime() {
            return time;
        }
            /**
         * 设置：添加时间
         */
        public void setGmttime(Date gmttime) {
            this.gmttime = gmttime;
        }

        /**
         * 获取：添加时间
         */
        public Date getGmttime() {
            return gmttime;
        }
    }

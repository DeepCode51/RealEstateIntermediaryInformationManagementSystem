package com.learn.entity;

        import java.io.Serializable;
        import java.util.Date;
        import com.learn.service.*;



/**
 * 卖家信息
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-14 21:43:34
 */
public class SalerEntity implements Serializable {
    private static final long serialVersionUID = 1L;

            //
                    private Long id;
        
            //姓名
                    private String name;
        
            //性别
                    private String sex;
        
            //年龄
                    private String age;
        
            //身份证号
                    private String card;
        
            //手机号码
                    private String phone;
        
            //所在城市
                    private String city;
        
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
         * 设置：姓名
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * 获取：姓名
         */
        public String getName() {
            return name;
        }
            /**
         * 设置：性别
         */
        public void setSex(String sex) {
            this.sex = sex;
        }

        /**
         * 获取：性别
         */
        public String getSex() {
            return sex;
        }
            /**
         * 设置：年龄
         */
        public void setAge(String age) {
            this.age = age;
        }

        /**
         * 获取：年龄
         */
        public String getAge() {
            return age;
        }
            /**
         * 设置：身份证号
         */
        public void setCard(String card) {
            this.card = card;
        }

        /**
         * 获取：身份证号
         */
        public String getCard() {
            return card;
        }
            /**
         * 设置：手机号码
         */
        public void setPhone(String phone) {
            this.phone = phone;
        }

        /**
         * 获取：手机号码
         */
        public String getPhone() {
            return phone;
        }
            /**
         * 设置：所在城市
         */
        public void setCity(String city) {
            this.city = city;
        }

        /**
         * 获取：所在城市
         */
        public String getCity() {
            return city;
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

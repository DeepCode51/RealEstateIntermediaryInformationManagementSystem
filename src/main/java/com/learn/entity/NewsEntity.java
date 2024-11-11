package com.learn.entity;

        import java.io.Serializable;
        import java.util.Date;
        import com.learn.service.*;



/**
 * 通知公告
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-04-14 21:41:54
 */
public class NewsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

            //
                    private Long id;
        
            //标题
                    private String title;
        
            //内容
                    private String content;
        
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
         * 设置：标题
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         * 获取：标题
         */
        public String getTitle() {
            return title;
        }
            /**
         * 设置：内容
         */
        public void setContent(String content) {
            this.content = content;
        }

        /**
         * 获取：内容
         */
        public String getContent() {
            return content;
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

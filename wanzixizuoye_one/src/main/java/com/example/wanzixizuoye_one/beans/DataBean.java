package com.example.wanzixizuoye_one.beans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class DataBean {


    @Property(nameInDb = "aid")
    @Id
    private Long aid;
    private String id;
    private String title;
    private String pic;
    private String collect_num;
    private String food_str;
    private int num;
    @Generated(hash = 1390445305)
    public DataBean(Long aid, String id, String title, String pic,
            String collect_num, String food_str, int num) {
        this.aid = aid;
        this.id = id;
        this.title = title;
        this.pic = pic;
        this.collect_num = collect_num;
        this.food_str = food_str;
        this.num = num;
    }
    @Generated(hash = 908697775)
    public DataBean() {
    }
    public Long getAid() {
        return this.aid;
    }
    public void setAid(Long aid) {
        this.aid = aid;
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getPic() {
        return this.pic;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }
    public String getCollect_num() {
        return this.collect_num;
    }
    public void setCollect_num(String collect_num) {
        this.collect_num = collect_num;
    }
    public String getFood_str() {
        return this.food_str;
    }
    public void setFood_str(String food_str) {
        this.food_str = food_str;
    }
    public int getNum() {
        return this.num;
    }
    public void setNum(int num) {
        this.num = num;
    }
}

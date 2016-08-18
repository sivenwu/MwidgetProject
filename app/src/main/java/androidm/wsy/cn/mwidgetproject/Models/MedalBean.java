package androidm.wsy.cn.mwidgetproject.Models;

/**
 * Created by wsy on 2016/8/12.
 */
public class MedalBean {

    private int type;
    private String name;
    private int goldNum;
    private int silverNum;
    private int bronzeNum;

    public MedalBean() {
    }

    public MedalBean(int type, String name, int goldNum, int silverNum, int bronzeNum) {
        this.type = type;
        this.name = name;
        this.goldNum = goldNum;
        this.silverNum = silverNum;
        this.bronzeNum = bronzeNum;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGoldNum() {
        return goldNum;
    }

    public void setGoldNum(int goldNum) {
        this.goldNum = goldNum;
    }

    public int getSilverNum() {
        return silverNum;
    }

    public void setSilverNum(int silverNum) {
        this.silverNum = silverNum;
    }

    public int getBronzeNum() {
        return bronzeNum;
    }

    public void setBronzeNum(int bronzeNum) {
        this.bronzeNum = bronzeNum;
    }
}

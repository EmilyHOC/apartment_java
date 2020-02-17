package com.njwb.entity;

public class Custom {
    private int customId;      //客户序号
    private String custom_name;  //姓名
    private String custom_sex;    //性别
    private String custom_age; //年龄
    private String custom_phone; //手机号
    private String custom_occupation;//职业
    private String custom_rendInfo;//租房信息
    private String custom_rendNeed; //租房需求
    private String custom_introducer; //租房介绍人
    private boolean custom_sign; //是否签订租房合同

    public boolean isCustom_sign() {
        return custom_sign;
    }

    public void setCustom_sign(boolean custom_sign) {
        this.custom_sign = custom_sign;
    }

    public int getCustomId() {
        return customId;
    }

    public String getCustom_name() {
        return custom_name;
    }

    public String getCustom_sex() {
        return custom_sex;
    }

    public String getCustom_age() {
        return custom_age;
    }

    public String getCustom_phone() {
        return custom_phone;
    }

    public String getCustom_occupation() {
        return custom_occupation;
    }

    public String getCustom_rendInfo() {
        return custom_rendInfo;
    }

    public String getCustom_rendNeed() {
        return custom_rendNeed;
    }

    public String getCustom_introducer() {
        return custom_introducer;
    }

	public void setCustomId(int customId) {
		this.customId = customId;
	}

	public void setCustom_name(String custom_name) {
		this.custom_name = custom_name;
	}

	public void setCustom_sex(String custom_sex) {
		this.custom_sex = custom_sex;
	}

	public void setCustom_age(String custom_age) {
		this.custom_age = custom_age;
	}

	public void setCustom_phone(String custom_phone) {
		this.custom_phone = custom_phone;
	}

	public void setCustom_occupation(String custom_occupation) {
		this.custom_occupation = custom_occupation;
	}

	public void setCustom_rendInfo(String custom_rendInfo) {
		this.custom_rendInfo = custom_rendInfo;
	}

	public void setCustom_rendNeed(String custom_rendNeed) {
		this.custom_rendNeed = custom_rendNeed;
	}

	public void setCustom_introducer(String custom_introducer) {
		this.custom_introducer = custom_introducer;
	}
}

package com.briup.zhxypj.bean.ex;

import java.io.Serializable;
import java.util.List;

public class QuestionExl implements Serializable {
    private Integer id;

    private String name;

    private String type;

    List<OptionsExl> optionsEXES;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<OptionsExl> getOptionsEXES() {
        return optionsEXES;
    }

    public void setOptionsEXES(List<OptionsExl> optionsEXES) {
        this.optionsEXES = optionsEXES;
    }
}

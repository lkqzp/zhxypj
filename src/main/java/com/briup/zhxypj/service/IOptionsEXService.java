package com.briup.zhxypj.service;




import com.briup.zhxypj.bean.ex.OptionsExl;

import java.util.List;

public interface IOptionsEXService {
    List<OptionsExl> findAllOptions() throws RuntimeException;
}

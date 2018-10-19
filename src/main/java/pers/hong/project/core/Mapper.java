package pers.hong.project.core;

import tk.mybatis.mapper.common.*;

/**
 * @Description: 通用Mapper接口
 * @Auther: zwh
 * @Date: 2018/10/18
 */
public interface Mapper<T> extends BaseMapper<T>, MySqlMapper<T>, IdsMapper<T>, ConditionMapper<T>, ExampleMapper<T> {

}

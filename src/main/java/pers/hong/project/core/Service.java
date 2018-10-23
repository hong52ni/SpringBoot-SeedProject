package pers.hong.project.core;

import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * @Description: 通用service
 * @Auther: zwh
 * @Date: 2018/10/18
 */
public interface Service<T> {
    /**
     * 通过Id查找
     *
     * @param id
     * @return T
     */
    T findById(Integer id);

    /**
     * 通过Model中某个成员变量名称（非数据表中column的名称）查找,value需符合unique约束
     *
     * @param fieldName
     * @return T
     */
    T findBy(String fieldName, Object value) throws TooManyResultsException;

    /**
     * 条件查询
     *
     * @param condition
     * @return List
     */
    List<T> findByCondition(Condition condition);

    /**
     * 查询所有信息
     *
     * @return List
     */
    List<T> findAll();

    /**
     * 增加数据
     *
     * @param model
     */
    void save(T model);

    /**
     * 批量增加数据
     *
     * @param models
     */
    void save(List<T> models);


    /**
     * 根据id删除数据
     *
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 批量删除
     *
     * @param ids
     */
    void deleteBatch(String ids);

    /**
     * 更新数据
     *
     * @param model
     */
    void update(T model);
}

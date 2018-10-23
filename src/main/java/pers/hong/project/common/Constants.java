package pers.hong.project.common;

/**
 * @Description: 常量设置
 * @Auther: zwh
 * @Date: 2018/09/18
 */
public class Constants {
    public static final int RESULT_CODE_SUCCESS = 200;  // 成功处理请求
    public static final int RESULT_CODE_BAD_REQUEST = 412;  // 请求错误
    public static final int RESULT_CODE_NOT_LOGIN = 402;  // 未登录
    public static final int RESULT_CODE_PARAM_ERROR = 406;  // 传参错误
    public static final int RESULT_CODE_SERVER_ERROR = 500;  // 服务器错误

    public static final String BASE_PACKAGE = "pers.hong.project";//代码生成存放的基础包地址
    public static final String ENTITY_PACKAGE = BASE_PACKAGE + ".entity";//Entity实体类包
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".mapper";//Mapper接口包
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";//Service接口包
    public static final String SERVICE_IMPL_PACKAGE = BASE_PACKAGE + ".service.impl";//Service实现类包
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".controller";//Controller接口包
    public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".core.mapper";//Mapper插件基础接口的完全限定名

    public final static int PAGE_SIZE = 10;//默认分页条数

}

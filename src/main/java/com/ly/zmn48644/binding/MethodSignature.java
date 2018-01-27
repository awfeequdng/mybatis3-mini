package com.ly.zmn48644.binding;

import com.ly.zmn48644.reflection.TypeParameterResolver;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;

/**
 * 方法签名类,封装 接口中方法的返回值类型,以及方法参数.
 */
public class MethodSignature {

    //返回值是否是 void
    private final boolean returnsVoid;
    //返回值是否是 集合或者数组 这种多元素的类型
    private final boolean returnsMany;
    //返回值的类型
    private final Class<?> returnType;


    /**
     * 构造方法中传入的 class 和 method 初始化成员属性
     *
     * @param mapperInterface
     * @param method
     */
    public MethodSignature(Class<?> mapperInterface, Method method) {

        //通过反射工具获取到接口中方法的返回值类型
        Type resolvedReturnType = TypeParameterResolver.resolveReturnType(method, mapperInterface);
        //设置 returnType 这里面有三种情况
        if (resolvedReturnType instanceof Class<?>) {
            //第一种情况返回的 是没有带泛型信息的 比如 int String User 等等
            this.returnType = (Class<?>) resolvedReturnType;
        } else if (resolvedReturnType instanceof ParameterizedType) {
            //第二种情况是 返回的是 参数化类型 比如  List<String> ,Set<String> 等等
            this.returnType = (Class<?>) ((ParameterizedType) resolvedReturnType).getRawType();
        } else {
            //第三种情况 如果上面两种情况没有获得 返回值类型 则直接调用 方法的 getReturnType获取返回值类型
            //TODO 这里是有些疑问的.还不清楚 返回值 是那种类型会出现这种情况
            this.returnType = method.getReturnType();
        }
        this.returnsVoid = void.class.equals(this.returnType);
        //判断返回值是否是数组类型,或者是集合类型
        //TODO 这里判断是否是集合的方法 没有抽取到 objectFactory 中 以后如果多个地方使用到 再进行抽取.
        this.returnsMany = this.returnType.isArray() || Collection.class.isAssignableFrom(this.returnType);

    }

    public boolean isReturnsVoid() {
        return returnsVoid;
    }

    public boolean isReturnsMany() {
        return returnsMany;
    }

    public Class<?> getReturnType() {
        return returnType;
    }
}

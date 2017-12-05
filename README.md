### 2017-12-04 17:53:35
首先实现了对mapper接口创建代理对象的功能.
存在的问题是每次getMapper都会创建一个 MapperProxy 对象,这是不合理的,因此可以使用工厂模式来创建MapperProxy对象,在工厂中可以缓存MapperProxy对象.



# JavaStudy
类图六大关系：  
1、依赖关系Dependence
只要是类中用到了对方，就是依赖关系  

	• 对方是类的成员属性
	• 对方是类方法的返回类型
	• 对方是类方法接收参数类型
	• 对方在类方法中使用到

2、泛化关系Generalization  
泛化关系实际上是继承关系，是依赖关系的特例  
3、实现关系Implementation、Relization  
实现关系实际就是A类实现B接口，是依赖关系的特例  
4、关联关系Association  
关联关系实际上就是类与类的联系，是依赖关系的特例  
关联关系具有导航性，即谁关联谁的问题  
有单向关联关系、双向关联关系  
5、聚合关系Aggregation  
 表示的是整体和部分的关系，整体和部分可以分开。聚合关系是关联关系的特例    
 如果整体和部分不能分开，则升级为组合关系  
6、组合关系Composition  
 如一个类的成员变量直接为private Mouse mouse = new Mouse()时，代表此类与Mouse类
不可分开，为组合关系  

设计模式是某类问题的通用解决方案，为了提高软件维护性、通用性和扩展性  
设计模式分三种类型：  

	1.创建者模式：强调对象的创建。单例、抽象工厂、原型、建造者、工厂  
	2.结构型模式：站在软件结构方面思考。适配器、桥接、装饰、组合、外观、享元、代理  
    3.行为型模式：站在方法角度思考。模板方法、命令、访问者、迭代器、观察者、中介者、备忘录、解释器(Interpreter)、状态、策略、责任链(职责链)  
package com.huangxw.DesignPattern.singleton;

/**枚举
 *不仅能避免多线程问题，还能防止反序列化重新创建新的对象
 * 是Effective Java作者推荐的方式
 * 结论：也是很推荐的方式
**/
enum Singleton7 {
    INSTANCE;
    public void sayOK(){
        System.out.println("ok~~");
    }

    public static void main(String[] args) {
        Runtime.getRuntime();
        Singleton7 singleton1 = Singleton7.INSTANCE;
    }
}

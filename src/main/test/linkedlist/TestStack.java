package main.test.linkedlist;

import java.util.Stack;

/**
 * @ClassName TestStack
 * @Description 栈测试
 * @Author Administrator
 * @Date 2020/12/24 14:41
 * @Version 1.0
 */
public class TestStack {
    public static void main(String[] args) {
        /**
         * stack 原理：
         * 1.当new Stack的时候，调用父类Vector的构造函数
         *      public Vector() {
         *         this(10);
         *     }
         *   初始化一个长度为10的Object数组
         *   调用push的时候，本质是调用vector的addElement(item)
         *      public <Strong>synchronized</Strong> void addElement(E obj) {
         *         modCount++;
         *         ensureCapacityHelper(elementCount + 1);
         *         elementData[elementCount++] = obj;
         *     }
         *    所以栈是线程安全的方法
         *    pop的方法是：直接获取数组的最后一个元素，然后将最后这个元素的位置置为null，即删除
         *    public synchronized E pop() {
         *         E       obj;
         *         int     len = size();
         *
         *         obj = peek();
         *         removeElementAt(len - 1);
         *
         *         return obj;
         *     }
         *     public synchronized void removeElementAt(int index) {
         *         modCount++;
         *         if (index >= elementCount) {
         *             throw new ArrayIndexOutOfBoundsException(index + " >= " +
         *                                                      elementCount);
         *         }
         *         else if (index < 0) {
         *             throw new ArrayIndexOutOfBoundsException(index);
         *         }
         *         int j = elementCount - index - 1;
         *         if (j > 0) {
         *             System.arraycopy(elementData, index + 1, elementData, index, j);
         *         }
         *         elementCount--;
         *         elementData[elementCount] = null;  //to let gc do its work
         *  }
         * */
        Stack<String> stack = new Stack<>();
        stack.push("aaa");
        stack.push("bbb");
        stack.push("ccc");
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}

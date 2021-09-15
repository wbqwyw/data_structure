package main.test.linkedlist;

import java.util.Stack;

/**
 * @ClassName TestStack
 * @Description ջ����
 * @Author Administrator
 * @Date 2020/12/24 14:41
 * @Version 1.0
 */
public class TestStack {
    public static void main(String[] args) {
        /**
         * stack ԭ��
         * 1.��new Stack��ʱ�򣬵��ø���Vector�Ĺ��캯��
         *      public Vector() {
         *         this(10);
         *     }
         *   ��ʼ��һ������Ϊ10��Object����
         *   ����push��ʱ�򣬱����ǵ���vector��addElement(item)
         *      public <Strong>synchronized</Strong> void addElement(E obj) {
         *         modCount++;
         *         ensureCapacityHelper(elementCount + 1);
         *         elementData[elementCount++] = obj;
         *     }
         *    ����ջ���̰߳�ȫ�ķ���
         *    pop�ķ����ǣ�ֱ�ӻ�ȡ��������һ��Ԫ�أ�Ȼ��������Ԫ�ص�λ����Ϊnull����ɾ��
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

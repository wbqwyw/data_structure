package main.test.tree;

import java.io.*;
import java.util.*;

/**
 * @ClassName HuffmanTreeCode
 * @Description 赫夫曼编码
 * 1.将字符串转字节数组
 * 2.统计每个字节出现的次数
 * 3.构建赫夫曼树
 * 4.遍历赫夫曼树，然后获得每个字节对应的赫夫曼编码
 * 5.遍历字节数组，然后对照赫夫曼编码，生成二进制字符串
 * 6.构建新的字节数组
 * 7.将生成的二进制字符串转成字节数组
 * @Author Administrator
 * @Date 2020/12/29 11:19
 * @Version 1.0
 */
public class HuffmanTreeCode {
    private static Map<Byte, String> huffCodeMap = new HashMap<>();

    private static StringBuilder sbuilder = new StringBuilder();

    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        //将字符串转成字节数组
        byte[] data = getByte(content);
        byte[] huffCode = huffCode(data);
        System.out.println(Arrays.toString(huffCode));
        byte[] bytes = decode(huffCodeMap, huffCode);
        System.out.println(new String(bytes));
        zipFile("D:\\电子书\\数据结构与算法\\尚硅谷_韩顺平\\图解.xlsx", "D:\\电子书\\数据结构与算法\\尚硅谷_韩顺平\\图解.zip");
        System.out.println("压缩完成");
    }

    //压缩文件
    public static void zipFile(String srcFile, String dstFile) {
        try (FileInputStream fis = new FileInputStream(srcFile);
             OutputStream fos = new FileOutputStream(dstFile);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            byte[] newBytes = huffCode(bytes);
            oos.writeObject(newBytes);
            oos.writeObject(huffCodeMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] decode(Map<Byte, String> map, byte[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            byte b = arr[i];
            //最后一位可能不满8位，所以不需要补码操作
            boolean flag = (i == arr.length - 1);
            sb.append(byteToBitString(!flag, b));
        }
        HashMap<String, Byte> stringByteHashMap = new HashMap<>();
        for (Map.Entry<Byte, String> entry : map.entrySet()) {
            stringByteHashMap.put(entry.getValue(), entry.getKey());
        }
        ArrayList<Byte> bytes = new ArrayList<>();
        for (int i = 0; i < sb.length(); ) {
            int count = 1;
            boolean flag = true;
            while (flag) {
                String s = sb.substring(i, i + count);
                if (stringByteHashMap.containsKey(s)) {
                    bytes.add(stringByteHashMap.get(s));
                    flag = false;
                } else {
                    count++;
                }
            }
            i += count;
        }
        byte[] buff = new byte[bytes.size()];
        for (int i = 0; i < buff.length; i++) {
            buff[i] = bytes.get(i);
        }
        return buff;
    }

    public static String byteToBitString(boolean flag, byte b) {
        //转10进制，为了生成二进制字符串，因为byte没有相关方法转
        int temp = b;
        if (flag) {
            //补高位，因为整数没有高位。这是关系与
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag) {
            //截取开始的8位
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    public static byte[] huffCode(byte[] data) {
        //统计每个字节重复出现的个数，映射关系
        Map<Byte, Integer> byteMap = byteToMap(data);
        //将重复出现个数转成集合
        List<NodeCode> list = mapToList(byteMap);
        //将集合转成哈夫曼树
        NodeCode root = listToHuffmanTree(list);
        //建立每个字符对应的哈夫曼路径
        getHuffCode(root);
        //对照字符串和哈夫曼路径表，生成一个二进制字符串
        buildHuffCodeString(data);
        //将二进制字符串转为字节数组，达到压缩的目的
        byte[] huffCode = huffCodeToByteArr();
        return huffCode;
    }

    public static byte[] getByte(String message) {
        return message == null ? null : message.getBytes();
    }

    public static Map<Byte, Integer> byteToMap(byte[] arr) {
        Map<Byte, Integer> map = new HashMap<>(10);
        if (arr == null) {
            return null;
        }
        for (byte b : arr) {
            if (map.get(b) == null) {
                map.put(b, 1);
            } else {
                map.put(b, map.get(b) + 1);
            }
        }
        return map;
    }

    public static List<NodeCode> mapToList(Map<Byte, Integer> map) {
        ArrayList<NodeCode> list = new ArrayList<>();
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            list.add(new NodeCode(entry.getKey(), entry.getValue()));
        }
        return list;
    }

    public static NodeCode listToHuffmanTree(List<NodeCode> list) {
        while (list.size() > 1) {
            Collections.sort(list);
            NodeCode left = list.get(0);
            NodeCode right = list.get(1);
            NodeCode parent = new NodeCode((byte) 0, left.weight + right.weight);
            parent.left = left;
            parent.right = right;
            list.remove(left);
            list.remove(right);
            list.add(parent);
        }
        return list.get(0);
    }

    public static void getHuffCode(NodeCode node) {
        //此处传new StringBuilder();也是可以，只是为了传空缓冲区
        getHuffCode(node.left, "0", sbuilder);
        getHuffCode(node.right, "1", sbuilder);
    }

    public static void getHuffCode(NodeCode node, String code, StringBuilder stringBuilder) {
        //因为是统计每一个节点的路径，所以每走一个节点，都要新建缓冲区来承接上个节点的路径
        //避免统计不清楚
        StringBuilder sb = new StringBuilder(stringBuilder);
        sb.append(code);
        if (node != null) {
            if (node.data == 0) {
                getHuffCode(node.left, "0", sb);
                getHuffCode(node.right, "1", sb);
            } else {
                huffCodeMap.put(node.data, sb.toString());
            }
        }
    }

    public static void buildHuffCodeString(byte[] arr) {
        for (byte b : arr) {
            sbuilder.append(huffCodeMap.get(b));
        }
    }

    public static byte[] huffCodeToByteArr() {
        int len = 0;
        //有一种写法
        //len = sbuilder.length() + 7 /8;
        if (sbuilder.length() % 8 == 0) {
            len = sbuilder.length() / 8;
        } else {
            len = sbuilder.length() / 8 + 1;
        }
        byte[] bytes = new byte[len];
        int index = 0;
        for (int i = 0; i < sbuilder.length(); i += 8) {
            if (i + 8 < sbuilder.length()) {
                bytes[index] = (byte) Integer.parseInt(sbuilder.substring(i, i + 8), 2);
            } else {
                bytes[index] = (byte) Integer.parseInt(sbuilder.substring(i), 2);
            }
            index++;
        }
        return bytes;
    }

}

class NodeCode implements Comparable<NodeCode> {
    public byte data;
    public int weight;
    public NodeCode left;
    public NodeCode right;

    public NodeCode(byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "NodeCode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(NodeCode o) {
        return this.weight - o.weight;
    }
}
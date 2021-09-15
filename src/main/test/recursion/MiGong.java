package main.test.recursion;

/**
 * @ClassName MiGong
 * @Description 迷宫问题
 * //使用递归回溯来给小球找路
 * 	//说明
 * 	//1. map 表示地图
 * 	//2. i,j 表示从地图的哪个位置开始出发 (1,1)
 * 	//3. 如果小球能到 map[6][5] 位置，则说明通路找到.
 * 	//4. 约定： 当map[i][j] 为 0 表示该点没有走过 当为 1 表示墙  ； 2 表示通路可以走 ； 3 表示该点已经走过，但是走不通
 * 	//5. 在走迷宫时，需要确定一个策略(方法) 下->右->上->左 , 如果该点走不通，再回溯
 * @Author Administrator
 * @Date 2020/12/25 17:12
 * @Version 1.0
 */
public class MiGong {
}

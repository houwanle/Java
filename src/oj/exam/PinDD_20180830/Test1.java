package PinDD_20180830;
/*题目描述
    你在玩一个回合制角色扮演的游戏。现在你在准备一个策略，
    以便在最短的回合内击败敌方角色。在战斗开始时，敌人拥有
    HP格血量。当血量小于等于0时，敌人死去。一个缺乏经验的
    玩家可能简单地尝试每个回合都攻击。但是你知道辅助技能的
    重要性。
    在你的每个回合开始时你可以选择以下两个动作之一：聚力或者攻击。
     聚力会提高你下个回合攻击的伤害。
     攻击会对敌人造成一定量的伤害。如果你上个回合使用了聚力，
     那这次攻击会对敌人造成bufferAttack点伤害。否则，会造成
     normalAttack,返回你能杀死敌人的最小回合数。

     输入描述：
     第一行是一个数字HP
     第二行是一个数字normalAttack
     第三行是一个数字bufferAttack
     1<=HP,bufferAttack,normalAttack<=10^9
     输出描述：
     输出一个数字表示最小回合数

     示例
     输入：
     13
     3
     5
     输出：
     5
 */
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        int time = 0;
        if(n3 <= n2 * 2) {
            time = n1 % n2 == 0 ? n1 / n2 : (n1 / n2 + 1);
        }else {
            int temp = n1 % n3;
            time = n1 / n3 * 2;
            if(temp != 0) {
                if(n2 >= temp) {
                    time = time + 1;
                }else {
                    time = time + 2;
                }
            }
        }
        System.out.println(time);
    }
}

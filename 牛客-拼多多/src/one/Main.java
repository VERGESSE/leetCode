package one;

import java.util.Scanner;

public class Main {

    //得到0-9在原手机号中出现的次数
    private static int[] getRepeatTimes(char[] phoneNum) {
        int[] repeatTimes = new int[10];
        for (int i = 0; i < phoneNum.length; i ++) {
            repeatTimes[phoneNum[i] - '0'] ++;
        }
        return repeatTimes;
    }

    //最小代价优先的贪心算法
    private static void GreedyMinCost(int phoneNumSize, int neededRepeatTimes, char[] phoneNum) {
        int minCost = Integer.MAX_VALUE;//想要最小值，初值设置最大整数
        char[] newPhoneNum = new char[phoneNumSize];
        int[] repeatTimes = getRepeatTimes(phoneNum);

        for (int currentNum = 0; currentNum < 10; currentNum ++) {

            int restNeededRepeatTimes = neededRepeatTimes - repeatTimes[currentNum];
            //初始可能重复数字次数就大于需求值
            if (restNeededRepeatTimes <= 0) {
                minCost = 0;
                newPhoneNum = phoneNum;
                break;
            }

            int currentNumCost = 0;
            int upperLimitNum = currentNum + 1;
            int lowerLimitNum = currentNum - 1;

            char[] alternativePhoneNum = new char[phoneNumSize];
            //alternativePhoneNum每次循环前都初始为phoneNum的复制
            System.arraycopy(phoneNum, 0, alternativePhoneNum, 0, phoneNumSize);

            while (restNeededRepeatTimes > 0) {
                //如果手机号中数字比最佳数字大的情况就从前往后改
                if (upperLimitNum < 10) {
                    for (int i = 0; i < phoneNumSize && restNeededRepeatTimes > 0; i ++) {
                        if (phoneNum[i] - '0' == upperLimitNum) {
                            currentNumCost += upperLimitNum - currentNum;
                            alternativePhoneNum[i] = (char)(currentNum + '0');
                            restNeededRepeatTimes --;
                        }
                    }
                }
                //如果手机号中数字比最佳数字小的情况就从后往前改
                if (lowerLimitNum >= 0) {
                    for (int i = phoneNumSize - 1; i >= 0 && restNeededRepeatTimes > 0; i --) {
                        if (phoneNum[i] - '0' == lowerLimitNum) {
                            currentNumCost += currentNum - lowerLimitNum;
                            alternativePhoneNum[i] = (char)(currentNum + '0');
                            restNeededRepeatTimes --;
                        }
                    }
                }
                //扩大上下限
                upperLimitNum ++;
                lowerLimitNum --;
            }

            if (currentNumCost < minCost) {
                minCost = currentNumCost;
                newPhoneNum = alternativePhoneNum;
            }
        }

        System.out.println(minCost);
        System.out.println(newPhoneNum);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int phoneNumSize = input.nextInt();
        int neededRepeatTimes = input.nextInt();
        //第二行的输入的手机号是字符串不是整数！输出也很方便，值运算时清除'0'的影响
        char[] phoneNum = input.next().toCharArray();
        input.close();

        GreedyMinCost(phoneNumSize, neededRepeatTimes, phoneNum);
    }
}

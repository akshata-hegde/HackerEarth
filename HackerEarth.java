
/*Hacker and traffic lights
Zolo is stuck in a traffic due to dysfunctional traffic light. Zolo is a professional hacker
and he can get into the system and change the state of the light. His planet has
different types of traffic lights such that there are N bulbs on the traffic board and
only when all of them are green(G) the cars can pass. there are 2 other states also
which the bulb can show; i.e. Red(R) & Yellow(Y). Note that the lights are designed
such that they follow a state change cyclic pattern as follows:
R------>Y------>G------->R
Once Zolo gets into the system he can select any position i and update all elements
between i to min(N, i + K - 1) by increasing their state by 1.This whole process takes
1 sec and he can repeat this process any no. of times until he gets all lights = G . Find
the minimum time to do the process as Zolo is getting late for work.
Input Format
The first line contains N K
The second line describes the current status of each bulb as an array whose each
element can either be G or Y or R.
Output Format
Print the minimum amount of time required to clear the traffic jam".
sample input       sample output
4 2                5
R X G Y

*/

import java.util.Scanner;
 
class TestClass {
    public static void main(String args[] ) throws Exception {
        try(Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[] input = new int[N];
 
            for(int idx = 0; idx < N; ++idx) {
                switch (scanner.next().charAt(0)) {
                    case 'G': input[idx] = 0; break;
                    case 'R': input[idx] = 1; break;
                    case 'Y': input[idx] = 2; break;
                }
            }
 
            int[] temp = new int[N];
            int offset = 0, result = 0;
 
            for(int idx = 0; idx < N; ++idx) {
                input[idx] += offset;
 
                switch (input[idx] % 3) {
                    case 1: temp[idx] = 2; result += 2; offset += 2; break;
                    case 2: temp[idx] = 1; result += 1; offset += 1; break;
                    default: temp[idx] = 0; break;
                }
 
                if ((idx+1)-K >= 0) offset -= temp[idx+1-K];
            }
            System.out.println(result);
        }
    }
}

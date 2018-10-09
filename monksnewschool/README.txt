Monk has opened a new programming school in Hackerland. He is also providing hostel for the students who have joined his school.
The hostel and the school are D units away from each other. In order to provide transport to his students, Monk plans to buy a school bus.
The bus runs 1 unit in 1L of petrol. The bus will carry students from hostel to the school.

There are K movable filling stations initially located at a distance A[i] from the hostel on the straight road between the hostel
and the school. The hostel and the school themselves have their own immovable filling stations as well.
The bus can refill at any of these filling stations. The Monk can move any number of these K movable filling stations,
but moving a filling station for X units costs X dollars. Since Monk has already invested a lot of money in the construction
of his new school, he is left with C dollars which he can spend. Monk is only allowed to move these filling stations by integral units.
Note that there can be multiple filling stations at same position.
Please help Monk in finding the minimum bus tank capacity so that the bus can take the new students from the hostel to the school?

D [unit] = distance between school and hostel
petrolPerUnit [L] = 1
K movable stations at a distance A[i] from hostel
Always full tank when leaving school or hostel (immovable tanks)
X [dollar] = cost for bus to move movable station 1 unit
C [dollar] = Monks budget
Can have multiple filling stations at same position

Input Format:
The first line contains three space separated integers D, K and C
denoting the distance between the hostel and the school,
the number of movable filling stations and the total fund Monk can spend respectively.

The second line contains K space separated integers where ith corresponds to the distance of ith filling station from the hostel
on the straight line joining the hostel and the school.

Output Format:
Output a single integer which denotes the minimum bus tank capacity required so that the bus can take the new students
from the hostel to the school.

Constraints:
1 <= D <= 5000
1 <= K <= 1000
0 <= A[i] <= D
1 <= C <= 10^6

Sample input:
15 2 4
2 8

Sample output:
6

Explanation:
There are multiple ways to achieve the best answer, i.e. 6. One of the way is to move the station at 2 to 4 and the station at 8 to 10.

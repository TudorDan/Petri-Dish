# Life in a Petri dish
 
There are different life forms in the Petri dish: bacillus, coccus, and spirillum. Model the life in the dish based on the following requirements:
* All the species have two constants (for their meaning read further):



|           | bacillus  | coccus | spirillum |
| --------- | ------ | --------- | --------- |
| LIFE_SPAN | 10     | 100       | 40        |
| NEARBY    | 3      | 1         | 2         |

* All the bacteria has a position in the dish (x, y)
* Create a petri dish with one bacillus at (3, 5) and a coccus at (2, 4) to start with
* There is a 'time pulse' (1 unit) in the dish that checks two aspects of all instances:
    * If it has reached its LIFE_SPAN, it splits into two: 2 new instances of the same type of life form that has died
     are created with random coordinates in a relative circle of radius NEARBY
    * The bacteria dies if some requirements do not hold:
        * Bacilla need at least one coccus 'nearby'
        * Cocci need at least two instances of bacteria of other types 'nearby'
        * Spirilla die if there is a bacillus 'nearby'
* After in each time unit display the contents of the dish for the user to examine (console, while)

**Hints:** you should have an abstract class, use inheritance, data hiding and make sure there is no code repetition. 
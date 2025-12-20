# Day 4: Moving Rolls of Paper with a Forklift

|                 | Part One                                                                               | Part Two   |
|-----------------|----------------------------------------------------------------------------------------|------------|
| **Difficulty**  | ⭐⚪⚪⚪⚪ Trivial                                                                          |       |
| **Fun**         | ⭐⭐⭐⭐⚪ I'm back at it, y'all!                                                           |       |
| **Description** | Given a map of rolls of paper, count how many have less than 4 rolls adjacent to them. |            |
| **Method**      | 🎄 Just traversing a 2D char array                                                     |          |
| **Trip-Ups**    |                                                                                        |            |
|                 | 🎵 *I'll Love Myself - VICTORS*                                                        | |
|                 | Nice to come back to an easy one! This is my first day of Christmas break. ☺️          |            |

### Part One

You ride the escalator down to the printing department. They're clearly getting ready for Christmas; they have lots of large rolls of paper everywhere.

If you can optimize the work the forklifts are doing, maybe they would have time to spare to break through the wall.

The rolls of paper (`@`) are arranged on a large grid; the Elves even have a helpful diagram (your puzzle input) indicating where everything is located.

For example:

```
..@@.@@@@.
@@@.@.@.@@
@@@@@.@.@@
@.@@@@..@.
@@.@@@@.@@
.@@@@@@@.@
.@.@.@.@@@
@.@@@.@@@@
.@@@@@@@@.
@.@.@@@.@.
```

The forklifts can only access a roll of paper if there are **fewer than four rolls of paper in the eight adjacent positions**. If you can figure out which rolls of paper the forklifts can access, they'll spend less time looking and more time breaking down the wall to the cafeteria.

In this example, **there are 13 rolls of paper that can be accessed by a forklift** (marked with x):

```
..xx.xx@x.
x@@.@.@.@@
@@@@@.x.@@
@.@@@@..@.
x@.@@@@.@x
.@@@@@@@.@
.@.@.@.@@@
x.@@@.@@@@
.@@@@@@@@.
x.x.@@@.x.
```

Consider your complete diagram of the paper roll locations. **How many rolls of paper can be accessed by a forklift?**

***

### Part Two

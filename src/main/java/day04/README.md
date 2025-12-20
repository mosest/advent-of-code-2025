# Day 4: Moving Rolls of Paper with a Forklift

|                 | Part One                                                                                                       | Part Two                                                                                                                                                                                                            |
|-----------------|----------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Difficulty**  | ⭐⚪⚪⚪⚪ Trivial                                                                                                  | ⭐⚪⚪⚪⚪ Trivial                                                                                                                                                                                                       |
| **Fun**         | ⭐⭐⭐⭐⚪ I'm back at it!                                                                                    | ⭐⭐⭐⭐⚪                                                                                                                                                                                                               |
| **Description** | Given a map of rolls of paper, count how many are "accessible" (i.e. have fewer than 4 rolls adjacent to them). | Now iteratively remove rolls until all you're left with is the inaccessible ones.                                                                                                                                   |
| **Method**      | 🎄 Just traversing a 2D char array                                                                             | 🎄 Editing the array in-place                                                                                                                                                                                       |
| **Trip-Ups**    |                                                                                                                |                                                                                                                                                                                                                     |
|                 | 🎵 *I'll Love Myself - VICTORS*                                                                                | 🎵 *The Hotel - VICTORS*                                                                                                                                                                                            |
|                 | Nice to come back to an easy one! This is my first day of Christmas break. ☺️                                  | Easy peasy lemon squeezy. Getting kind of scared of the day where the puzzles will be difficult difficult lemon difficult.<br><br>If you're wondering if I anticipated the Part 2 problem, absolutely no I did not. |

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

In this example, **there are 13 rolls of paper that can be accessed by a forklift** (marked with `x`):

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

Now, the Elves just need help accessing as much of the paper as they can.

Once a roll of paper can be accessed by a forklift, **it can be removed.** Once a roll of paper is removed, the forklifts might be able to access more rolls of paper, which they might also be able to remove. **How many total rolls of paper could the Elves remove** if they keep repeating this process?

Starting with the same example as above, here is one way you could remove as many rolls of paper as possible, using `x` to indicate that a roll of paper was just removed:

Initial state:
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

Remove 13 rolls of paper:
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

Remove 12 rolls of paper:
```
.......x..
.@@.x.x.@x
x@@@@...@@
x.@@@@..x.
.@.@@@@.x.
.x@@@@@@.x
.x.@.@.@@@
..@@@.@@@@
.x@@@@@@@.
....@@@...
```

Remove 7 rolls of paper:
```
..........
.x@.....x.
.@@@@...xx
..@@@@....
.x.@@@@...
..@@@@@@..
...@.@.@@x
..@@@.@@@@
..x@@@@@@.
....@@@...
```

Remove 5 rolls of paper:
```
..........
..x.......
.x@@@.....
..@@@@....
...@@@@...
..x@@@@@..
...@.@.@@.
..x@@.@@@x
...@@@@@@.
....@@@...
```

Remove 2 rolls of paper:
```
..........
..........
..x@@.....
..@@@@....
...@@@@...
...@@@@@..
...@.@.@@.
...@@.@@@.
...@@@@@x.
....@@@...
```

Remove 1 roll of paper:
```
..........
..........
...@@.....
..x@@@....
...@@@@...
...@@@@@..
...@.@.@@.
...@@.@@@.
...@@@@@..
....@@@...
```

Remove 1 roll of paper:
```
..........
..........
...x@.....
...@@@....
...@@@@...
...@@@@@..
...@.@.@@.
...@@.@@@.
...@@@@@..
....@@@...
```

Remove 1 roll of paper:
```
..........
..........
....x.....
...@@@....
...@@@@...
...@@@@@..
...@.@.@@.
...@@.@@@.
...@@@@@..
....@@@...
```

Remove 1 roll of paper:
```
..........
..........
..........
...x@@....
...@@@@...
...@@@@@..
...@.@.@@.
...@@.@@@.
...@@@@@..
....@@@...
```

Stop once no more rolls of paper are accessible by a forklift. In this example, a total of **43 rolls of paper can be removed.**

Start with your original diagram. **How many rolls of paper in total can be removed** by the Elves and their forklifts?
# General

In that project I implemented two algorithms for finding requested number
in Fibonacci's sequence. The first one algorithm is the most popular recursive approach
while the second one is implementation of Bineth formula which allows us to calculate
required Fibonacci's number in constant time. More details below:

## Recursive approach
The most popular and I think this is the one you were expecting from me to implement.

**Drawback:** Exponential complexity

**Pros:** Accurate

## Binet's algorithm
Unlike the recursive approach [Binet's formula](https://en.wikipedia.org/wiki/Fibonacci_number#Relation_to_the_golden_ratio) calculates Fibonacci's number
in a constant time and memory which makes it much more preferable. It does
have a significant drawback though. For the accurate calculation it requires 100% accurate value fractions
while they are losed with value type limitations. On my knowledge it calculates correct numbers for
`n<70`. As a result we have

**Drawback:** Wrong output on big indexes
**Pros:** Constant complexety

# Build
`mvn clean package`

# Run
`cd target/`

`java -jar fibonacci-app-1.0-SNAPSHOT.jar <FIBONACCI INDEX>`
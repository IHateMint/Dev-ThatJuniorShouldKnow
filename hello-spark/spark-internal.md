## JVM

When we execute Java Application, the allocated memory can be divided into 2 parts. Native Heap and Java Heap. In Java Heap, reference type uses more memory than primitive type. Thus, frameworks such as Spark try to lower the overhead of JVM object.

## Java Garbage Collection

Garbage collection is based on 'weak generational hypothesis'. Most of the objects become unused quickly, but the ones that do not, usually survive for a very long time.

Due to JVM object memory layout, much memory are consumed to represent a single value, and causes GC. To solve the problem, Project Tungsten and Netty came in.

## Project Tungsten

1. Memory Management and Binary Processing: Supervise memory more explicitly and remove overhead of JVM object and GC.
2. Cache-aware computation: Use algorithm and data structure that uses memory hierarchy structure.
3. Code generation: Generate code to use modern compiler and CPU.

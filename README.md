# Traveling Salesman Problem (TSP) - 2-Approximation Algorithm

## Project Overview
This project is a **CPS3440 programming assignment**, implementing a **2-approximation algorithm** for the **Symmetric Euclidean Traveling Salesman Problem (TSP)**. The program uses **Prim’s or Kruskal’s algorithm** to compute the **Minimum Spanning Tree (MST)** and constructs an approximate TSP solution based on it.

## Features
- **Generate random city coordinates** or **read city data from a file**
- **Compute the MST** using **Prim’s or Kruskal’s algorithm**
- **Construct a 2-approximate TSP path** based on the MST
- **Optional graphical output** (if enabled)
- **Verbose mode available** to display detailed execution steps

## Environment
- **Programming Language**: Java
- **Development Environment**: JDK 17+ (recommended)
- **Dependencies**: None

# Code Explanation

This project implements a **2-Approximation Algorithm for the Traveling Salesman Problem (TSP)** using **Prim's Algorithm** to compute a **Minimum Spanning Tree (MST)** and then constructing an approximate TSP solution. Below is a breakdown of the core files:

### 1. `project.java` - Main Entry Point
- Reads a list of cities from a file (`city.txt`).
- Prompts the user to input the number of cities to use in the TSP simulation.
- Uses `map.java` to randomly select `n` cities.
- Computes the **Minimum Spanning Tree (MST)** using `PrimMST.java`.
- Constructs the TSP path using `CalculatePath.java`.
- Prints the **selected cities, MST edges, and the TSP path**.
- Uses **Java Swing** to visualize the computed TSP path.

### 2. `map.java` - City Data Management
- Reads city coordinates from an input file.
- Maps geographical coordinates into a **300x300 grid**.
- Provides functions to generate a random subset of cities.
- Includes a **distance calculation function** to find the closest city.

### 3. `PrimMST.java` - Minimum Spanning Tree Computation
- Implements **Prim’s Algorithm** to compute the MST.
- Uses a **Priority Queue** to efficiently select edges.
- Outputs a list of **MST edges** connecting the cities.
- Implements **DFS traversal** to construct a pre-order walk for TSP.

### 4. `CalculatePath.java` - TSP Path Construction
- Uses **DFS traversal** of the MST to determine the visiting order of cities.
- Constructs a **TSP tour** by following the MST traversal order.
- Closes the path by returning to the starting city.
- Implements a function to calculate the **total path length**.

### 5. Visualization
- The **`visualizePath`** function in `project.java` uses **Java Swing** to display:
  - Cities as **points on a grid**.
  - The **TSP path** connecting the cities.

## Summary
- The program reads city data, selects a subset, computes an MST, and derives a TSP path.
- Uses **Prim’s Algorithm** to approximate the optimal solution.
- Outputs the computed path and visualizes it.


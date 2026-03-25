# 🥷 Sudoku-Ninja

Sudoku-Ninja is a Java-based desktop Sudoku game built using **Java AWT**.  
The application allows players to generate Sudoku puzzles with different difficulty levels, solve them interactively, get hints, and track their solving time and score.

This project demonstrates **object-oriented design, backtracking algorithms, GUI development, and modular architecture in Java**.

---

## ✨ Features

- 🎮 Interactive Sudoku board with a 9×9 grid
- 🎯 Multiple difficulty levels (Easy, Medium, Hard)
- 🧠 Sudoku solver using the Backtracking algorithm
- 💡 Hint system for stuck players
- ⏱ Real-time timer to track solving time
- 🧮 Dynamic score calculation
- 🔍 Live move validation with incorrect numbers highlighted
- 🔄 Reset option to clear user inputs

---

## 🏗 Project Structure

```
Sudoku-Ninja
│
|
├── com.ronak
    └── Main.java
    ├── gui
    |   ├── GamePanel.java
    |   ├── ControlPanel.java
    |   ├── StatusPanel.java
    |   └── CellField.java
    ├── logic
    |   ├── SudokuSolver.java
    |   ├── SudokuGenerator.java
    |   ├── SudokuValidator.java
    |   └── ScoreCalculator.java
```

### GUI Layer
Handles all visual components and user interactions.

- **GamePanel** – Displays the Sudoku board  
- **CellField** – Custom text field used for Sudoku cells  
- **ControlPanel** – Contains buttons and difficulty selection  
- **StatusPanel** – Shows timer and game status  

### Logic Layer
Contains all Sudoku algorithms and game logic.

- **SudokuSolver** – Solves Sudoku using backtracking  
- **SudokuGenerator** – Generates Sudoku puzzles  
- **SudokuValidator** – Validates board and moves  
- **ScoreCalculator** – Calculates final score  

---

## 🧠 Algorithms Used

### Backtracking
Used to solve Sudoku puzzles by recursively trying numbers in empty cells and backtracking when constraints are violated.

### Randomized Puzzle Generation
A solved Sudoku board is generated first, then numbers are removed based on the selected difficulty while maintaining Sudoku constraints.

### Real-Time Validation
Each move is checked to ensure:

- No duplicate numbers in a row
- No duplicate numbers in a column
- No duplicate numbers in a 3×3 subgrid

---

## 🎮 Game Controls

| Button | Function |
|------|------|
| **New Game** | Generate a new Sudoku puzzle |
| **Solve** | Automatically solve the puzzle |
| **Hint** | Fill one correct value |
| **Reset** | Clear all user inputs |
| **Submit** | Check solution and calculate score |

---

## 🧮 Score Calculation

Score is calculated using:

```
Score = (1000 × DifficultyMultiplier)
        − (TimeInSeconds × 2)
        − (HintsUsed × 50)
```

Difficulty multipliers:

| Difficulty | Multiplier |
|------|------|
| Easy | 1 |
| Medium | 2 |
| Hard | 3 |

---

## 💻 Technologies Used

- Java
- Java AWT
- Object-Oriented Programming
- Backtracking Algorithm

---

# 🚀 How to Run the Project

### 1. Clone the repository

```
git clone https://github.com/your-username/Sudoku-Ninja.git
```

### 2. Navigate to the project folder

```
cd Sudoku-Ninja
```

### 3. Compile the project

```
javac com/ronak/**/*.java
```

### 4. Run the application

```
java com.ronak.Main
```

---

## 👨‍💻 Author

**Ronak Gondaliya**

B.Tech Information Technology  
Dharmsinh Desai University

Interested in **Java Development, Algorithms, and System Design**.

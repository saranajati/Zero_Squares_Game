
public class Square {
      String symbol = "";
      String cubeColor = "";
      String goalColor = "";
      boolean block = false;
      boolean trap = false;
      boolean out = false;
      boolean road = false;
      boolean goal = false;
      boolean cube = false;

      public Square() {
      }

      public Square(Square copy) {
            this.block = copy.block;
            this.trap = copy.trap;
            this.out = copy.out;
            this.road = copy.road;
            this.goal = copy.goal;
            this.cube = copy.cube;
            this.symbol = copy.symbol;
            this.cubeColor = copy.cubeColor;
            this.goalColor = copy.goalColor;
      }

      void setSymbol(String symbol) {
            this.symbol = symbol;
      }

      void setGoalColor(String goalColor) {
            this.goalColor = goalColor;
      }

      void setCubeColor(String cubeColor) {
            this.cubeColor = cubeColor;
      }

      void setBlock(boolean block) {
            this.block = block;
      }

      void setTrap(boolean trap) {
            this.trap = trap;
      }

      void setOut(boolean out) {
            this.out = out;
      }

      void setRoad(boolean road) {
            this.road = road;
      }

      void setGoal(boolean goal) {
            this.goal = goal;
      }

      void setCube(boolean cube) {
            this.cube = cube;
      }
}

public class Main
{
    public static void main(String[] args)
    {
        int X = 10, Y = 10;
  
        // Intiliazing the grid.
        int[][] grid = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
            { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };
  
        // Displaying the grid
        System.out.println("Original Generation");
        for (int i = 0; i < X; i++)
        {
            for (int j = 0; j < Y; j++)
            {
                if (grid[i][j] == 0)
                    System.out.print("-");
                else
                    System.out.print("@");
            }
            System.out.println();
        }
        System.out.println();
        newGeneration(grid, X, Y);
    }
  
    // Function to print new generation
    static void newGeneration(int grid[][], int X, int Y)
    {
        int[][] future = new int[X][Y];
  
        // Loop through every cell
        for (int l = 1; l < X - 1; l++)
        {
            for (int m = 1; m < Y - 1; m++)
            {
                // finding no Of Neighbours that are alive
                int live = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        live += grid[l + i][m + j];
  
                // The cell needs to be subtracted from
                // its neighbours as it was counted before
                live -= grid[l][m];
  
                // Implementing the Rules of Life
  
                // Cell is lonely and dies
                if ((grid[l][m] == 1) && (live < 2))
                    future[l][m] = 0;
  
                // Cell dies due to over population
                else if ((grid[l][m] == 1) && (live > 3))
                    future[l][m] = 0;
  
                // A new cell is born
                else if ((grid[l][m] == 0) && (live == 3))
                    future[l][m] = 1;
  
                // Remains the same
                else
                    future[l][m] = grid[l][m];
            }
        }
  
        System.out.println("New Generation");
        for (int i = 0; i < X; i++)
        {
            for (int j = 0; j < Y; j++)
            {
                if (future[i][j] == 0)
                    System.out.print("-");
                else
                    System.out.print("@");
            }
            System.out.println();
        }
    }
}
class Solution {
    public static void main (String[] args) {
    public Response getResponse(int row, int col) {
    // black box
    }
    public int [] findObject(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int top = 0, left = 0;
        int bottom = m - 1;
        int right = n - 1;
        int columnIndex = binarySearchColumn(grid, left, right);
        int rowIndex = binarySearchColumn(grid, top, bottom);
        return new int []{rowIndex,columnIndex};
    }
    private int binarySearchColumn(int [][] grid, int left, int right){
        while(left <= right){
            int mid = left + (right - left)/2 ;
            int i = 0, j = mid;
            if(getResponse(grid, i , j) == 'Exact' || (getResponse(grid, i , j + 1) != 'Hotter'
            && (getResponse(grid, i , j - 1) != 'Hotter)){
                return mid;
            } else if(getResponse(grid, i , j) == 'Hotter'){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
 private int binarySearchRow(int [][] grid, int top, int bottom){
         while(top <= bottom){
            int mid = top + (bottom - top)/2 ;
            int i = mid, j = 0;
            if(getResponse(grid, i , j) == 'Exact' || (getResponse(grid, i + 1, j) != 'Hotter' 
            && (getResponse(grid, i-1 , j) != 'Hotter)){
                return mid;
            } else if(getResponse(grid, i , j) == 'Hotter'){
                top = mid + 1;
            } else {
                bottom = mid - 1;
            }
        }
        return -1;
    }
} 

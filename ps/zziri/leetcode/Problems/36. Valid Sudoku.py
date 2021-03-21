class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows, columns, cells = [{} for _ in range(9)], [{} for _ in range(9)], [{} for _ in range(9)]
        
        for y in range(9):
            for x in range(9):
                if board[y][x] == '.':
                    continue
                n = int(board[y][x])
                cidx = x//3 + y//3*3
                
                rows[y][n] = rows[y].get(n, 0) + 1
                columns[x][n] = columns[x].get(n, 0) + 1
                cells[cidx][n] = cells[cidx].get(n, 0) + 1
                
                if rows[y][n] > 1 or columns[x][n] > 1 or cells[cidx][n] > 1:
                    return False
        
        return True

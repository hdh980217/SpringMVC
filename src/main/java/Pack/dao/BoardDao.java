package Pack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Pack.dto.BoardDTO;
import Pack.util.JdbcTemplate;

@Repository
public class BoardDao {
	Connection con;
	PreparedStatement pstm;
	ResultSet rs;
	
	void connect(String sql) throws SQLException {
		con = JdbcTemplate.getConnection();
		pstm = con.prepareStatement(sql);	
	}
	
	void close() throws SQLException {
		rs.close();
		pstm.close();
		con.close();
	}
	
	public List<BoardDTO> boardList() {
		String sql = "select boardNo, name, id, title, contents, date from board join user on board.userNo = user.userNo;";
		List<BoardDTO> list = new ArrayList<>();
		
		try {
			connect(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {				
				BoardDTO board = new BoardDTO();
				
				board.setBoardNo(rs.getInt("boardNo"));
				board.setName(rs.getString("name"));
				board.setId(rs.getString("id"));
				board.setTitle(rs.getString("title"));
				board.setContents(rs.getString("contents"));
				board.setDate(rs.getDate("date"));
				
				list.add(board);
			}
			
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		
		return list;
	}
	
	public void newBoard(BoardDTO dto) {
		String sql = "insert into board values(null, ?, ?, ?, now())";
		
		try {
			connect(sql);
		
			pstm.setInt(1, dto.getUserNo());			
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContents());
			
			pstm.execute();
			
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public BoardDTO boardDetail(int boardNo) {
		String sql = "select name, id, title, contents, date from board join user on board.userNo = user.userNo where boardNo = ?;";
		BoardDTO board = null;
		
		try {
			connect(sql);
			pstm.setInt(1, boardNo);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				board = new BoardDTO();
				
				board.setBoardNo(boardNo);
				board.setName(rs.getString("name"));
				board.setId(rs.getString("id"));
				board.setTitle(rs.getString("title"));
				board.setContents(rs.getString("contents"));
				board.setDate(rs.getDate("date"));				
			}
			
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return board;
	}
	
	public void boardDelete(int boardNo) {
		String sql = "delete from board where boardNo = ?";
		
		try {
			connect(sql);
		
			pstm.setInt(1, boardNo);		
			
			pstm.execute();
			
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void boardUpdate(BoardDTO dto) {
		String sql = "update board set title=?, contents=? where boardNo=?";
		
		try {
			connect(sql);
		
			pstm.setString(1, dto.getTitle());		
			pstm.setString(2, dto.getContents());		
			pstm.setInt(3, dto.getBoardNo());		
			
			pstm.execute();
			
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

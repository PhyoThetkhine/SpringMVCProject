package com.spring.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.spring.model.BookBean;


@Repository
public class BookRepository {
	public List<BookBean> showAllBook(){
		List<BookBean> bookList = new ArrayList<BookBean>();
		
		BookBean book = null;
		Connection con = UserConnection.getConnection();
		String sql ="SELECT * FROM book WHERE status<>0";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				book = new BookBean();
				book.setId(rs.getInt(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getDouble(4));
				
				bookList.add(book);
				
				
			}
			
		} catch (SQLException e) {
			System.out.println("Book List "+e.getMessage());
			
		}

	return bookList;
	}
	
	public int deleteBookById(int id) {
		int rowsAffected = 0;
		Connection con = UserConnection.getConnection();
		String sql = "DELETE FROM book WHERE id = ?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			rowsAffected = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("DeleteBook Error:"+e.getMessage());
		}
	return rowsAffected;
	}
	public int insertBook(BookBean bean) {
		int i = 0;
		 Connection con= UserConnection.getConnection();
		 String sql = "insert into book(title,author,price) values(?,?,?)";
		 try {
			 PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, bean.getTitle());
			ps.setString(2, bean.getAuthor());
			ps.setDouble(3, bean.getPrice());
			
			i=ps.executeUpdate();
		
		} catch (SQLException e) {
		System.out.println("Insert error:" +e.getMessage());
		
		}
		return i;
	}
	public BookBean showBookById(int bookId){
		
		BookBean book = null;
		Connection con = UserConnection.getConnection();
		String sql ="SELECT * FROM book WHERE id = ?";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, bookId);			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				book = new BookBean();
				book.setId(rs.getInt(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getDouble(4));	
				
			}
			
		} catch (SQLException e) {
			System.out.println("ShowBookBy ID error:"+e.getMessage());
			
		}

		 return book;
	}
	public int updateBook(BookBean bean) {
		int i=0;
		 Connection con= UserConnection.getConnection();
		 String sql = "update book set title=?,author=?,price=? where id=?";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, bean.getTitle());
			ps.setString(2, bean.getAuthor());
			ps.setDouble(3, bean.getPrice());
			ps.setInt(4,bean.getId());
			
				i =	ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("update book error:"+e.getMessage());
		}
		 
		
		return i;
		
	}
	public int deleteBook(int id) {
		int i =0;
		Connection con = UserConnection.getConnection();
		String sql = "UPDATE book SET status=0 WHERE id = ?";
		 try {
				PreparedStatement ps=con.prepareStatement(sql);
				
				ps.setInt(1,id);
				
					i =	ps.executeUpdate();
			} catch (SQLException e) {
				System.out.println("delete book error:"+e.getMessage());
			}
			 
			
	return i;
	}
	
	
	
	

}

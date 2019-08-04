package review;

import java.util.List;

public interface ReviewDAO {
	public List<ReviewVO> findAll() throws Exception; // 전체 리스트 
	public List<ReviewVO> find( ReviewVO vo ) throws Exception; // 검색 
	public int insert( ReviewVO vo ) throws Exception; // 테스트용(없앨거임)
	public int modify( ReviewVO vo ) throws Exception;
	public int delete( ReviewVO vo ) throws Exception;
}

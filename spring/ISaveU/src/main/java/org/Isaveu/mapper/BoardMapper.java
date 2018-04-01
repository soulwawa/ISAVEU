package org.Isaveu.mapper;

import java.util.List;

import org.Isaveu.domain.TbBoardVO;
import org.springframework.stereotype.Repository;

@Repository("org.Isaveu.mapper.BoardMapper")
public interface BoardMapper {
	public void create(TbBoardVO vo) throws Exception;
	public TbBoardVO read(Integer bno) throws Exception;
	public void update(TbBoardVO vo) throws Exception;
	public void delete(Integer bno) throws Exception;
	public List<TbBoardVO> listAll() throws Exception;
}

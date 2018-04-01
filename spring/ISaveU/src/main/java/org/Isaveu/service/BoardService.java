package org.Isaveu.service;

import java.util.List;

import javax.annotation.Resource;

import org.Isaveu.domain.TbBoardVO;
import org.Isaveu.mapper.BoardMapper;
import org.springframework.stereotype.Service;

@Service("org.Isaveu.service.BoardService")
public class BoardService implements BoardMapper{
	
	@Resource(name = "org.Isaveu.mapper.BoardMapper")
	BoardMapper bMapper;

	@Override
	public void create(TbBoardVO vo) throws Exception {
		bMapper.create(vo);
	}

	@Override
	public TbBoardVO read(Integer bno) throws Exception {
		return bMapper.read(bno);
	}

	@Override
	public void update(TbBoardVO vo) throws Exception {
		bMapper.update(vo);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		bMapper.delete(bno);
	}

	@Override
	public List<TbBoardVO> listAll() throws Exception {
		return bMapper.listAll();
	}
	

}

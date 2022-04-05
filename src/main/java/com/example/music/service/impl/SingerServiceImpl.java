package com.example.music.service.impl;

import com.example.music.dao.SingerMapper;
import com.example.music.domain.Singer;
import com.example.music.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 歌手Service实现类
 */
@Service
public class SingerServiceImpl implements SingerService {

    @Autowired
    SingerMapper singerMapper;
    /**
     * 增加
     * @param singer
     * @return
     */
    @Override
    public boolean insert(Singer singer) {
        return singerMapper.insert(singer)>0;
    }

    /**
     * 修改
     * @param singer
     * @return
     */
    @Override
    public boolean update(Singer singer) {
        return singerMapper.update(singer)>0;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public boolean delete(Integer id) {
        return singerMapper.delete(id)>0;
    }

    /**
     * select by id
     * @param id
     * @return
     */
    @Override
    public Singer selectByPrimaryKey(Integer id) {
        return singerMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有歌手
     * @return
     */
    @Override
    public List<Singer> allSinger() {
        return singerMapper.allSinger();
    }

    /**
     * 按姓名查询歌手
     * @param name
     * @return
     */
    @Override
    public List<Singer> singerOfName(String name) {
        return singerMapper.singerOfName(name);
    }

    /**
     * 按性别查询歌手
     * @param sex
     * @return
     */
    @Override
    public List<Singer> singerOfSex(Integer sex) {
        return singerMapper.singerOfSex(sex);
    }
}

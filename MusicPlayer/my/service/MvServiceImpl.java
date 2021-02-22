package com.my.service;



import com.my.dao.MvMapper;
import com.my.pojo.Mv;


import java.util.List;

public class MvServiceImpl implements MvService {
    //调用dao层的操作，设置一个set接口，方便Spring管理

    private MvMapper mvMapper;
    public void setMvMapper(MvMapper mvMapper) {
        this.mvMapper = mvMapper;
    }


    public List<Mv> findMv() {
        return mvMapper.findMv();
    }

    public Mv findMvById(int id) {
        return mvMapper.findMvById(id);
    }

    public List<Mv> findMvByStr(String str) {
        return mvMapper.findMvByStr(str);
    }

    public int AddMv(Mv mv) {
        return mvMapper.AddMv(mv);
    }

    public int deleteMvById(int id) {
        return mvMapper.deleteMvById(id);
    }

    public boolean findLoverMvById(int mvId) {
        if(mvMapper.findLoverMvById(mvId) == null){
            return false;
        }else {
            return true;
        }
    }

    public int removeLoveMvDelete(int mvId) {
        return mvMapper.removeLoveMvDelete(mvId);
    }

    public boolean findLoveMvByMvIdAndUserId(int userId, int mvId) {
        if(  mvMapper.findLoveMvByMvIdAndUserId(userId, mvId) == null){
            return false;
        }else {
            return true;
        }
    }

    public boolean insertLoveMv(int userId, int mvId) {
        if(  mvMapper.insertLoveMv(userId, mvId) == 1){
            return true;
        }else {
            return false;
        }
    }

    public int removeLoveMv(int userId, int mvId) {
        return mvMapper.removeLoveMv(userId, mvId);
    }

    public List<Mv> findLoveMvByUserId(int userId) {
        return mvMapper.findLoveMvByUserId(userId);
    }

    public List<Mv> findLoveMvByStr(String str, int userId) {
        return mvMapper.findLoveMvByStr(str, userId);
    }
}

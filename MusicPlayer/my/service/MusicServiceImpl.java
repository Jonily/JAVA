package com.my.service;

import com.my.dao.MusicMapper;
import com.my.pojo.Music;

import java.util.List;

public class MusicServiceImpl implements MusicService{

    //调用dao层的操作，设置一个set接口，方便Spring管理

    private MusicMapper musicMapper;
    public void setMusicMapper(MusicMapper musicMapper) {
        this.musicMapper = musicMapper;
    }


    public List<Music> findMusic() {
        return musicMapper.findMusic();
    }

    public Music findMusicById(int id) {
        return musicMapper.findMusicById(id);
    }

    public List<Music> findMusicByStr(String str) {
        return musicMapper.findMusicByStr(str);
    }

    public int AddMusic(Music music) {
        return musicMapper.AddMusic(music);
    }

    public int deleteMusicById(int id) {
        return musicMapper.deleteMusicById(id);
    }

    public boolean findLoverMusicById(int musicId) {
        if(musicMapper.findLoverMusicById(musicId) == null){
            return false;
        }else {
            return true;
        }
    }

    public int removeLoveMusicDelete(int musicId) {
        return musicMapper.removeLoveMusicDelete(musicId);
    }

    public boolean findLoveMusicByMusicIdAndUserId(int userId, int musicId) {
        if(  musicMapper.findLoveMusicByMusicIdAndUserId(userId, musicId) == null){
            return false;
        }else {
            return true;
        }
    }

    public boolean insertLoveMusic(int userId, int musicId) {
        if(  musicMapper.insertLoveMusic(userId, musicId) == 1){
            return true;
        }else {
            return false;
        }
    }

    public int removeLoveMusic(int userId, int musicId) {
        return musicMapper.removeLoveMusic(userId, musicId);
    }

    public List<Music> findLoveMusicByUserId(int userId) {
        return musicMapper.findLoveMusicByUserId(userId);
    }

    public List<Music> findLoveMusicByStr(String str, int userId) {
        return musicMapper.findLoveMusicByStr(str, userId);
    }
}

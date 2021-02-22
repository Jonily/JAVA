package com.my.service;

import com.my.pojo.Mv;



import java.util.List;

public interface MvService {
    /*
     * 1 查询全部mv
     */
    List<Mv> findMv();

    /*
     * 2 根据id查找mv
     */
    Mv findMvById(int id);

    /*
     * 3 根据关键字查找mv歌单
     */
    List<Mv> findMvByStr(String str);

    /* 4
     * 上传音乐可以直接传入一个Mv对象
     * 先把文件给服务器
     * 之后给数据库
     * 下面就是将文件放到数据库中*/
    int AddMv(Mv mv);

    //5、通过ID删除mv
    int deleteMvById(int id);

    //6、查看中间表是否有该IDmv
    boolean findLoverMvById(int mvId);

    /* 7
     * 删除服务器上的mv时，同时在我喜欢的列表的数据库中进行删除*/
    int removeLoveMvDelete(int mvId);

    /* 8 添加喜欢的mv的时候，需要先判断该音乐是否存在
     */
    boolean findLoveMvByMvIdAndUserId(int userId, int mvId);

    /* * 9
     * 添加mv到“喜欢”列表中
     * 用户-》音乐
     * 多对多
     * 需要中间表*/
    boolean insertLoveMv(int userId, int mvId);

    /*  * 10
     * 移除喜欢的mv
     * userId 用户id
     * musicId 歌曲id
     * 返回受影响的行数
     * 移除当前用户喜欢的这首音乐，因为同一首音乐可能多个用户喜欢*/
    int removeLoveMv(int userId, int mvId);

    //11查询用户喜欢的全部歌单
    List<Mv> findLoveMvByUserId(int userId);
    /* 12
     * 根据关键字查询喜欢的歌单
     * @param str
     * @return*/
    List<Mv> findLoveMvByStr(String str, int userId);

}

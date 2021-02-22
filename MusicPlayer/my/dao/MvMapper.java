package com.my.dao;

import com.my.pojo.Music;
import com.my.pojo.Mv;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MvMapper {

    /*
     * 1
     * 查询全部歌单
     */
    List<Mv> findMv();
    /*
     * 2
     * 根据id查找音乐
     */
    Mv findMvById(@Param("id") int id);
    /*
     * 3 根据关键字查找音乐歌单
     */
    List<Mv> findMvByStr(@Param("str") String str);

    /* 4
     * 上传音乐可以直接传入一个Music对象
     * 先把文件给服务器
     * 之后给数据库
     * 下面就是将文件放到数据库中*/
    int AddMv(Mv mv);

    //5、通过ID删除歌曲
    int deleteMvById(@Param("id") int id);

    //6、查看中间表是否有该ID歌曲
    Mv findLoverMvById(@Param("mvId") int mvId);

    /* 7
     * 删除服务器上的音乐时，同时在我喜欢的列表的数据库中进行删除*/
    int removeLoveMvDelete(@Param("mvId") int mvId);

    /* 8 添加喜欢的音乐的时候，需要先判断该音乐是否存在
     * musicId
     */
    Mv findLoveMvByMvIdAndUserId(@Param("userId") int userId, @Param("mvId") int mvId);

    /* * 9
     * 添加音乐到“喜欢”列表中
     * 用户-》音乐
     * 多对多
     * 需要中间表*/
    int insertLoveMv(@Param("userId") int userId, @Param("mvId") int mvId);

    /*  * 10
     * 移除喜欢的音乐
     * userId 用户id
     * musicId 歌曲id
     * 返回受影响的行数
     * 移除当前用户喜欢的这首音乐，因为同一首音乐可能多个用户喜欢*/
    int removeLoveMv(@Param("userId") int userId, @Param("mvId") int mvId);

    //11查询用户喜欢的全部歌单
    List<Mv> findLoveMvByUserId(@Param("userId") int userId);
    /* 12
     * 根据关键字查询喜欢的歌单
     * @param str
     * @return*/

    List<Mv> findLoveMvByStr(@Param("str") String str, @Param("userId") int userId);

}

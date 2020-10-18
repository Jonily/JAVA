package huangzhuolin.mapper;

import huangzhuolin.base.BaseMapper;
import huangzhuolin.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
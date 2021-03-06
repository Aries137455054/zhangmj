package wymb.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import tk.mybatis.mapper.common.Mapper;
import wymb.domain.User;

public interface UserMapper extends Mapper<User> {

	User getUserByUserName(String userName);
	
	List<User> getUserByUserName1(String userName);

	void deleteBatchByIds(@Param("ids") String[] idsStr);

	void deleteUserRoleByUserId(Integer userId);

	void saveUserRole(@Param("list") List<Map<String, Integer>> params);

}

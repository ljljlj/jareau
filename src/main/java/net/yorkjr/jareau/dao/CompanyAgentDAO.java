package net.yorkjr.jareau.dao;

import net.yorkjr.jareau.pojo.CompanyAgent;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by tylaar on 15/1/10.
 */
public interface CompanyAgentDAO {
    @Select("select * from company_agents where agent_id = #{agentId}")
    CompanyAgent getCompanyAgentById(@Param("agentId") long agentId);

}
